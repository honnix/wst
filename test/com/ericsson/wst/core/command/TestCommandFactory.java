/**
 * TestCommandFactory.java
 * Sep 12, 2007
 */
package com.ericsson.wst.core.command;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.ericsson.wst.command.Command;
import com.ericsson.wst.command.TestUsedCommand;

/**
 * @author ehonlia
 * 
 */
public class TestCommandFactory
        extends TestCase
{
    private CommandFactory commandFacotry = null;

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

        commandFacotry = CommandFactory.getInstance();
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown()
            throws Exception
    {
        super.tearDown();
    }

    public void testInsertCommandPrototype()
    {
        commandFacotry.insertCommandPrototype(new TestUsedCommand("-t"));

        List<String> indicatorList = new ArrayList<String>();

        indicatorList.add("-t");
        List<Command> commandList = CommandBuilder.buildCommand(indicatorList);

        assertEquals("Wrong command", "-t", commandList.get(0).getIndicator());
    }
}
