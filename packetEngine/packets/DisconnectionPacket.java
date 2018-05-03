package server.packetEngine.packets;

import server.packetEngine.Packet;

public class DisconnectionPacket extends Packet {

	/**
	 * SVUID for serialization
	 */
	private static final long serialVersionUID = 7676409364341054999L;

	public int uniqueID;
	
	public DisconnectionPacket(int UID, String msg) {
		this.uniqueID = UID;
	}
	
	public int getUniqueID() {
		return uniqueID;
	}

	public long servialVUID() {
		return serialVersionUID;
	}
}
