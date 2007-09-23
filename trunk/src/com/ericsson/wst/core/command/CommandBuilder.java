/**
 * CommandBuilder.java
 * Sep 12, 2007
 */
package com.ericsson.wst.core.command;

import java.util.ArrayList;
import java.util.List;

import com.ericsson.wst.command.Command;

/**
 * @author ehonlia
 * 
 */
public final class CommandBuilder
{
    public static List<Command> buildCommand(List<String> indicatorList)
    {
        List<Command> commandList = new ArrayList<Command>();

        for (String indicator : indicatorList)
        {
            commandList.add(CommandFactory.getInstance().produceCommand(
                    indicator));
        }

        return commandList;
    }

    private CommandBuilder()
    {

    }
}
