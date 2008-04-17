/**
 * WSTWorkflow.java
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
package com.honnix.wst.core.network.workflow;

import java.util.Properties;

import com.honnix.wst.core.network.connection.Connection;
import com.honnix.wst.error.NetworkException;

/**
 * 
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
        super();

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
