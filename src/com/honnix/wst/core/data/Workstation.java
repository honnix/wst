/**
 * Workstation.java
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
package com.honnix.wst.core.data;

import java.util.List;

import com.honnix.wst.command.Command;

/**
 * 
 * 
 */
public class Workstation
{

    private List<Command> commandList;

    private String host;

    private int port;

    public Workstation()
    {
        super();
    }

    public Workstation(String host, int port, List<Command> commandList)
    {
        super();

        this.host = host;
        this.port = port;
        this.commandList = commandList;
    }

    public List<Command> getCommandList()
    {
        return commandList;
    }

    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    public void setCommandList(List<Command> commandList)
    {
        this.commandList = commandList;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

}
