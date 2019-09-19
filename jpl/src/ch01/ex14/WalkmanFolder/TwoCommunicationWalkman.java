package practice01.WalkmanFolder;

public class TwoCommunicationWalkman extends TwoTerminalWalkman{

	private String chat01;
	private String chat02;

	public void setChat(String chat01, String chat02) {
		this.chat01 = chat01;
		this.chat02 = chat02;
	}

	public void printCommuni() {
		System.out.println(chat01);
		System.out.println(chat02);
	}

}
