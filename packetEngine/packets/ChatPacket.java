package server.packetEngine.packets;

import server.packetEngine.Packet;

public class ChatPacket extends Packet {

	/**
	 * SVUID for serialization
	 */
	private static final long serialVersionUID = 3158757811479612130L;
	
	public int uniqueID;
	public String message;
	
	public ChatPacket(int UID, String msg) {
		super();
		this.uniqueID = UID;
		this.message = msg;
	}
	
	public int getUniqueID() {
		return uniqueID;
	}
	public String getMessage() {
		return message;
	}
	public long servialVUID() {
		return serialVersionUID;
	}
}
