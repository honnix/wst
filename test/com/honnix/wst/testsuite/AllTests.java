/**
 * AllTests.java
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
package com.honnix.wst.testsuite;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.honnix.wst.command.TestUsedToTestCommand;
import com.honnix.wst.core.command.TestCommandBuilder;
import com.honnix.wst.core.command.TestCommandExecutor;
import com.honnix.wst.core.command.TestCommandFactory;
import com.honnix.wst.core.command.TestCommandLoader;
import com.honnix.wst.core.data.TestWorkstationFileReader;
import com.honnix.wst.core.data.TestWorkstationListAssembler;
import com.honnix.wst.core.network.connection.TestLocalConnection;
import com.honnix.wst.core.network.connection.TestTelnetConnection;
import com.honnix.wst.core.network.workflow.TestCommunicator;
import com.honnix.wst.core.network.workflow.TestWSTWorkflowFactory;

public final class AllTests
{

    public static Test suite()
    {
        TestSuite suite = new TestSuite("Test for com.honnix.wst.testsuite");

        // $JUnit-BEGIN$
        suite.addTestSuite(TestCommandBuilder.class);
        suite.addTestSuite(TestCommandLoader.class);
        suite.addTestSuite(TestCommandFactory.class);
        suite.addTestSuite(TestCommandExecutor.class);
        suite.addTestSuite(TestUsedToTestCommand.class);
        suite.addTestSuite(TestWSTWorkflowFactory.class);
        suite.addTestSuite(TestCommunicator.class);
        suite.addTestSuite(TestTelnetConnection.class);
        suite.addTestSuite(TestWorkstationListAssembler.class);
        suite.addTestSuite(TestWorkstationFileReader.class);
        suite.addTestSuite(TestLocalConnection.class);
        // $JUnit-END$

        return suite;
    }

    private AllTests()
    {

    }
}
