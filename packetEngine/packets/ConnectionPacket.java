package server.packetEngine.packets;

import server.packetEngine.Packet;

public class ConnectionPacket extends Packet {

	/**
	 * SVUID for serialization
	 */
	private static final long serialVersionUID = 5738957476465820193L;
	
	public int uniqueID = -1;
	public String message;
	
	public ConnectionPacket(int UID, String msg) {
		this.uniqueID = UID;
		this.message = msg;
	}
	
	public ConnectionPacket(String msg) {
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
