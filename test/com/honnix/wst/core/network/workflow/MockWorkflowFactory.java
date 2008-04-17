/**
 * MockWorkflowFactory.java
 * 
 * Copyright : (C) 2008 by Honnix
 * Email     : hxliang1982@gmail.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.honnix.wst.core.network.workflow;

import java.io.IOException;
import java.util.Properties;

import com.honnix.wst.error.PropertiesFileNotFoundException;
import com.honnix.wst.util.PropertiesLoader;

/**
 * 
 * 
 */
public class MockWorkflowFactory
    implements WorkflowFactory
{

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.core.workflow.WorkflowFactory#getWorkflow()
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
