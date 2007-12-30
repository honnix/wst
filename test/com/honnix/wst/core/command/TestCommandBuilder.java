/**
 * TestCommandBuilder.java
 * Sep 12, 2007
 */
package com.honnix.wst.core.command;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.honnix.wst.command.Command;
import com.honnix.wst.core.command.CommandBuilder;
import com.honnix.wst.core.command.CommandLoader;
import com.honnix.wst.error.PropertiesFileNotFoundException;

/**
 * @author ehonlia
 * 
 */
public class TestCommandBuilder
        extends TestCase
{
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

    public void testBuildCommand()
    {
        try
        {
            CommandLoader.loadCommand();
        }
        catch (PropertiesFileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<String> indicatorList = new ArrayList<String>();

        indicatorList.add("-w");
        indicatorList.add("-u");

        List<Command> commandList = CommandBuilder.buildCommand(indicatorList);

        assertEquals("Wrong indicator -w for command " + commandList.get(0),
                "-w", commandList.get(0).getIndicator());

        assertEquals("Wrong indicator -u for command " + commandList.get(1),
                "-u", commandList.get(1).getIndicator());
    }

    public void testBuildCommandForTestCommand()
    {
        try
        {
            CommandLoader.loadCommand();
        }
        catch (PropertiesFileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<String> indicatorList = new ArrayList<String>();

        indicatorList.add("-t");
        indicatorList.add("-t");
        indicatorList.add("-t");

        List<Command> commandList = CommandBuilder.buildCommand(indicatorList);

        assertEquals("Wrong indicator -t for command " + commandList.get(0),
                "-t", commandList.get(0).getIndicator());

        assertEquals("Wrong indicator -t for command " + commandList.get(1),
                "-t", commandList.get(1).getIndicator());

        assertEquals("Wrong indicator -t for command " + commandList.get(1),
                "-t", commandList.get(1).getIndicator());

    }
}
