/**
 * WorkflowFactory.java
 * Sep 14, 2007
 */
package com.honnix.wst.core.network.workflow;

import com.honnix.wst.error.PropertiesFileNotFoundException;

/**
 * @author ehonlia
 * 
 */
public interface WorkflowFactory
{
    Workflow getWorkflow()
            throws PropertiesFileNotFoundException;
}
