package DesignTechniques.CommandLineParser;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Map;
import java.util.Set;

/**
 * Created by Dale on 20/07/16.
 */
public class AppCommandLineParser extends CommandLineParser<ICommand<Option>> {

    private class DownloadCommand extends Command<Option> implements OptionArgumentValidator {

        public DownloadCommand() throws InvalidArgumentException {
            super("file", "-");
             addOption(new Option("f", "flush", true, false, this))
            .addOption(new Option("en", "encode", false, true, this))
            .addOption(new Option("e", "encode", false, true, this));
        }

        @Override
        public boolean execute(Map<String, String> optArgs, Set<String> commandArguments) {

            if(optArgs.containsKey("-en"))
                System.out.println("en option specified");

            if(optArgs.containsKey("-e"))
                System.out.println("e option specified");

            //No need to check, this option is required and error will be thrown if it doesnt exist
            String requiredOptionArg = optArgs.get("-f");
            System.out.println(requiredOptionArg);

            return true;
        }

        @Override
        public boolean validateCommandArg(int commandPos, String command) {
            return true;
        }

        @Override
        public boolean validateOptionArgument(String option, String argument) {
            if (option.equals("f") && argument.startsWith("file://"))
                return true;

            return false;
        }
    }

    private ICommand<Option> commands[];

    {
        try {
            commands = new ICommand[]{new DownloadCommand()};
            for(ICommand command:commands){
                addCommand(command);
            }
        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
