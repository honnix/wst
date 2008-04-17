/**
 * TestWorkstationFileReader.java
 * 
 * Copyright : (C) 2008 by Honnix
 * Email     : hxliang1982@gmail.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.honnix.wst.core.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.honnix.wst.constant.SystemProperties;
import com.honnix.wst.error.WorkstationFileReadException;

/**
 * 
 * 
 */
public class TestWorkstationFileReader
    extends TestCase
{

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

        assertEquals("", "-t", indicatorMap.get("w1:23").get(0));
        assertEquals("", "-w", indicatorMap.get("w1:23").get(1));
        assertEquals("", "-u", indicatorMap.get("w1:23").get(2));

        assertEquals("", "-t", indicatorMap.get("w2:23").get(0));
        assertEquals("", "-w", indicatorMap.get("w2:23").get(1));
        assertEquals("", "-u", indicatorMap.get("w2:23").get(2));

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
            assertFalse("", file.exists());

            return;
        }

        assertTrue("", file.exists());
    }
}
