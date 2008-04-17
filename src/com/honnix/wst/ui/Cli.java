/**
 * Cli.java
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
package com.honnix.wst.ui;

import gnu.getopt.Getopt;

import java.util.List;

import com.honnix.wst.core.facade.Coordinator;

/**
 * 
 * 
 */
public final class Cli
{

    public static void main(String[] args)
    {
        Cli cli = new Cli();
        Getopt g = new Getopt("wst", args, "hlf:");
        String fileName = "";
        boolean toShowIndicators = false;

        int c = -1;
        while ((c = g.getopt()) != -1)
        {
            switch (c)
            {
            case 'h':
            case '?':
                cli.usage();
                break;
            case 'l':
                toShowIndicators = true;
                break;
            case 'f':
                fileName = g.getOptarg();
                break;
            default:
                System.err.println("Unsupported arguments detected!");
                cli.usage();
                break;
            }
        }

        cli.coordinator = new Coordinator();

        try
        {
            cli.coordinator.setUp();

            if (toShowIndicators)
            {
                cli.showAllIndicators();
            }
            else
            {
                cli.coordinator.testWorstationStatus(fileName);
                cli.coordinator.outputWorkstationStatus();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

            System.out.println("wst quit abnormally with error code: "
                    + cli.coordinator.getErrorCode().getValue());

            cli.coordinator.tearDown();

            System.exit(cli.coordinator.getErrorCode().getValue());
        }

        cli.coordinator.tearDown();
    }

    private Coordinator coordinator;

    private Cli()
    {
        super();
    }

    private void showAllIndicators()
    {
        List<String> indicatorList = coordinator.getAllIndicators();

        for (String indicator : indicatorList)
        {
            System.out.println(indicator + "    "
                    + coordinator.getCommand(indicator));
        }
    }

    private void usage()
    {
        System.out.println("Use: wst -f file");
        System.out.println("     or, no argument to use "
                + "default workstaion list file \"$HOME/.wst\".");
        System.out.println("Use: wst -l");
        System.out.println("     to show all available commands.");

        System.exit(0);
    }

}
