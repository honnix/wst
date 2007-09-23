/**
 * WorkstationMapAssembler.java
 * Sep 17, 2007
 */
package com.ericsson.wst.core.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ericsson.wst.command.Command;
import com.ericsson.wst.core.command.CommandBuilder;

/**
 * @author ehonlia
 * 
 */
public class WorkstationMapAssembler
{
    private Map<String, List<Command>> workstationMap;

    public WorkstationMapAssembler()
    {
        workstationMap = new HashMap<String, List<Command>>();
    }

    public void assemble(Map<String, List<String>> indicatorMap)
    {
        Iterator<String> iter = indicatorMap.keySet().iterator();

        while (iter.hasNext())
        {
            String host = iter.next();
            workstationMap.put(host, CommandBuilder.buildCommand(indicatorMap
                    .get(host)));
        }
    }

    public Map<String, List<Command>> get()
    {
        return workstationMap;
    }

}
