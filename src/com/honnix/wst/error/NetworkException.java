/**
 * NetworkException.java
 * Sep 14, 2007
 */
package com.honnix.wst.error;

/**
 * @author ehonlia
 * 
 */
public class NetworkException
        extends Exception
{
    /**
     * Generated UID
     */
    private static final long serialVersionUID = 8511550237646254096L;

    public NetworkException()
    {
        super();
    }

    public NetworkException(String message)
    {
        super(message);
    }

    public NetworkException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NetworkException(Throwable cause)
    {
        super(cause);
    }
}
