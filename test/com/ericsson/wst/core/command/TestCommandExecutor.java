package com.ericsson.wst.core.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.ericsson.wst.command.Command;
import com.ericsson.wst.command.UsedToTestCommand;
import com.ericsson.wst.constant.SystemProperties;
import com.ericsson.wst.core.network.workflow.MockWorkflowFactory;

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
                new CommandExecutor(new MockWorkflowFactory().getWorkflow());
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
        Map<String, List<Command>> workstationMap =
                new HashMap<String, List<Command>>();
        List<Command> cmdList1 = new ArrayList<Command>();
        List<Command> cmdList2 = new ArrayList<Command>();

        cmdList1.add(new UsedToTestCommand("-t"));
        cmdList1.add(new UsedToTestCommand("-t"));

        cmdList2.add(new UsedToTestCommand("-t"));
        cmdList2.add(new UsedToTestCommand("-t"));

        workstationMap.put("w1:23", cmdList1);
        workstationMap.put("w2:23", cmdList2);

        commandExecutor.execute(workstationMap);

        assertEquals("testResponse" + SystemProperties.LINE_SEPARATOR,
                workstationMap.get("w1:23").get(0).getResponseList().get(0));
        assertEquals("testResponse" + SystemProperties.LINE_SEPARATOR,
                workstationMap.get("w1:23").get(1).getResponseList().get(0));

        assertEquals("testResponse" + SystemProperties.LINE_SEPARATOR,
                workstationMap.get("w2:23").get(0).getResponseList().get(0));
        assertEquals("testResponse" + SystemProperties.LINE_SEPARATOR,
                workstationMap.get("w2:23").get(1).getResponseList().get(0));

    }

}
