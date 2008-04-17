/**
 * TestCommandFactory.java
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
import com.honnix.wst.command.UsedToTestCommand;

/**
 * 
 * 
 */
public class TestCommandFactory
    extends TestCase
{

    private CommandFactory commandFacotry = null;

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();

        commandFacotry = CommandFactory.getInstance();
    }

    public void testInsertCommandPrototype()
    {
        commandFacotry.insertCommandPrototype(new UsedToTestCommand("-t"));

        List<String> indicatorList = new ArrayList<String>();

        indicatorList.add("-t");
        List<Command> commandList = CommandBuilder.buildCommand(indicatorList);

        assertEquals("Wrong command", "-t", commandList.get(0).getIndicator());
    }
}
