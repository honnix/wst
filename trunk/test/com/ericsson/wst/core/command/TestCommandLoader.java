package com.ericsson.wst.core.command;

import java.util.List;

import junit.framework.TestCase;

import com.ericsson.wst.command.Command;
import com.ericsson.wst.error.PropertiesFileNotFoundException;

public class TestCommandLoader
        extends TestCase
{
    @Override
    protected void setUp()
            throws Exception
    {
        super.setUp();
    }

    @Override
    protected void tearDown()
            throws Exception
    {
        super.tearDown();
    }

    public void testGetFallbackCommand()
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

        assertEquals("Could not get FallbackCommand", "-?", CommandFactory
                .getInstance().produceCommand("-?").getIndicator());
    }

    public void testLoadCommand()
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

        List<String> indicatorList =
                CommandFactory.getInstance().getAllIndicators();

        for (String indicator : indicatorList)
        {
            Command command =
                    CommandFactory.getInstance().produceCommand(indicator);
            assertEquals("Wrong indicator " + indicator, indicator, command
                    .getIndicator());
        }
    }
}
