/**
 * TelnetConnection.java
 * Sep 14, 2007
 */
package com.ericsson.wst.core.network.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;

import org.apache.commons.net.telnet.TelnetClient;

import com.ericsson.wst.error.NetworkException;

/**
 * @author ehonlia
 * 
 */
public class TelnetConnection
        implements Connection
{
    private TelnetClient client;

    public TelnetConnection()
    {
        client = new TelnetClient();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.core.network.Connection#close()
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
     * @see com.ericsson.wst.core.network.Connection#connect()
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
        catch (SocketTimeoutException e)
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
        if (client == null)
        {
            return false;
        }
        else
        {
            return client.isConnected();
        }
    }

}
