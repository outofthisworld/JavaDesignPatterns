package DesignTechniques.CommandLineParser;

/**
 * Created by Dale on 20/07/16.
 */
public class CommandLineParserError extends Exception{
    private final CommandLineParser.CommandParserError error;

    public CommandLineParserError(CommandLineParser.CommandParserError error,String message){
        super(message);
        this.error = error;
    }

    public CommandLineParser.CommandParserError getError() {
        return error;
    }
}
