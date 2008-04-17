/**
 * TestWorkstationListAssembler.java
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.honnix.wst.command.Command;
import com.honnix.wst.core.command.CommandLoader;

/**
 * 
 * 
 */
public class TestWorkstationListAssembler
    extends TestCase
{

    private WorkstationListAssembler assembler;

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();

        CommandLoader.loadCommand();
        assembler = new WorkstationListAssembler();
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown()
        throws Exception
    {
        CommandLoader.unloadCommand();

        super.tearDown();
    }

    public void testAssembleAndGet()
    {
        List<String> indicatorList1 = new ArrayList<String>();

        indicatorList1.add("-t");
        indicatorList1.add("-w");
        indicatorList1.add("-u");

        List<String> indicatorList2 = new ArrayList<String>();

        indicatorList2.add("-t");
        indicatorList2.add("-w");
        indicatorList2.add("-u");

        Map<String, List<String>> indicatorMap =
                new HashMap<String, List<String>>();

        indicatorMap.put("w1:23", indicatorList1);
        indicatorMap.put("w2:23", indicatorList2);

        assembler.assemble(indicatorMap);
        List<Workstation> workstationList = assembler.get();

        List<Command> cmdList1 = workstationList.get(0).getCommandList();
        List<Command> cmdList2 = workstationList.get(1).getCommandList();

        assertEquals("", "-t", cmdList1.get(0).getIndicator());
        assertEquals("", "-w", cmdList1.get(1).getIndicator());
        assertEquals("", "-u", cmdList1.get(2).getIndicator());

        assertEquals("", "-t", cmdList2.get(0).getIndicator());
        assertEquals("", "-w", cmdList2.get(1).getIndicator());
        assertEquals("", "-u", cmdList2.get(2).getIndicator());
    }
}
