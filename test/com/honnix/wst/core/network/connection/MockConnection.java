/**
 * MockConnection.java
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

import java.io.InputStream;
import java.io.OutputStream;

import com.honnix.wst.error.NetworkException;

/**
 * 
 * 
 */
public class MockConnection
    implements Connection
{

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.network.Connection#close()
     */
    public void close()
        throws NetworkException
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.network.Connection#connect()
     */
    public void connect(String host, int port)
        throws NetworkException
    {
        // TODO Auto-generated method stub

    }

    public InputStream getInputStream()
        throws NetworkException
    {
        // TODO Auto-generated method stub
        return null;
    }

    public OutputStream getOutputStream()
        throws NetworkException
    {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isConnected()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
