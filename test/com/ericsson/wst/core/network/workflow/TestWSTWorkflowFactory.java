/**
 * TestWorkflowFactory.java
 * Sep 14, 2007
 */
package com.ericsson.wst.core.network.workflow;

import junit.framework.TestCase;

import com.ericsson.wst.error.PropertiesFileNotFoundException;
import com.ericsson.wst.util.PropertiesLoader;

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

        try
        {
            String connection =
                    PropertiesLoader.loadProperties("network.properties")
                            .getProperty("connection");
            Class<?> clazz = Class.forName(connection);

            assertEquals(clazz, workflow.getConnectionClass());
        }
        catch (Exception e)
        {
            e.printStackTrace();

            assertTrue(false);
        }
    }
}
