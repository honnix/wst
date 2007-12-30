/**
 * MockWorkflowFactory.java
 * Sep 14, 2007
 */
package com.honnix.wst.core.network.workflow;

import java.io.IOException;
import java.util.Properties;

import com.honnix.wst.core.network.workflow.Workflow;
import com.honnix.wst.core.network.workflow.WorkflowFactory;
import com.honnix.wst.error.PropertiesFileNotFoundException;
import com.honnix.wst.util.PropertiesLoader;

/**
 * @author ehonlia
 * 
 */
public class MockWorkflowFactory
        implements WorkflowFactory
{

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.core.workflow.WorkflowFactory#getWorkflow()
     */
    public Workflow getWorkflow()
            throws PropertiesFileNotFoundException
    {
        Properties properties = null;

        try
        {
            properties =
                    PropertiesLoader.loadProperties("mocknetwork.properties");
        }
        catch (IOException e)
        {
            throw new PropertiesFileNotFoundException(
                    "Properties file not found in CLASSPATH.", e);
        }

        return new MockWorkflow(properties);
    }

}
