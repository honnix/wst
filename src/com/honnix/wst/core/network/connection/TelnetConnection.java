/**
 * TelnetConnection.java
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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;

import org.apache.commons.net.telnet.TelnetClient;

import com.honnix.wst.error.NetworkException;

/**
 * 
 * 
 */
public class TelnetConnection
    implements Connection
{

    private TelnetClient client;

    public TelnetConnection()
    {
        super();

        client = new TelnetClient();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.network.Connection#close()
     */
    public void close()
        throws NetworkException
    {
        try
        {
            client.disconnect();
        }
        catch (IOException e)
        {
            throw new NetworkException("Close connection failed.", e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.network.Connection#connect()
     */
    public void connect(String host, int port)
        throws NetworkException
    {
        try
        {
            client.connect(host, port);
            client.setSoTimeout(1000);
        }
        catch (Exception e)
        {
            throw new NetworkException("Could not connect to host.", e);
        }

        try
        {
            while (client.getInputStream().read() != -1)
            {
                // Here to remove warning from Checkstyle.
                continue;
            }
        }
        catch (SocketTimeoutException e) // NOPMD by honnix on 4/17/08 10:21 PM
        {
            // Ignore this kind of exception
        }
        catch (IOException e)
        {
            throw new NetworkException("Could not read welcome message.", e);
        }
    }

    public InputStream getInputStream()
        throws NetworkException
    {
        return client.getInputStream();
    }

    public OutputStream getOutputStream()
        throws NetworkException
    {
        return client.getOutputStream();
    }

    public boolean isConnected()
    {
        boolean result = false;

        if (client != null)
        {
            result = client.isConnected();
        }

        return result;
    }

}
