/**
 * CommandExecuter.java
 *
 * Sep 17, 2007
 */
package com.ericsson.wst.core.command;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ericsson.wst.command.Command;
import com.ericsson.wst.core.network.workflow.Workflow;

/**
 * @author honnix
 * 
 */
public class CommandExecutor
{
    private Workflow workflow;

    public CommandExecutor(Workflow workflow)
    {
        this.workflow = workflow;
    }

    public void execute(Map<String, List<Command>> workstationMap)
    {
        Iterator<String> iter = workstationMap.keySet().iterator();

        while (iter.hasNext())
        {
            String host = iter.next();
            List<Command> commandList = workstationMap.get(host);

            workflow.login(host);

            for (Command command : commandList)
            {
                command.execute(workflow.getCommunicator());
            }

            workflow.logout();
        }
    }
}
