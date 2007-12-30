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
public abstract class AbstractOutput
    implements Output
{
    protected String host;

    protected int port;

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

    /*
    * (non-Javadoc)
    * @see com.ericsson.wst.output.Output#setPort(int)
    */
    public void setPort(int port)
    {
        this.port = port;
    }

}
