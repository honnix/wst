/**
 * CommandFactory.java
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
package com.honnix.wst.core.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.honnix.wst.command.Command;

/**
 * 
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
        super();

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
        Command newCommand = null;

        if (command == null)
        {
            newCommand = Command.FALLBACK_COMMAND;
        }
        else
        {
            newCommand = command.makeSelf();
        }

        return newCommand;
    }

}
