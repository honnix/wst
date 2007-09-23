/**
 * Connection.java
 * Sep 14, 2007
 */
package com.ericsson.wst.core.network.connection;

import java.io.InputStream;
import java.io.OutputStream;

import com.ericsson.wst.error.NetworkException;

/**
 * @author ehonlia
 * 
 */
public interface Connection
{
    void close()
            throws NetworkException;

    void connect(String host, int port)
            throws NetworkException;

    InputStream getInputStream()
            throws NetworkException;

    OutputStream getOutputStream()
            throws NetworkException;

    boolean isConnected();
}
