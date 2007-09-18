/**
 * TestWorkflowFactory.java
 * Sep 14, 2007
 */
package com.ericsson.wst.core.network.workflow;

import junit.framework.TestCase;

import com.ericsson.wst.core.network.connection.TelnetConnection;
import com.ericsson.wst.error.PropertiesFileNotFoundException;

/**
 * @author ehonlia
 * 
 */
public class TestWSTWorkflowFactory
        extends TestCase
{
    private WorkflowFactory workflowFactory;

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

        workflowFactory = new WSTWorkflowFactory();
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

    public void testGetWSTWorkflow()
    {
        Workflow workflow = null;

        try
        {
            workflow = workflowFactory.getWorkflow();
        }
        catch (PropertiesFileNotFoundException e)
        {
            e.printStackTrace();

            assertTrue(false);
        }

        assertEquals(TelnetConnection.class, workflow.getConnectionClass());
    }
}
