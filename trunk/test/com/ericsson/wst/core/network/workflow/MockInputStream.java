/**
 * MockInputStream.java
 * Sep 13, 2007
 */
package com.ericsson.wst.core.network.workflow;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ehonlia
 * 
 */
public class MockInputStream
        extends InputStream
{
    private int pos;

    private StringBuilder sb;

    public MockInputStream(StringBuilder sb)
    {
        this.sb = sb;
        pos = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.io.InputStream#read()
     */
    @Override
    public int read()
            throws IOException
    {
        if (pos < sb.length())
        {
            return sb.charAt(pos++);
        }
        else
        {
            sb.delete(0, pos);
            pos = 0;

            return -1;
        }
    }

}
