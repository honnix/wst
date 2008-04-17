/**
 * TestCommand.java
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
package com.honnix.wst.command;

import com.honnix.wst.core.network.workflow.Communicator;

/**
 * 
 * 
 */
public class UsedToTestCommand
    extends AbstractCommand
{

    public UsedToTestCommand(String indicator)
    {
        super(indicator);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.command.AbstractCommand#execute()
     */
    @Override
    public void execute(Communicator communicator)
    {
        String response = communicator.sendAndReceive("testResponse");

        responseList.add(response);
    }

    @Override
    public String getCommand()
    {
        return "test";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.command.AbstractCommand#makeSelf()
     */
    @Override
    public Command makeSelf()
    {
        Command testCommand = new UsedToTestCommand(indicator);

        return testCommand;
    }

}
