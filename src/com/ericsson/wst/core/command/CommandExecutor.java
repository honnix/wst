/**
 * CommandExecuter.java
 *
 * Sep 17, 2007
 */
package com.ericsson.wst.core.command;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.ericsson.wst.command.Command;
import com.ericsson.wst.core.data.Workstation;
import com.ericsson.wst.core.network.workflow.Workflow;
import com.ericsson.wst.error.CommandExecutionException;

/**
 * @author honnix
 * 
 */
public class CommandExecutor
{
    private class ExecuteThread
            extends Thread
    {
        private List<Workstation> workstationList;

        public ExecuteThread(List<Workstation> workstationList)
        {
            this.workstationList = workstationList;
        }

        @Override
        public void run()
        {
            for (Workstation workstation : workstationList)
            {
                workflow.login(workstation.getHost(), workstation.getPort());

                for (Command command : workstation.getCommandList())
                {
                    command.execute(workflow.getCommunicator());
                }

                workflow.logout();

                executedQueue.add(workstation);
            }
        }

    }

    private BlockingQueue<Workstation> executedQueue;

    private Workflow workflow;

    public CommandExecutor(Workflow workflow)
    {
        this.workflow = workflow;
        executedQueue = new LinkedBlockingQueue<Workstation>();
    }

    public void execute(List<Workstation> workstationList)
    {
        new ExecuteThread(workstationList).start();
    }

    public Workstation getExecutedWorkstation()
            throws CommandExecutionException
    {
        try
        {
            return executedQueue.take();
        }
        catch (InterruptedException e)
        {
            throw new CommandExecutionException(
                    "Command execution thread has been interrupted.", e);
        }
    }
}
