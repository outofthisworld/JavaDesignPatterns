package DesignTechniques.CommandLineParser;

/**
 * Created by Dale on 20/07/16.
 */
public class Main {


    public static String getErrorMessage(CommandLineParserError commandLineParserError){
        switch (commandLineParserError.getError()){
            case NO_ARGUMENT_SPECIFIED_FOR_OPTION:
                return "No argument specified for one or more of the options that require it try using help -display for proper command usage";
            case INVALID_ARGUMENT_SPECIFIED:
                return "Invalid argument specified, use: help -display for details";
            case NO_INPUT:
                return "No input was specified, please use: help -display for details";
            case MISSING_REQUIRED_OPTIONS:
                return "Missing one or more of the required options, use help -display for details";
            case INVALID_COMMAND:
                return "The specified command does not exist, try help -display for details";
            case OPTION_NOT_SUPPORTED:
                return "One of more of the specified options is not supported for this command, try using: help -display for details about this commands usage";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        AppCommandLineParser appCommandLineParser = new AppCommandLineParser();
        try {
            appCommandLineParser.parseCommandLine(args);
        } catch (CommandLineParserError commandLineParserError) {
            System.out.println(getErrorMessage(commandLineParserError));
        }
    }
}
