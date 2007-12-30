/**
 * TestCommunicator.java
 * Sep 13, 2007
 */
package com.honnix.wst.core.network.workflow;

import junit.framework.TestCase;

import com.honnix.wst.constant.SystemProperties;
import com.honnix.wst.core.network.workflow.Communicator;
import com.honnix.wst.core.network.workflow.Workflow;

/**
 * @author ehonlia
 * 
 */
public class TestCommunicator
        extends TestCase
{
    private Communicator communicator;

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

        Workflow mockWorkflow = new MockWorkflowFactory().getWorkflow();

        communicator = mockWorkflow.getCommunicator();
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

    public void testSendAndReceive()
    {
        String response = communicator.sendAndReceive("testSendAndReceive");

        assertEquals("testSendAndReceive" + SystemProperties.LINE_SEPARATOR,
                response);
    }
}
