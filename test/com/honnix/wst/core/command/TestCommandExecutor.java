package com.honnix.wst.core.command;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.honnix.wst.command.Command;
import com.honnix.wst.command.UsedToTestCommand;
import com.honnix.wst.constant.SystemProperties;
import com.honnix.wst.core.command.CommandExecutor;
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

        commandExecutor =
                new CommandExecutor(new MockWorkflowFactory());
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown()
            throws Exception
    {
        super.tearDown();
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
        catch (PropertiesFileNotFoundException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        Workstation workstation = null;
        try
        {
            workstation = commandExecutor.getExecutedWorkstation();
        }
        catch (CommandExecutionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals("testResponse" + SystemProperties.LINE_SEPARATOR,
                workstation.getCommandList().get(0).getResponseList().get(0));
        assertEquals("testResponse" + SystemProperties.LINE_SEPARATOR,
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
        assertEquals("testResponse" + SystemProperties.LINE_SEPARATOR,
                workstation.getCommandList().get(0).getResponseList().get(0));
        assertEquals("testResponse" + SystemProperties.LINE_SEPARATOR,
                workstation.getCommandList().get(1).getResponseList().get(0));

    }

}
