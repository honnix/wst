/**
 * AbstractCommand.java
 * Sep 11, 2007
 */
package com.honnix.wst.command;

import java.util.ArrayList;
import java.util.List;

import com.honnix.wst.core.network.workflow.Communicator;

/**
 * @author ehonlia
 * 
 */
public abstract class AbstractCommand
        implements Command
{
    protected String indicator;

    protected List<String> responseList;

    public AbstractCommand(String indicator)
    {
        this.indicator = indicator;
        responseList = new ArrayList<String>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.command.Command#execute(com.honnix.wst.core.workflow.Communicator)
     */
    public abstract void execute(Communicator communicator);

    public abstract String getCommand();

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.command.Command#getIndicator()
     */
    public String getIndicator()
    {
        return indicator;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.command.Command#getResponse()
     */
    public List<String> getResponseList()
    {
        return responseList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.command.Command#makeSelf()
     */
    public abstract Command makeSelf();

}
