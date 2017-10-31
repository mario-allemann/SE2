package chatLab.messages;

public class JoinMsg extends Message {
	private String name;
	
	public JoinMsg(String name) {
		super(MessageType.Join);
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	
}
