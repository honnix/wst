/**
 * PropertiesFileNotFoundException.java
 * Sep 12, 2007
 */
package com.ericsson.wst.error;

/**
 * @author ehonlia
 * 
 */
public class PropertiesFileNotFoundException
        extends Exception
{
    /**
     * Generated UID
     */
    private static final long serialVersionUID = -5150154730986247645L;

    public PropertiesFileNotFoundException()
    {
        super();
    }

    public PropertiesFileNotFoundException(String message)
    {
        super(message);
    }

    public PropertiesFileNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PropertiesFileNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
