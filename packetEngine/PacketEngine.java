package server.packetEngine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import client.blackjack.Player;
import server.eventEmitter.Event;
import server.packetEngine.packets.ChatPacket;

/**
 * @author Adrian Kardasz
 * Engine to convert classes that extend the packet class to a byte[]
 * that can be sent using Datagram
 *
 */
public class PacketEngine {

	/**
	 * Converts a packet of any type as long as
	 * it extends Packet.class to a Byte[] that 
	 * can be sent through a network.
	 * @param packet
	 * @return byte[]
	 */
	public static <P extends Packet> byte[] convertPacketToBytes(P packet) {

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(baos);
			oos.writeObject(packet);

			byte[] data = baos.toByteArray();

			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	/**
	 * Converts the byte[] back into the original packet and returns that packet/packet type.
	 * @param bytes
	 * @return packet
	 */
	@SuppressWarnings("unchecked")
	public static <P extends Packet> P convertByteToPacket(byte[] bytes) {
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			ObjectInputStream is = new ObjectInputStream(in);

			return (P) is.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the packet type name, so if a ChatPacket is sent
	 * this returns the String "ChatPacket"
	 * @param packet
	 * @return String
	 */
	public static <P extends Packet> String getPacketType(Packet packet) {
		return packet.getClass().getSimpleName();
	}

	
	
	/**
	 * Tests that the conversion works, and shows usage of the PacketEngine.
	 * @param args
	 */
	public static void main(String[] args) {
    	ChatPacket testSendPacket =
    			new ChatPacket(01, "Hello there, the test has worked! Hoorah!");
    	
    	//Converts the packet into a byte[], then prints the byte[].
		byte[] testSendByte = convertPacketToBytes( testSendPacket );
		System.out.println("Byte.toString: " + testSendByte.toString() );
		
		//converts the byte[] back into the packet then prints the message of the packet
		System.out.println("Byte Conversion to Packet");
		System.out.println("Recieved Packet Type:" + getPacketType(convertByteToPacket(testSendByte)));
		
		ChatPacket testRecievePacket = convertByteToPacket(testSendByte);

		System.out.println(testRecievePacket.message);

    }

}
