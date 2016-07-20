package DesignTechniques.CommandLineParser;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Map;
import java.util.Set;

/**
 * Created by Dale on 20/07/16.
 */
public class AppCommandLineParser extends CommandLineParser<ICommand<Option>> {

    private class DownloadCommand extends Command<Option>{

        public DownloadCommand() throws InvalidArgumentException {
            super("file", "-");
            Option op = new Option("f", "flush", true, true) {
                @Override
                public boolean validateArgument(String argument) {
                    return true;
                }
            };
            Option op2 = new Option("en", "encode", false, true) {
                @Override
                public boolean validateArgument(String argument) {
                    return true;
                }
            };
            Option op3 = new Option("e", "encode", false, true) {
                @Override
                public boolean validateArgument(String argument) {
                    return true;
                }
            };
            addOption(op);
            addOption(op2);
            addOption(op3);
        }


        @Override
        public boolean execute(Map<String, String> optArgs, Set<String> commandArguments) {
            for(Map.Entry<String,String> s:optArgs.entrySet()){
                System.out.println(s.getKey() + " " + s.getValue());
            }

            for(String s:commandArguments){
                System.out.println("Command arg: " + s);
            }
            return false;
        }
    }

    {
        try {
            addCommand(new DownloadCommand());
        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
