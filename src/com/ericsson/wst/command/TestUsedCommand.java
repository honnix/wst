/**
 * TestCommand.java
 * Sep 12, 2007
 */
package com.ericsson.wst.command;

import com.ericsson.wst.core.network.workflow.Communicator;

/**
 * @author ehonlia
 * 
 */
public class TestUsedCommand
        extends AbstractCommand
{
    public TestUsedCommand(String indicator)
    {
        super(indicator);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.command.AbstractCommand#execute()
     */
    @Override
    public void execute(Communicator communicator)
    {
        String response = communicator.sendAndReceive("testResponse");

        responseList.add(response);
    }

    @Override
    public String getCommand()
    {
        return "test";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.command.AbstractCommand#makeSelf()
     */
    @Override
    public Command makeSelf()
    {
        Command testCommand = new TestUsedCommand(indicator);

        return testCommand;
    }

}
