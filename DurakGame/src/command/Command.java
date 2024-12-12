package command;

public interface Command {

	boolean execute(String[] params) throws Exception;
}
