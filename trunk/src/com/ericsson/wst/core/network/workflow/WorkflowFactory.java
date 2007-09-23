/**
 * WorkflowFactory.java
 * Sep 14, 2007
 */
package com.ericsson.wst.core.network.workflow;

import com.ericsson.wst.error.PropertiesFileNotFoundException;

/**
 * @author ehonlia
 * 
 */
public interface WorkflowFactory
{
    Workflow getWorkflow()
            throws PropertiesFileNotFoundException;
}
