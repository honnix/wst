/**
 * Communicator.java
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;

import com.honnix.wst.constant.SystemProperties;

/**
 * 
 * 
 */
public class Communicator
{

    private InputStream is;

    private OutputStream os;

    public Communicator(InputStream is, OutputStream os)
    {
        super();

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
        catch (SocketTimeoutException e) // NOPMD by honnix on 4/17/08 10:09 PM
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
