/**
 * LocalConnection.java
 *
 * Sep 22, 2007
 */
package com.honnix.wst.core.network.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import com.honnix.wst.constant.SystemProperties;
import com.honnix.wst.error.NetworkException;

/**
 * @author honnix
 * 
 */
public class LocalConnection
        implements Connection
{
    private class MyInputStream
            extends InputStream
    {
        private StringBuilder sb = new StringBuilder();

        private int pos = 0;

        @Override
        public int read()
                throws IOException
        {
            if (pos < sb.length())
            {
                return sb.charAt(pos++);
            }
            else
            {
                sb.delete(0, pos);
                pos = 0;

                return -1;
            }
        }

    }

    private class ProcessManager
    {
        public void run(List<String> command)
        {
            try
            {
                Process process = new ProcessBuilder(command).start();
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(process
                                .getInputStream()));
                String line = null;

                while ((line = br.readLine()) != null)
                {
                    is.sb.append(line).append(SystemProperties.LINE_SEPARATOR);
                }

                process.waitFor();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    private MyInputStream is = new MyInputStream();

    private boolean isConnected;

    private OutputStream os = new OutputStream() {
        private StringBuilder sb = new StringBuilder();

        @Override
        public void write(int b)
                throws IOException
        {
            sb.append((char) b);

            String rawCommand = sb.toString();
            int index = rawCommand.indexOf(SystemProperties.LINE_SEPARATOR);

            if (index != -1)
            {
                if (rawCommand.indexOf("******") == -1)
                {
                    String command = rawCommand.substring(0, index);
                    String[] tmp = command.split("\\s+");

                    processManager.run(Arrays.asList(tmp));
                }

                sb.delete(0, sb.length());
            }
        }

    };

    private ProcessManager processManager = new ProcessManager();

    public LocalConnection()
    {
        isConnected = false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.network.connection.Connection#close()
     */
    public void close()
            throws NetworkException
    {
        isConnected = false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.network.connection.Connection#connect(java.lang.String,
     *      int)
     */
    public void connect(String host, int port)
            throws NetworkException
    {
        isConnected = true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.network.connection.Connection#getInputStream()
     */
    public InputStream getInputStream()
            throws NetworkException
    {
        return is;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.network.connection.Connection#getOutputStream()
     */
    public OutputStream getOutputStream()
            throws NetworkException
    {
        return os;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.network.connection.Connection#isConnected()
     */
    public boolean isConnected()
    {
        return isConnected;
    }

}
