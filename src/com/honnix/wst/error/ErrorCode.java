/**
 * ErrorCode.java
 * 
 * Copyright : (C) 2008 by Honnix
 * Email     : hxliang1982@gmail.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.honnix.wst.error;

/**
 * 
 * 
 */
public enum ErrorCode
{
    PROPERTIES_FILE_NOT_FOUND(
            1),
    WORKSTATION_FILE_READ_ERROR(
            2),
    COMMAND_EXECUTION_INTERRUPTED(
            3);

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
