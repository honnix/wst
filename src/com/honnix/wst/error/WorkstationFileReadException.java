/**
 * WorkstationFileReadException.java
 * Sep 17, 2007
 */
package com.honnix.wst.error;

/**
 * @author ehonlia
 * 
 */
public class WorkstationFileReadException
        extends Exception
{

    /**
     * Generated UID
     */
    private static final long serialVersionUID = -4477212634035798636L;

    public WorkstationFileReadException()
    {
        super();
    }

    public WorkstationFileReadException(String message)
    {
        super(message);
    }

    public WorkstationFileReadException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public WorkstationFileReadException(Throwable cause)
    {
        super(cause);
    }
}
