/**
 * WorkstationListAssembler.java
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
package com.honnix.wst.core.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.honnix.wst.core.command.CommandBuilder;

/**
 * 
 * 
 */
public class WorkstationListAssembler
{

    private List<Workstation> workstationList;

    public WorkstationListAssembler()
    {
        super();

        workstationList = new ArrayList<Workstation>();
    }

    public void assemble(Map<String, List<String>> indicatorMap)
    {
        Iterator<String> iter = indicatorMap.keySet().iterator();

        while (iter.hasNext())
        {
            String key = iter.next();
            String[] hostSettings = key.split(":");

            workstationList.add(new Workstation(hostSettings[0], Integer
                    .valueOf(hostSettings[1]), CommandBuilder
                    .buildCommand(indicatorMap.get(key))));
        }
    }

    public void clear()
    {
        workstationList.clear();
    }

    public List<Workstation> get()
    {
        return workstationList;
    }
}
