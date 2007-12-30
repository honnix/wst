/**
 * WorkstationListAssembler.java
 * Sep 17, 2007
 */
package com.honnix.wst.core.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.honnix.wst.core.command.CommandBuilder;

/**
 * @author ehonlia
 * 
 */
public class WorkstationListAssembler
{
    private List<Workstation> workstationList;

    public WorkstationListAssembler()
    {
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

    public List<Workstation> get()
    {
        return workstationList;
    }

    public void clear()
    {
        workstationList.clear();
    }
}
