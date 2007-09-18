/**
 * SystemProperties.java
 *
 * Sep 17, 2007
 */
package com.ericsson.wst.constant;

/**
 * @author honnix
 * 
 */
public final class SystemProperties
{
    public static final String CLASS_PATH =
            System.getProperty("java.class.path");

    public static final String LINE_SEPARATOR =
            System.getProperty("line.separator");

    public static final String PATH_SEPARATOR =
            System.getProperty("path.separator");

    public static final String USER_HOME = System.getProperty("user.home");

    private SystemProperties()
    {

    }
}
