/**
 * Formatter.java
 *
 * Sep 17, 2007
 */
package com.ericsson.wst.formatter;

import java.util.List;

/**
 * @author honnix
 * 
 */
public interface Formatter
{
    List<String> format(String command, List<String> responseList);
}
