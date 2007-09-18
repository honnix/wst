package com.ericsson.wst.testsuite;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ericsson.wst.command.TestTestUsedCommand;
import com.ericsson.wst.core.command.TestCommandBuilder;
import com.ericsson.wst.core.command.TestCommandExecutor;
import com.ericsson.wst.core.command.TestCommandFactory;
import com.ericsson.wst.core.command.TestCommandLoader;
import com.ericsson.wst.core.data.TestWorkstationFileReader;
import com.ericsson.wst.core.data.TestWorkstationMapAssembler;
import com.ericsson.wst.core.network.connection.TestTelnetConnection;
import com.ericsson.wst.core.network.workflow.TestCommunicator;
import com.ericsson.wst.core.network.workflow.TestWSTWorkflowFactory;

public final class AllTests
{

    public static Test suite()
    {
        TestSuite suite = new TestSuite("Test for com.ericsson.wst.testsuite");

        // $JUnit-BEGIN$
        suite.addTestSuite(TestCommandBuilder.class);
        suite.addTestSuite(TestCommandLoader.class);
        suite.addTestSuite(TestCommandFactory.class);
        suite.addTestSuite(TestCommandExecutor.class);
        suite.addTestSuite(TestTestUsedCommand.class);
        suite.addTestSuite(TestWSTWorkflowFactory.class);
        suite.addTestSuite(TestCommunicator.class);
        suite.addTestSuite(TestTelnetConnection.class);
        suite.addTestSuite(TestWorkstationMapAssembler.class);
        suite.addTestSuite(TestWorkstationFileReader.class);
        // $JUnit-END$

        return suite;
    }

    private AllTests()
    {

    }
}
