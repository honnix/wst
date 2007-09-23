/**
 * CommandFactory.java
 * Sep 11, 2007
 */
package com.ericsson.wst.core.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ericsson.wst.command.Command;

/**
 * @author ehonlia
 * 
 */
public final class CommandFactory
{
    private static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance()
    {
        return instance;
    }

    private Map<String, Command> commandMap;

    private CommandFactory()
    {
        commandMap = new HashMap<String, Command>();
    }

    public void clear()
    {
        commandMap.clear();
    }

    public List<String> getAllIndicators()
    {
        return new ArrayList<String>(commandMap.keySet());
    }

    public void insertCommandPrototype(Command command)
    {
        commandMap.put(command.getIndicator(), command);
    }

    public Command produceCommand(String indicator)
    {
        Command command = commandMap.get(indicator);

        if (command == null)
        {
            return Command.FALLBACK_COMMAND;
        }

        return command.makeSelf();
    }
}
