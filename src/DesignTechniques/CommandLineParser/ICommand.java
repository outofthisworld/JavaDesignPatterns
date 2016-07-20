package DesignTechniques.CommandLineParser;

import java.util.Map;

/**
 * Created by Dale on 19/07/16.
 */
public interface ICommand<T> extends IExecutableCommand {
    void addOption(T option);
    boolean hasOption(String option,boolean prefix);
    String getCommand();
    Option getOption(String optionPrefix);
    String getOptionPrefix();
    Map<String,Option> getRequiredOptions();
    Map<String,Option> getAllOptions();
}
