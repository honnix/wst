/**
 * PropertiesLoader.java
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
package com.honnix.wst.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.honnix.wst.constant.SystemProperties;

/**
 * 
 * 
 */
public final class PropertiesLoader
{

    public static Properties loadProperties(String fileName)
        throws IOException
    {
        Properties properties = new Properties();
        File file = null;

        String classpath = SystemProperties.CLASS_PATH;

        for (String entry : classpath.split(SystemProperties.PATH_SEPARATOR))
        {
            file = new File(entry, fileName);

            if (file.exists())
            {
                break;
            }

            file = null;
        }

        if (file != null)
        {
            properties.load(new FileInputStream(file));
        }
        else
        {
            throw new IOException();
        }

        return properties;
    }

    private PropertiesLoader()
    {
        super();
    }

}
