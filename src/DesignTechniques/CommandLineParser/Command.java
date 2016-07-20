package DesignTechniques.CommandLineParser;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Dale on 19/07/16.
 */
public abstract class Command<T extends Option> implements ICommand<T> {
    private final String command;
    private final String optionPrefix;
    private final HashMap<String,T> options = new HashMap<>();
    private HashMap<String,Option> requiredOptions;

    public Command(String commandName,String optionPrefix) throws InvalidArgumentException {
        this.command = commandName;
        this.optionPrefix = optionPrefix;
    }

    public void addOption(T option){
        Objects.requireNonNull(option);
        options.put(optionPrefix+option.getOption(),option);
        if(!option.isOptional() && requiredOptions != null){
            requiredOptions.put(optionPrefix+option.getOption(), option);
        }
    }

    public Option getOption(String optionPrefix){
        return options.get(optionPrefix);
    }

    public boolean hasOption(String option, boolean hasPrefix){
        Objects.requireNonNull(option);
        if(hasPrefix)
            return options.containsKey(option);

        return options.containsKey(optionPrefix+option);
    }

    public Map<String,Option> getRequiredOptions(){
        if(requiredOptions != null){
            return requiredOptions;
        }
        HashMap<String,Option> map = new HashMap<>(options.values().size());
        for(Option op: options.values()){
            map.put(optionPrefix+op.getOption(),op);
        }
        requiredOptions = map;
        return map;
    }

    @Override
    public Map<String,Option> getAllOptions() {
        return (Map<String, Option>) options.clone();
    }

    public String getCommand(){
        return command;
    }

    @Override
    public String getOptionPrefix() {
        return optionPrefix;
    }
}
