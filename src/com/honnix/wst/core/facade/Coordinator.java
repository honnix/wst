/**
 * Coordinator.java
 * Sep 17, 2007
 */
package com.honnix.wst.core.facade;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.honnix.wst.command.Command;
import com.honnix.wst.core.command.CommandExecutor;
import com.honnix.wst.core.command.CommandFactory;
import com.honnix.wst.core.command.CommandLoader;
import com.honnix.wst.core.data.Workstation;
import com.honnix.wst.core.data.WorkstationFileReader;
import com.honnix.wst.core.data.WorkstationListAssembler;
import com.honnix.wst.core.network.workflow.WSTWorkflowFactory;
import com.honnix.wst.error.CommandExecutionException;
import com.honnix.wst.error.ErrorCode;
import com.honnix.wst.error.PropertiesFileNotFoundException;
import com.honnix.wst.error.WorkstationFileReadException;
import com.honnix.wst.formatter.Formatter;
import com.honnix.wst.formatter.StandardFormatter;
import com.honnix.wst.output.Output;
import com.honnix.wst.output.StandardOutput;
import com.honnix.wst.util.PropertiesLoader;

/**
 * @author ehonlia
 * 
 */
public class Coordinator
{
    private WorkstationListAssembler assembler;

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
            throws CommandExecutionException
    {
        CommandExecutionException toThrow = null;
        
        for (int i = 0; i < assembler.get().size(); ++i)
        {
            Workstation workstation = null;

            try
            {
                workstation = commandExecutor.getExecutedWorkstation();
            }
            catch (CommandExecutionException e)
            {
                setErrorCode(ErrorCode.COMMAND_EXECUTION_INTERRUPTED);
                toThrow = e;
                
                continue;
            }

            output.setHost(workstation.getHost());
            output.setPort(workstation.getPort());

            for (Command command : workstation.getCommandList())
            {
                List<String> formattedResponseList =
                        formatter.format(command.getCommand(), command
                                .getResponseList());
                output.output(formattedResponseList);
            }
        }

        if (toThrow != null)
        {
            throw toThrow;
        }
    }

    public void setUp()
            throws PropertiesFileNotFoundException
    {
        try
        {
            CommandLoader.loadCommand();
            commandExecutor = new CommandExecutor(new WSTWorkflowFactory());
        }
        catch (PropertiesFileNotFoundException e)
        {
            setErrorCode(ErrorCode.PROPERTIES_FILE_NOT_FOUND);

            throw e;
        }

        loadFormatterAndOutput();

        assembler = new WorkstationListAssembler();
    }

    public void tearDown()
    {
        CommandLoader.unloadCommand();
    }

    public void testWorstationStatus(String fileName)
            throws WorkstationFileReadException,
            PropertiesFileNotFoundException
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

        try
        {
            commandExecutor.execute(assembler.get());
        }
        catch (PropertiesFileNotFoundException e)
        {
            setErrorCode(ErrorCode.PROPERTIES_FILE_NOT_FOUND);

            throw e;
        }
    }

    public List<String> getAllIndicators()
    {
        return CommandLoader.getAllIndicators();
    }

    public String getCommand(String indicator)
    {
        return CommandFactory.getInstance().produceCommand(indicator)
                .getCommand();
    }

}
