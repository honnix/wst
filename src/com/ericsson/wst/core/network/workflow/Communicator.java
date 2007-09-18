/**
 * Communicator.java
 * Sep 13, 2007
 */
package com.ericsson.wst.core.network.workflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;

import com.ericsson.wst.constant.SystemProperties;

/**
 * @author ehonlia
 * 
 */
public class Communicator
{
    private InputStream is;

    private OutputStream os;

    public Communicator(InputStream is, OutputStream os)
    {
        this.is = is;
        this.os = os;
    }

    public String sendAndReceive(String command)
    {
        PrintWriter pw = new PrintWriter(os);

        pw.write(command);
        pw.write(SystemProperties.LINE_SEPARATOR);
        pw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        try
        {
            int c;

            while ((c = br.read()) != -1)
            {
                sb.append((char) c);
            }
        }
        catch (SocketTimeoutException e)
        {
            // Ignore this kind of exception
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
