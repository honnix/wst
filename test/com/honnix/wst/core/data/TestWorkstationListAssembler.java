/**
 * TestWorkstationListAssembler.java
 * Sep 17, 2007
 */
package com.honnix.wst.core.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.honnix.wst.command.Command;
import com.honnix.wst.core.command.CommandLoader;
import com.honnix.wst.core.data.Workstation;
import com.honnix.wst.core.data.WorkstationListAssembler;

/**
 * @author ehonlia
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

        assertEquals("-t", cmdList1.get(0).getIndicator());
        assertEquals("-w", cmdList1.get(1).getIndicator());
        assertEquals("-u", cmdList1.get(2).getIndicator());

        assertEquals("-t", cmdList2.get(0).getIndicator());
        assertEquals("-w", cmdList2.get(1).getIndicator());
        assertEquals("-u", cmdList2.get(2).getIndicator());
    }
}
