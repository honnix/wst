/**
 * TestWorkflowFactory.java
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

import junit.framework.TestCase;

import com.honnix.wst.error.PropertiesFileNotFoundException;
import com.honnix.wst.util.PropertiesLoader;

/**
 * 
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

            fail();
        }

        try
        {
            String connection =
                    PropertiesLoader.loadProperties("network.properties")
                            .getProperty("connection");
            Class<?> clazz = Class.forName(connection);

            assertEquals("", clazz, workflow.getConnectionClass());
        }
        catch (Exception e)
        {
            e.printStackTrace();

            fail();
        }
    }
}
