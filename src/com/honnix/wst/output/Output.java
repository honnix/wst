/**
 * Output.java
 * Sep 18, 2007
 */
package com.honnix.wst.output;

import java.util.List;

/**
 * @author ehonlia
 * 
 */
public interface Output
{
    void output(List<String> responseList);

    void setHost(String host);
    
    void setPort(int port);
}
