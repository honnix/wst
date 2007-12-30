/**
 * StandardFormatter.java
 *
 * Sep 17, 2007
 */
package com.honnix.wst.formatter;

import java.util.ArrayList;
import java.util.List;

import com.honnix.wst.constant.SystemProperties;

/**
 * @author honnix
 * 
 */
public class StandardFormatter
        implements Formatter
{
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
