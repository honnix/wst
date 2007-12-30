/**
 * StandardOutput.java
 * Sep 18, 2007
 */
package com.honnix.wst.output;

import java.util.List;

/**
 * @author ehonlia
 * 
 */
public class StandardOutput
    extends AbstractOutput
{

    /*
    * (non-Javadoc)
    * 
    * @see com.ericsson.wst.output.AbstractOutput#output(java.util.List)
    */
    @Override
    public void output(List<String> responseList)
    {
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < 8; ++i)
        {
            sb1.append("**********");
        }

        System.out.println(sb1.toString());
        System.out.println(host + ":" + port);
        System.out.println(sb1.toString());

        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < 8; ++i)
        {
            sb2.append("==========");
        }

        for (String response : responseList)
        {
            System.out.println(response);
            System.out.println(sb2.toString());
        }
    }

}
