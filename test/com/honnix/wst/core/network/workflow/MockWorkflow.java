/**
 * MockWorkflow.java
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

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.honnix.wst.core.network.connection.Connection;

/**
 * 
 * 
 */
public class MockWorkflow
    implements Workflow
{

    private Communicator communicator;

    private Connection connection;

    public MockWorkflow(Properties properties)
    {
        StringBuilder sb = new StringBuilder();
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
     * @see com.honnix.wst.core.workflow.Workflow#getCommunicator()
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
     * @see com.honnix.wst.core.workflow.Workflow#login(java.lang.String,
     *      java.lang.String)
     */
    public void login(String host, int port)
    {
        // This is just a mock class.
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.workflow.Workflow#logout()
     */
    public void logout()
    {
        // This is just a mock class.
    }

}
