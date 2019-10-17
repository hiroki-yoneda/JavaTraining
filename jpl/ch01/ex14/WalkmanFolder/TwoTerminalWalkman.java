package jpl.ch01.ex14.WalkmanFolder;

public class TwoTerminalWalkman extends Walkman{

	private String addTerminal = "端子02";

	public void terminal() {
		super.terminal();
		System.out.println(addTerminal);
	}

}
