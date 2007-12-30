/**
 * TestCommand.java
 * Sep 12, 2007
 */
package com.honnix.wst.command;

import com.honnix.wst.core.network.workflow.Communicator;

/**
 * @author ehonlia
 * 
 */
public class UsedToTestCommand
        extends AbstractCommand
{
    public UsedToTestCommand(String indicator)
    {
        super(indicator);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.command.AbstractCommand#execute()
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
     * @see com.honnix.wst.command.AbstractCommand#makeSelf()
     */
    @Override
    public Command makeSelf()
    {
        Command testCommand = new UsedToTestCommand(indicator);

        return testCommand;
    }

}
