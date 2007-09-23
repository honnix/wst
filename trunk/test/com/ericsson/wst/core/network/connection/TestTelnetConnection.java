/**
 * TestTelnetConnection.java
 * Sep 14, 2007
 */
package com.ericsson.wst.core.network.connection;

import junit.framework.TestCase;

import com.ericsson.wst.core.network.workflow.Communicator;
import com.ericsson.wst.error.NetworkException;

/**
 * @author ehonlia
 * 
 */
public class TestTelnetConnection
        extends TestCase
{
    private Connection connection = new TelnetConnection();

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

    public void testConnectClose()
    {
        try
        {
            connection.connect("localhost", 23);
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

        assertEquals("Password: ", communicator.sendAndReceive("ehonlia"));
        
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
