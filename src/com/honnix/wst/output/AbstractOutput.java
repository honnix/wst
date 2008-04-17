/**
 * StandardOutput.java
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
package com.honnix.wst.output;

import java.util.List;

/**
 * 
 * 
 */
public abstract class AbstractOutput
    implements Output
{

    protected String host;

    protected int port;

    public AbstractOutput()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.output.Output#output(java.util.List)
     */
    public abstract void output(List<String> responseList);

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.output.Output#setHost(java.lang.String)
     */
    public void setHost(String host)
    {
        this.host = host;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.output.Output#setPort(int)
     */
    public void setPort(int port)
    {
        this.port = port;
    }

}
