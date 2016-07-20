package DesignTechniques.CommandLineParser;

import java.util.Map;
import java.util.Set;

/**
 * Created by Dale on 20/07/16.
 */
public interface IExecutableCommand {
    boolean execute(Map<String,String> optArgs, Set<String> commandArguments);
}
