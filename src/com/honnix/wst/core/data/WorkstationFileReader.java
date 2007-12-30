/**
 * WorkstationFileReader.java
 * Sep 17, 2007
 */
package com.honnix.wst.core.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.honnix.wst.constant.SystemProperties;
import com.honnix.wst.error.WorkstationFileReadException;

/**
 * @author ehonlia
 * 
 */
public final class WorkstationFileReader
{
    public static Map<String, List<String>> read(String fileName)
            throws WorkstationFileReadException
    {
        File file = new File(fileName);

        if (!file.exists())
        {
            file = new File(SystemProperties.USER_HOME, ".wst");

            if (!file.exists())
            {
                throw new WorkstationFileReadException(fileName
                        + " does not exist. " + "$HOME/.wst does not exist.");
            }
        }

        Map<String, List<String>> indicatorMap =
                new HashMap<String, List<String>>();

        try
        {
            BufferedReader inputStream =
                    new BufferedReader(new FileReader(file));

            String inLine = inputStream.readLine();
            while (inLine != null)
            {
                if (!inLine.startsWith("#"))
                {
                    String[] tmp = inLine.split("\\s+");

                    List<String> indicatorList = new ArrayList<String>();

                    for (int i = 1; i < tmp.length; ++i)
                    {
                        indicatorList.add(tmp[i]);
                    }

                    indicatorMap.put(tmp[0], indicatorList);
                }
                inLine = inputStream.readLine();
            }

            inputStream.close();
        }
        catch (IOException e)
        {
            throw new WorkstationFileReadException(
                    "Read workstation file error.", e);
        }

        return indicatorMap;
    }

    private WorkstationFileReader()
    {

    }

}
