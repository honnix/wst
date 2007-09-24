/**
 * Workstation.java
 * Sep 24, 2007
 */
package com.ericsson.wst.core.data;

import java.util.List;

import com.ericsson.wst.command.Command;

/**
 * @author ehonlia
 * 
 */
public class Workstation
{
    private List<Command> commandList;

    private String host;

    private int port;

    public Workstation()
    {

    }

    public Workstation(String host, int port, List<Command> commandList)
    {
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
