/**
 * MockOutputStream.java
 * Sep 13, 2007
 */
package com.ericsson.wst.core.network.workflow;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ehonlia
 * 
 */
public class MockOutputStream
        extends OutputStream
{
    private StringBuilder sb;

    public MockOutputStream(StringBuilder sb)
    {
        this.sb = sb;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.io.OutputStream#write(int)
     */
    @Override
    public void write(int b)
            throws IOException
    {
        sb.append((char) b);
    }

}
