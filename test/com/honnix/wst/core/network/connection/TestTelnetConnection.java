/**
 * TestTelnetConnection.java
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
package com.honnix.wst.core.network.connection;

import junit.framework.TestCase;

import com.honnix.wst.core.network.workflow.Communicator;
import com.honnix.wst.error.NetworkException;

/**
 * 
 * 
 */
public class TestTelnetConnection
    extends TestCase
{

    private Connection connection = new TelnetConnection();

    public void testConnectClose()
    {
        try
        {
            connection.connect("150.236.41.101", 23); // NOPMD by honnix on 4/17/08 10:20 PM
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
                fail();
            }
        }
        catch (NetworkException e)
        {
            e.printStackTrace();

            fail();
        }

        assertEquals("", "Password: ", communicator.sendAndReceive("honnix"));

        try
        {
            connection.close();
        }
        catch (NetworkException e)
        {
            e.printStackTrace();

            fail();
        }
    }
}
