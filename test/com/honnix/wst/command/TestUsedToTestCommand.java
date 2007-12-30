package com.honnix.wst.command;

import java.io.IOException;

import junit.framework.TestCase;

import com.honnix.wst.command.Command;
import com.honnix.wst.command.UsedToTestCommand;
import com.honnix.wst.constant.SystemProperties;
import com.honnix.wst.core.network.workflow.MockWorkflow;
import com.honnix.wst.core.network.workflow.Workflow;
import com.honnix.wst.util.PropertiesLoader;

public class TestUsedToTestCommand
        extends TestCase
{
    private Command testUsedCommand = new UsedToTestCommand("-t");

    @Override
    protected void setUp()
            throws Exception
    {
        super.setUp();
    }

    @Override
    protected void tearDown()
            throws Exception
    {
        super.tearDown();
    }

    public void testExecute()
    {
        Workflow workflow = null;
        try
        {
            workflow =
                    new MockWorkflow(PropertiesLoader
                            .loadProperties("mocknetwork.properties"));
        }
        catch (IOException e)
        {
            e.printStackTrace();

            assertTrue(false);
        }

        workflow.login("localhost", 23);
        testUsedCommand.execute(workflow.getCommunicator());
        workflow.logout();

        assertEquals("testResponse" + SystemProperties.LINE_SEPARATOR,
                testUsedCommand.getResponseList().get(0));
    }
}
