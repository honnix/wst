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
