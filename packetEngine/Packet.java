package server.packetEngine;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Packet implements Serializable {
	
	int clientUniqiueID;
	String packetType;
	
	public abstract long servialVUID();
	
}
