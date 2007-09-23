/**
 * TestLocalConnection.java
 *
 * Sep 22, 2007
 */
package com.ericsson.wst.core.network.connection;

import com.ericsson.wst.constant.SystemProperties;
import com.ericsson.wst.core.network.workflow.Communicator;
import com.ericsson.wst.error.NetworkException;

import junit.framework.TestCase;

/**
 * @author honnix
 *
 */
public class TestLocalConnection
    extends TestCase
{
    private Connection connection = new LocalConnection();
    
    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }

    public void testConnectClose()
    {
        try
        {
            connection.connect("localhost", 0);
        }
        catch (NetworkException e1)
        {
            e1.printStackTrace();
        }

        Communicator communicator = null;

        try
        {
            if (connection.isConnected())
            {
                communicator =
                        new Communicator(connection.getInputStream(),
                                connection.getOutputStream());
            }
            else
            {
                assertTrue(false);
            }
        }
        catch (NetworkException e)
        {
            e.printStackTrace();

            assertTrue(false);
        }

        assertEquals("Linux" + SystemProperties.LINE_SEPARATOR, communicator.sendAndReceive("uname"));
        
        try
        {
            connection.close();
        }
        catch (NetworkException e)
        {
            e.printStackTrace();
            
            assertTrue(false);
        }
    }
}
