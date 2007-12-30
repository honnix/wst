/**
 * WSTWorkflow.java
 * Sep 13, 2007
 */
package com.honnix.wst.core.network.workflow;

import java.util.Properties;

import com.honnix.wst.core.network.connection.Connection;
import com.honnix.wst.error.NetworkException;

/**
 * @author ehonlia
 * 
 */
public class WSTWorkflow
        implements Workflow
{
    private Communicator communicator;

    private Connection connection;

    private String passwd;

    private String user;

    public WSTWorkflow(Properties properties)
    {
        user = properties.getProperty("user");
        passwd = properties.getProperty("passwd");

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

    public Communicator getCommunicator()
    {
        return communicator;
    }

    public Class<? extends Connection> getConnectionClass()
    {
        return connection.getClass();
    }

    public void login(String host, int port)
    {
        try
        {
            connection.connect(host, port);
        }
        catch (NetworkException e)
        {
            e.printStackTrace();
        }

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
                throw new NetworkException("Connection has not established.");
            }
        }
        catch (NetworkException e)
        {
            e.printStackTrace();
        }

        communicator.sendAndReceive(user);
        communicator.sendAndReceive(passwd);
    }

    public void logout()
    {
        try
        {
            connection.close();
        }
        catch (NetworkException e)
        {
            e.printStackTrace();
        }
    }

}