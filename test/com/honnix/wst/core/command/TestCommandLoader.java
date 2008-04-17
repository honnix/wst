/**
 * TestCommandLoader.java
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

import java.util.List;

import junit.framework.TestCase;

import com.honnix.wst.command.Command;
import com.honnix.wst.error.PropertiesFileNotFoundException;

public class TestCommandLoader
    extends TestCase
{

    public void testGetFallbackCommand()
    {
        try
        {
            CommandLoader.loadCommand();
        }
        catch (PropertiesFileNotFoundException e)
        {
            e.printStackTrace();
        }

        assertEquals("Could not get FallbackCommand", "-?", CommandFactory
                .getInstance().produceCommand("-?").getIndicator());
    }

    public void testLoadCommand()
    {
        try
        {
            CommandLoader.loadCommand();
        }
        catch (PropertiesFileNotFoundException e)
        {
            e.printStackTrace();
        }

        List<String> indicatorList =
                CommandFactory.getInstance().getAllIndicators();

        for (String indicator : indicatorList)
        {
            Command command =
                    CommandFactory.getInstance().produceCommand(indicator);
            assertEquals("Wrong indicator " + indicator, indicator, command
                    .getIndicator());
        }
    }
}
