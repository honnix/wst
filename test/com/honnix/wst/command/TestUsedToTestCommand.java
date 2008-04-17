/**
 * TestUsedToTestCommand.java
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
package com.honnix.wst.command;

import java.io.IOException;

import junit.framework.TestCase;

import com.honnix.wst.constant.SystemProperties;
import com.honnix.wst.core.network.workflow.MockWorkflow;
import com.honnix.wst.core.network.workflow.Workflow;
import com.honnix.wst.util.PropertiesLoader;

public class TestUsedToTestCommand
    extends TestCase
{

    private Command testUsedCommand = new UsedToTestCommand("-t");

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
            e.printStackTrace(); // NOPMD by honnix on 4/17/08 10:10 PM

            fail();
        }

        workflow.login("localhost", 23);
        testUsedCommand.execute(workflow.getCommunicator());
        workflow.logout();

        assertEquals("", "testResponse" + SystemProperties.LINE_SEPARATOR,
                testUsedCommand.getResponseList().get(0));
    }
}
