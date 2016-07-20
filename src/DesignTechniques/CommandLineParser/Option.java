package DesignTechniques.CommandLineParser;

/**
 * Created by Dale on 19/07/16.
 */
public abstract class Option implements Cloneable,ArgumentValidator {
    private final String option;
    private final boolean isOptional;
    private final String description;
    private final boolean requiresArgument;

    public Option(String option){
        this.option = option;
        this.isOptional = false;
        this.requiresArgument = false;
        this.description = "";
    }

    public Option(String option, boolean isOptional){
        this.option = option;
        this.isOptional = isOptional;
        this.requiresArgument = false;
        this.description = "";
    }

    public Option(String option, boolean requiresArgument, boolean isOptional){
        this.option = option;
        this.isOptional = isOptional;
        this.requiresArgument = requiresArgument;
        this.description = "";
    }

    public Option(String option, String description, boolean requiresArgument, boolean isOptional){
        this.option = option;
        this.isOptional = isOptional;
        this.requiresArgument = requiresArgument;
        this.description = description;
    }

    public boolean requiresArgument(){
        return this.requiresArgument;
    }

    public String getOption() {
        return option;
    }

    public boolean isOptional() {
        return isOptional;
    }

    public String getDescription() {
        return description;
    }
}
