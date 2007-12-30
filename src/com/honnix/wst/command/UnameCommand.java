/**
 * UnameCommand.java
 * Sep 14, 2007
 */
package com.honnix.wst.command;

import com.honnix.wst.core.network.workflow.Communicator;

/**
 * @author ehonlia
 * 
 */
public class UnameCommand
        extends AbstractCommand
{
    public UnameCommand(String indicator)
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
        String response = communicator.sendAndReceive("uname -a");

        responseList.add(response);
    }

    @Override
    public String getCommand()
    {
        return "uname -a";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.command.AbstractCommand#makeSelf()
     */
    @Override
    public Command makeSelf()
    {
        Command command = new UnameCommand(indicator);

        return command;
    }

}
