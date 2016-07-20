package DesignTechniques.CommandLineParser;

import java.util.Map;

/**
 * Created by Dale on 19/07/16.
 */
public interface ICommand<T extends Option> extends IExecutableCommand {
    Command<T> addOption(T option);
    boolean hasOption(String option,boolean prefix);
    String getCommand();
    Option getOption(String optionPrefix);
    String getOptionPrefix();
    boolean validateCommandArg(int commandPos,String command);
    Map<String,Option> getRequiredOptions();
    Map<String,Option> getAllOptions();
}
