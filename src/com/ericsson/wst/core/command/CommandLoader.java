/**
 * CommandLoader.java
 * Sep 11, 2007
 */
package com.ericsson.wst.core.command;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.ericsson.wst.command.Command;
import com.ericsson.wst.error.PropertiesFileNotFoundException;
import com.ericsson.wst.util.PropertiesLoader;

/**
 * @author ehonlia
 * 
 */
public final class CommandLoader
{
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

    public static List<String> getAllIndicators()
    {
        return CommandFactory.getInstance().getAllIndicators();
    }

    private CommandLoader()
    {

    }

}
