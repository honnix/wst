/**
 * StandardOutput.java
 * Sep 18, 2007
 */
package com.ericsson.wst.output;

import java.util.List;

/**
 * @author ehonlia
 * 
 */
public abstract class AbstractOutput
        implements Output
{
    protected String host;

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.output.Output#output(java.util.List)
     */
    public abstract void output(List<String> responseList);

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.wst.output.Output#setHost(java.lang.String)
     */
    public void setHost(String host)
    {
        this.host = host;
    }

}
