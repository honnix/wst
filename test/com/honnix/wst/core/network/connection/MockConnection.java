/**
 * MockConnection.java
 * Sep 14, 2007
 */
package com.honnix.wst.core.network.connection;

import java.io.InputStream;
import java.io.OutputStream;

import com.honnix.wst.core.network.connection.Connection;
import com.honnix.wst.error.NetworkException;

/**
 * @author ehonlia
 * 
 */
public class MockConnection
        implements Connection
{

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.core.network.Connection#close()
     */
    public void close()
            throws NetworkException
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.core.network.Connection#connect()
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
