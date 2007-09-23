/**
 * TestWorkstationFileReader.java
 * Sep 17, 2007
 */
package com.ericsson.wst.core.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.ericsson.wst.constant.SystemProperties;
import com.ericsson.wst.error.WorkstationFileReadException;

import junit.framework.TestCase;

/**
 * @author ehonlia
 * 
 */
public class TestWorkstationFileReader
        extends TestCase
{
    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp()
            throws Exception
    {
        super.setUp();
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown()
            throws Exception
    {
        super.tearDown();
    }

    public void testRead()
    {
        File testFile = new File(System.getProperty("user.home"), ".wst-test");
        PrintWriter pw = null;
        try
        {
            pw = new PrintWriter(testFile);
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        pw.println("w1:23 -t -w -u");
        pw.println("w2:23 -t -w -u");
        pw.flush();
        pw.close();

        Map<String, List<String>> indicatorMap = null;

        try
        {
            indicatorMap =
                    WorkstationFileReader.read(System.getProperty("user.home")
                            + "/.wst-test");
        }
        catch (WorkstationFileReadException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertEquals("-t", indicatorMap.get("w1:23").get(0));
        assertEquals("-w", indicatorMap.get("w1:23").get(1));
        assertEquals("-u", indicatorMap.get("w1:23").get(2));

        assertEquals("-t", indicatorMap.get("w2:23").get(0));
        assertEquals("-w", indicatorMap.get("w2:23").get(1));
        assertEquals("-u", indicatorMap.get("w2:23").get(2));

        testFile.delete();
    }

    public void testReadDefault()
    {
        File file = new File(SystemProperties.USER_HOME, ".wst");

        try
        {
            WorkstationFileReader.read(SystemProperties.USER_HOME
                    + "/.wst-test");
        }
        catch (WorkstationFileReadException e)
        {
            assertFalse(file.exists());

            return;
        }

        assertTrue(file.exists());
    }
}
