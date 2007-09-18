/**
 * Cli.java
 * Sep 18, 2007
 */
package com.ericsson.wst.ui;

import gnu.getopt.Getopt;

import com.ericsson.wst.core.facade.Coordinator;

/**
 * @author ehonlia
 * 
 */
public class Cli
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Cli cli = new Cli();
        Getopt g = new Getopt("awt", args, "hf:");
        String fileName = "";

        int c = -1;
        while ((c = g.getopt()) != -1)
        {
            switch (c)
            {
            case 'h':
            case '?':
                cli.usage();
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

        Coordinator coordinator = new Coordinator();

        try
        {
            coordinator.setUp();
            coordinator.testWorstationStatus(fileName);
        }
        catch (Exception e)
        {
            e.printStackTrace();

            System.out.println("wst quit abnormally with error code: "
                    + coordinator.getErrorCode());

            coordinator.tearDown();

            System.exit(coordinator.getErrorCode().getValue());
        }

        coordinator.outputWorkstationStatus();
        coordinator.tearDown();
    }

    private void usage()
    {
        System.out.println("Use: wst -f file");
        System.out.println("or, no argument to use "
                + "default workstaion list file \"$HOME/.wst\".");

        System.exit(0);
    }

}
