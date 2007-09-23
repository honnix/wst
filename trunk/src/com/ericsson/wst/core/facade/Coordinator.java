/**
 * Coordinator.java
 * Sep 17, 2007
 */
package com.ericsson.wst.core.facade;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.ericsson.wst.command.Command;
import com.ericsson.wst.core.command.CommandExecutor;
import com.ericsson.wst.core.command.CommandLoader;
import com.ericsson.wst.core.data.WorkstationFileReader;
import com.ericsson.wst.core.data.WorkstationMapAssembler;
import com.ericsson.wst.core.network.workflow.WSTWorkflowFactory;
import com.ericsson.wst.error.ErrorCode;
import com.ericsson.wst.error.PropertiesFileNotFoundException;
import com.ericsson.wst.error.WorkstationFileReadException;
import com.ericsson.wst.formatter.Formatter;
import com.ericsson.wst.formatter.StandardFormatter;
import com.ericsson.wst.output.Output;
import com.ericsson.wst.output.StandardOutput;
import com.ericsson.wst.util.PropertiesLoader;

/**
 * @author ehonlia
 * 
 */
public class Coordinator
{
    private WorkstationMapAssembler assembler;

    private CommandExecutor commandExecutor;

    private ErrorCode errorCode;

    private Formatter formatter;

    private Output output;

    private Properties properties;

    public Coordinator()
    {
    }

    /**
     * @throws PropertiesFileNotFoundException
     */
    private void loadFormatterAndOutput()
            throws PropertiesFileNotFoundException
    {
        try
        {
            properties = PropertiesLoader.loadProperties("wst.properties");
        }
        catch (IOException e)
        {
            setErrorCode(ErrorCode.PROPERTIES_FILE_NOT_FOUND);

            throw new PropertiesFileNotFoundException(
                    "Properties file not found in CLASSPATH.", e);
        }

        try
        {
            formatter =
                    (Formatter) Class.forName(
                            properties.getProperty("formatter")).newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Use StandardFormatter instead.");

            formatter = new StandardFormatter();
        }

        try
        {
            output =
                    (Output) Class.forName(properties.getProperty("output"))
                            .newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Use StandardOutput instead.");

            output = new StandardOutput();
        }
    }

    private void setErrorCode(ErrorCode errorCode)
    {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode()
    {
        return errorCode;
    }

    public void outputWorkstationStatus()
    {
        Iterator<String> iter = assembler.get().keySet().iterator();

        while (iter.hasNext())
        {
            String host = iter.next();
            List<Command> commandList = assembler.get().get(host);

            output.setHost(host);
            for (Command command : commandList)
            {
                List<String> formattedResponseList =
                        formatter.format(command.getCommand(), command
                                .getResponseList());
                output.output(formattedResponseList);
            }
        }
    }

    public void setUp()
            throws PropertiesFileNotFoundException
    {
        try
        {
            CommandLoader.loadCommand();
            commandExecutor =
                    new CommandExecutor(new WSTWorkflowFactory().getWorkflow());
        }
        catch (PropertiesFileNotFoundException e)
        {
            setErrorCode(ErrorCode.PROPERTIES_FILE_NOT_FOUND);

            throw e;
        }

        loadFormatterAndOutput();

        assembler = new WorkstationMapAssembler();
    }

    public void tearDown()
    {
        CommandLoader.unloadCommand();
    }

    public void testWorstationStatus(String fileName)
            throws WorkstationFileReadException
    {
        Map<String, List<String>> indicatorMap = null;

        try
        {
            indicatorMap = WorkstationFileReader.read(fileName);
        }
        catch (WorkstationFileReadException e)
        {
            setErrorCode(ErrorCode.WORKSTATION_FILE_READ_ERROR);

            throw e;
        }

        assembler.assemble(indicatorMap);
        commandExecutor.execute(assembler.get());
    }

}
