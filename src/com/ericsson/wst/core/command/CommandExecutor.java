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
import com.ericsson.wst.core.network.workflow.WorkflowFactory;
import com.ericsson.wst.error.CommandExecutionException;
import com.ericsson.wst.error.PropertiesFileNotFoundException;

/**
 * @author honnix
 * 
 */
public class CommandExecutor
{
    private class ExecuteThread
        extends Thread
    {
        private Workstation workstation;

        private Workflow workflow;

        public ExecuteThread(Workstation workstation, Workflow workflow)
        {
            this.workstation = workstation;
            this.workflow = workflow;
        }

        @Override
        public void run()
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

    private BlockingQueue<Workstation> executedQueue;

    private WorkflowFactory workflowFactory;

    public CommandExecutor(WorkflowFactory workflowFactory)
    {
        this.workflowFactory = workflowFactory;
        executedQueue = new LinkedBlockingQueue<Workstation>();
    }

    public void execute(List<Workstation> workstationList)
        throws PropertiesFileNotFoundException
    {
        for (Workstation workstation : workstationList)
        {
            new ExecuteThread(workstation, workflowFactory.getWorkflow())
                    .start();
        }
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
