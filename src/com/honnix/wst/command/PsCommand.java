/**
 * PsCommand.java
 *
 * Sep 23, 2007
 */
package com.honnix.wst.command;

import com.honnix.wst.core.network.workflow.Communicator;

/**
 * @author honnix
 * 
 */
public class PsCommand
        extends AbstractCommand
{
    public PsCommand(String indicator)
    {
        super(indicator);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.command.AbstractCommand#execute(com.ericsson.wst.core.network.workflow.Communicator)
     */
    @Override
    public void execute(Communicator communicator)
    {
        String response = communicator.sendAndReceive("ps -elf");

        responseList.add(response);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.command.AbstractCommand#getCommand()
     */
    @Override
    public String getCommand()
    {
        return "ps -elf";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.command.AbstractCommand#makeSelf()
     */
    @Override
    public Command makeSelf()
    {
        Command command = new PsCommand(indicator);

        return command;
    }

}
