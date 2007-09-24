/**
 * CommandExecutionException.java
 * Sep 24, 2007
 */
package com.ericsson.wst.error;

/**
 * @author ehonlia
 * 
 */
public class CommandExecutionException
        extends Exception
{
    /**
     * Generated UID
     */
    private static final long serialVersionUID = 4359775796849162577L;

    public CommandExecutionException()
    {
        super();
    }

    public CommandExecutionException(String message)
    {
        super(message);
    }

    public CommandExecutionException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CommandExecutionException(Throwable cause)
    {
        super(cause);
    }
}
