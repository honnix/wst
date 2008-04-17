/**
 * StandardFormatter.java
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
package com.honnix.wst.formatter;

import java.util.ArrayList;
import java.util.List;

import com.honnix.wst.constant.SystemProperties;

/**
 * 
 * 
 */
public class StandardFormatter
    implements Formatter
{

    public StandardFormatter()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.honnix.wst.formatter.Formatter#format(java.util.List)
     */
    public List<String> format(String command, List<String> responseList)
    {
        List<String> formattedResponseList =
                new ArrayList<String>(responseList.size());

        for (String response : responseList)
        {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 8; ++i)
            {
                sb.append("==========");
            }

            sb.append(SystemProperties.LINE_SEPARATOR).append(command).append(
                    SystemProperties.LINE_SEPARATOR).append(response);
            formattedResponseList.add(sb.toString());
        }

        return formattedResponseList;
    }

}
