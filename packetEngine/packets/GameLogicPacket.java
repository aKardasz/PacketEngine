package server.packetEngine.packets;

import client.blackjack.Player;
import server.packetEngine.Packet;

public class GameLogicPacket extends Packet {

	/**
	 * SVUID for serialization
	 */
	private static final long serialVersionUID = 5738957476465820193L;
	
	public int uniqueID = -1;
	public String message;
	private Player player;
	
	public GameLogicPacket(int UID, Player player) {
		this.uniqueID = UID;
		this.player = player;
	}
	
	public GameLogicPacket(String msg) {
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
