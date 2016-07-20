package DesignTechniques.CommandLineParser;

import java.util.Map;
import java.util.Set;

/**
 * Created by Dale on 19/07/16.
 */
public interface ICommand<T> {
    boolean execute(Map<String,String> optArgs, Set<String> commandArguments);
    void addOption(T option);
    boolean hasOption(String option,boolean prefix);
    String getCommand();
    Option getOption(String optionPrefix);
    String getOptionPrefix();
    Map<String,Option> getRequiredOptions();
    Map<String,Option> getAllOptions();
}
