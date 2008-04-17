/**
 * TestCommandBuilder.java
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
import java.util.List;

import junit.framework.TestCase;

import com.honnix.wst.command.Command;
import com.honnix.wst.error.PropertiesFileNotFoundException;

/**
 * 
 * 
 */
public class TestCommandBuilder
    extends TestCase
{

    public void testBuildCommand()
    {
        try
        {
            CommandLoader.loadCommand();
        }
        catch (PropertiesFileNotFoundException e)
        {
            e.printStackTrace();
        }

        List<String> indicatorList = new ArrayList<String>();

        indicatorList.add("-w");
        indicatorList.add("-u");

        List<Command> commandList = CommandBuilder.buildCommand(indicatorList);

        assertEquals("Wrong indicator -w for command " + commandList.get(0),
                "-w", commandList.get(0).getIndicator());

        assertEquals("Wrong indicator -u for command " + commandList.get(1),
                "-u", commandList.get(1).getIndicator());
    }

    public void testBuildCommandForTestCommand()
    {
        try
        {
            CommandLoader.loadCommand();
        }
        catch (PropertiesFileNotFoundException e)
        {
            e.printStackTrace();
        }

        List<String> indicatorList = new ArrayList<String>();

        indicatorList.add("-t");
        indicatorList.add("-t");
        indicatorList.add("-t");

        List<Command> commandList = CommandBuilder.buildCommand(indicatorList);

        assertEquals("Wrong indicator -t for command " + commandList.get(0),
                "-t", commandList.get(0).getIndicator());

        assertEquals("Wrong indicator -t for command " + commandList.get(1),
                "-t", commandList.get(1).getIndicator());

        assertEquals("Wrong indicator -t for command " + commandList.get(1),
                "-t", commandList.get(1).getIndicator());

    }
}
