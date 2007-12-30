/**
 * Command.java
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
public interface Command
{
    Command FALLBACK_COMMAND = new Command() {

        public void execute(Communicator communicator)
        {
        }

        public String getCommand()
        {
            return "null";
        }

        public String getIndicator()
        {
            return "-?";
        }

        public List<String> getResponseList()
        {
            return new ArrayList<String>();
        }

        public Command makeSelf()
        {
            return FALLBACK_COMMAND;
        }

    };

    void execute(Communicator communicator);

    String getCommand();

    String getIndicator();

    List<String> getResponseList();

    Command makeSelf();

}
