/**
 * WhoCommand.java
 * Sep 17, 2007
 */
package com.honnix.wst.command;

import com.honnix.wst.core.network.workflow.Communicator;

/**
 * @author ehonlia
 * 
 */
public class WhoCommand
        extends AbstractCommand
{
    public WhoCommand(String indicator)
    {
        super(indicator);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.command.AbstractCommand#execute(com.honnix.wst.core.workflow.Communicator)
     */
    @Override
    public void execute(Communicator communicator)
    {
        String response = communicator.sendAndReceive("who -a");

        responseList.add(response);
    }

    @Override
    public String getCommand()
    {
        return "who -a";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.command.AbstractCommand#makeSelf()
     */
    @Override
    public Command makeSelf()
    {
        Command command = new WhoCommand(indicator);

        return command;
    }

}
