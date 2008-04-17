/**
 * CommandLoader.java
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

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.honnix.wst.command.Command;
import com.honnix.wst.error.PropertiesFileNotFoundException;
import com.honnix.wst.util.PropertiesLoader;

/**
 * 
 * 
 */
public final class CommandLoader
{

    public static List<String> getAllIndicators()
    {
        return CommandFactory.getInstance().getAllIndicators();
    }

    public static void loadCommand()
        throws PropertiesFileNotFoundException
    {
        Properties properties = null;

        try
        {
            properties = PropertiesLoader.loadProperties("command.properties");
        }
        catch (IOException e)
        {
            throw new PropertiesFileNotFoundException(
                    "Properties file not found in CLASSPATH.", e);
        }

        Set<Object> indicatorSet = properties.keySet();

        for (Object object : indicatorSet)
        {
            String indicator = (String) object;

            Command command = null;
            try
            {
                command =
                        (Command) Class.forName(
                                properties.getProperty(indicator))
                                .getConstructor(String.class).newInstance(
                                        indicator);
            }
            catch (Exception e)
            {
                e.printStackTrace();

                continue;
            }

            CommandFactory.getInstance().insertCommandPrototype(command);
        }
    }

    public static void unloadCommand()
    {
        CommandFactory.getInstance().clear();
    }

    private CommandLoader()
    {
        super();
    }

}
