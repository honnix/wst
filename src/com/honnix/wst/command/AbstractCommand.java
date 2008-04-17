/**
 * AbstractCommand.java
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

import java.util.ArrayList;
import java.util.List;

import com.honnix.wst.core.network.workflow.Communicator;

/**
 * 
 */
public abstract class AbstractCommand
    implements Command
{

    protected String indicator;

    protected List<String> responseList;

    public AbstractCommand()
    {
        super();
    }

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
