/**
 * WorkflowFactory.java
 * Sep 14, 2007
 */
package com.honnix.wst.core.network.workflow;

import java.io.IOException;
import java.util.Properties;

import com.honnix.wst.error.PropertiesFileNotFoundException;
import com.honnix.wst.util.PropertiesLoader;

/**
 * @author ehonlia
 * 
 */
public class WSTWorkflowFactory
        implements WorkflowFactory
{
    public Workflow getWorkflow()
            throws PropertiesFileNotFoundException
    {
        Properties properties = null;

        try
        {
            properties = PropertiesLoader.loadProperties("network.properties");
        }
        catch (IOException e)
        {
            throw new PropertiesFileNotFoundException(
                    "Properties file not found in CLASSPATH.", e);
        }

        return new WSTWorkflow(properties);
    }

}
