/**
 * ErrorCode.java
 * Sep 18, 2007
 */
package com.ericsson.wst.error;

/**
 * @author ehonlia
 * 
 */
public enum ErrorCode
{
    PROPERTIES_FILE_NOT_FOUND(1),
    WORKSTATION_FILE_READ_ERROR(2),
    COMMAND_EXECUTION_INTERRUPTED(3);

    private int value;

    private ErrorCode(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
