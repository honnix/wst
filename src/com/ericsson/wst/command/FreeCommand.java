/**
 * FreeCommand.java
 * Sep 17, 2007
 */
package com.ericsson.wst.command;

import com.ericsson.wst.core.network.workflow.Communicator;

/**
 * @author ehonlia
 * 
 */
public class FreeCommand
        extends AbstractCommand
{
    public FreeCommand(String indicator)
    {
        super(indicator);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.command.AbstractCommand#execute(com.ericsson.wst.core.workflow.Communicator)
     */
    @Override
    public void execute(Communicator communicator)
    {
        String response = communicator.sendAndReceive("free");

        responseList.add(response);
    }

    @Override
    public String getCommand()
    {
        return "free";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.command.AbstractCommand#makeSelf()
     */
    @Override
    public Command makeSelf()
    {
        Command command = new FreeCommand(indicator);

        return command;
    }

}
