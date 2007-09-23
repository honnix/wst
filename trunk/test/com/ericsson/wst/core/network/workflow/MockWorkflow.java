/**
 * MockWorkflow.java
 * Sep 13, 2007
 */
package com.ericsson.wst.core.network.workflow;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.ericsson.wst.core.network.connection.Connection;

/**
 * @author ehonlia
 * 
 */
public class MockWorkflow
        implements Workflow
{
    private Communicator communicator;

    private Connection connection;

    private StringBuilder sb;

    public MockWorkflow(Properties properties)
    {
        sb = new StringBuilder();
        InputStream is = new MockInputStream(sb);
        OutputStream os = new MockOutputStream(sb);

        communicator = new Communicator(is, os);

        try
        {
            connection =
                    (Connection) Class.forName(
                            properties.getProperty("connection")).newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.core.workflow.Workflow#getCommunicator()
     */
    public Communicator getCommunicator()
    {
        return communicator;
    }

    public Class<? extends Connection> getConnectionClass()
    {
        return connection.getClass();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.core.workflow.Workflow#login(java.lang.String,
     *      java.lang.String)
     */
    public void login(String host)
    {
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.core.workflow.Workflow#logout()
     */
    public void logout()
    {
    }

}
