/**
 * TestCommandExecutor.java
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
import com.honnix.wst.constant.SystemProperties;
import com.honnix.wst.core.data.Workstation;
import com.honnix.wst.core.network.workflow.MockWorkflowFactory;
import com.honnix.wst.error.CommandExecutionException;
import com.honnix.wst.error.PropertiesFileNotFoundException;

public class TestCommandExecutor
    extends TestCase
{

    private CommandExecutor commandExecutor;

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

        commandExecutor = new CommandExecutor(new MockWorkflowFactory());
    }

    public void testExecute()
    {
        List<Workstation> workstationList = new ArrayList<Workstation>();
        List<Command> cmdList1 = new ArrayList<Command>();
        List<Command> cmdList2 = new ArrayList<Command>();

        cmdList1.add(new UsedToTestCommand("-t"));
        cmdList1.add(new UsedToTestCommand("-t"));

        cmdList2.add(new UsedToTestCommand("-t"));
        cmdList2.add(new UsedToTestCommand("-t"));

        workstationList.add(new Workstation("w1", 23, cmdList1));
        workstationList.add(new Workstation("w2", 23, cmdList1));

        try
        {
            commandExecutor.execute(workstationList);
        }
        catch (PropertiesFileNotFoundException e)
        {
            e.printStackTrace();
        }

        Workstation workstation = null;
        try
        {
            workstation = commandExecutor.getExecutedWorkstation();
        }
        catch (CommandExecutionException e)
        {
            e.printStackTrace();
        }
        assertEquals("", "testResponse" + SystemProperties.LINE_SEPARATOR,
                workstation.getCommandList().get(0).getResponseList().get(0));
        assertEquals("", "testResponse" + SystemProperties.LINE_SEPARATOR,
                workstation.getCommandList().get(1).getResponseList().get(0));

        try
        {
            workstation = commandExecutor.getExecutedWorkstation();
        }
        catch (CommandExecutionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals("", "testResponse" + SystemProperties.LINE_SEPARATOR,
                workstation.getCommandList().get(0).getResponseList().get(0));
        assertEquals("", "testResponse" + SystemProperties.LINE_SEPARATOR,
                workstation.getCommandList().get(1).getResponseList().get(0));

    }

}
