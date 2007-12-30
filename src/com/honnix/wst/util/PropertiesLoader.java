/**
 * PropertiesLoader.java
 *
 * Sep 13, 2007
 */
package com.honnix.wst.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.honnix.wst.constant.SystemProperties;

/**
 * @author honnix
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

    }

}
