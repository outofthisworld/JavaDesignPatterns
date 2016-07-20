package DesignTechniques.CommandLineParser;

import sun.plugin.dom.exception.InvalidStateException;

import java.util.*;

/**
 * Created by Dale on 19/07/16.
 */
public class CommandLineParser<T extends ICommand> {
    private final HashMap<String, T> commands = new HashMap<>();

    public CommandLineParser() {}

    public void parseCommandLine(String[] args) throws CommandLineParserError {
        Objects.requireNonNull(args);

        if (args.length == 0)
            throwArgException(CommandParserError.NO_INPUT, "Invalid usage: No input was supplied");

        String command = args[0];
        T commandObj = getCommand(command);

        if (commandObj == null)
            throwArgException(CommandParserError.INVALID_COMMAND, "Invalid usage: The specified command does not exist");

        Map<String, Option> requiredOptions = commandObj.getRequiredOptions();
        Map<String, String> optArgs = new HashMap<>();
        Set<String> commandArguments = new LinkedHashSet<>();
        for (int i = 1, c = 0; i - c < args.length; i += 2) {
            String arg = args[i - c];

            if (arg.startsWith(commandObj.getOptionPrefix())) {
                if (!commandObj.hasOption(arg, true))
                    throwArgException(CommandParserError.OPTION_NOT_SUPPORTED,
                            "Invalid usage: Command does not support the option " + arg);

                Option o = commandObj.getOption(arg);
                if (o.requiresArgument()) {
                    if ((i + 1) - c > (args.length - 1))
                        throwArgException(CommandParserError.NO_ARGUMENT_SPECIFIED_FOR_OPTION, "Invalid usage: No argument specified for option " + arg);

                    if (!o.validateArgument(args[(i + 1) - c]))
                        throwArgException(CommandParserError.INVALID_ARGUMENT_SPECIFIED, "Invalid usage: Invalid argument specified for option " + arg);
                } else {
                    c++;
                }
                optArgs.put(arg, args[(i + 1) - c]);
                requiredOptions.remove(arg);
            } else {
                commandArguments.add(arg);
            }
        }

        if (requiredOptions.size() != 0)
            throwArgException(CommandParserError.MISSING_REQUIRED_OPTIONS, "Invalid usage: Missing required options: " + Arrays.toString(requiredOptions.keySet().toArray()));

        commandObj.execute(optArgs, commandArguments);
    }

    public void addCommand(T command) {
        if (commands.containsKey(command.getCommand()))
            throw new InvalidStateException("Command " + command.getCommand() + " already exists");

        commands.put(command.getCommand(), command);
    }

    public boolean removeCommand(Command command) {
        Set<Map.Entry<String, T>> entries = commands.entrySet();
        Iterator<Map.Entry<String, T>> it = entries.iterator();

        for (Map.Entry<String, T> t = null; it.hasNext(); t = it.next()) {
            if (t != null) {
                if (t.getValue().equals(command)) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }


    public T getCommand(String command) {
        return commands.get(command);
    }

    public void removeCommand(String commandName) {
        commands.remove(commandName);
    }

    private final void throwArgException(CommandLineParser.CommandParserError error, String message) throws CommandLineParserError {
        throw new CommandLineParserError(error, message);
    }

    public enum CommandParserError {
        NO_INPUT(1),
        INVALID_COMMAND(2),
        OPTION_NOT_SUPPORTED(3),
        NO_ARGUMENT_SPECIFIED_FOR_OPTION(4),
        INVALID_ARGUMENT_SPECIFIED(5),
        MISSING_REQUIRED_OPTIONS(6);

        int code;

        CommandParserError(int errorCode) {
            this.code = errorCode;
        }
    }
}
