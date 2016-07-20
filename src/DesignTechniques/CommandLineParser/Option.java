package DesignTechniques.CommandLineParser;

/**
 * Created by Dale on 19/07/16.
 */
public final class Option implements Cloneable {
    private final String option;
    private final boolean isOptional;
    private final String description;
    private final boolean requiresArgument;
    private OptionArgumentValidator argumentValidator;

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

    public Option(String option, String description, boolean requiresArgument, boolean isOptional,OptionArgumentValidator validator){
        this.option = option;
        this.isOptional = isOptional;
        this.requiresArgument = requiresArgument;
        this.description = description;
        this.argumentValidator = validator;
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

    public boolean validateOptionArgument(String argument){
        if(argumentValidator != null){
            return argumentValidator.validateOptionArgument(this.option, argument);
        }
        return true;
    }

    public String getUsage() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n required = ").append(!isOptional).append("\n required argument = ").append(requiresArgument).append("\n description = ").append(description).append("\n");
        return sb.toString();
    }

    public Option setArgumentValidator(OptionArgumentValidator argumentValidator){
        this.argumentValidator = argumentValidator;
        return this;
    }
}
