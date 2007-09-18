package com.ericsson.wst.command;

import java.io.IOException;

import junit.framework.TestCase;

import com.ericsson.wst.constant.SystemProperties;
import com.ericsson.wst.core.network.workflow.MockWorkflow;
import com.ericsson.wst.core.network.workflow.Workflow;
import com.ericsson.wst.util.PropertiesLoader;

public class TestTestUsedCommand
        extends TestCase
{
    private Command testUsedCommand = new TestUsedCommand("-t");

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

        workflow.login(null);
        testUsedCommand.execute(workflow.getCommunicator());
        workflow.logout();

        assertEquals("testResponse" + SystemProperties.LINE_SEPARATOR,
                testUsedCommand.getResponseList().get(0));
    }
}
