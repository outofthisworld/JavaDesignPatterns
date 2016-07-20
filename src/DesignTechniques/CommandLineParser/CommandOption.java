package DesignTechniques.CommandLineParser;

/**
 * Created by Dale on 20/07/16.
 */


@interface CommandOption {
    String command = "";
    String optionPrefix = "";
    String[] options = null;
    boolean required = false;
}
