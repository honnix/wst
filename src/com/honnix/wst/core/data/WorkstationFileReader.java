/**
 * WorkstationFileReader.java
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
package com.honnix.wst.core.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.honnix.wst.constant.SystemProperties;
import com.honnix.wst.error.WorkstationFileReadException;

/**
 * 
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
                if (inLine.charAt(0) != '#')
                {
                    String[] tmp = inLine.split("\\s+");

                    List<String> indicatorList = Arrays.asList(tmp);

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
        super();
    }

}
