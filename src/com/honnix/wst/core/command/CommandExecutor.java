/**
 * CommandExecuter.java
 * 
 * Copyright : (C) 2008 by Honnix
 * Email     : hxliang1982@gmail.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.honnix.wst.core.command;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.honnix.wst.command.Command;
import com.honnix.wst.core.data.Workstation;
import com.honnix.wst.core.network.workflow.Workflow;
import com.honnix.wst.core.network.workflow.WorkflowFactory;
import com.honnix.wst.error.CommandExecutionException;
import com.honnix.wst.error.PropertiesFileNotFoundException;

/**
 * 
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
            super();

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

    public CommandExecutor()
    {
        super();
    }

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
