package br.ufpe.cin.anfa.net;

import java.net.InetAddress;
import br.ufpe.cin.anfa.buffer.Buffer;
import br.ufpe.cin.anfa.buffer.exception.BufferException;

public class Socket {
	InetAddress destinationIP;
	int destinatonPort;
	Buffer sendBuffer;
	Buffer receiveBuffer;
	long readBease;
	
	/**
	 * 
	 * @param data The bytes to be sent.
	 * @throws BufferException When the buffer is full.
	 */
	public void sendData(byte[] data) throws BufferException {
		sendBuffer.insertData(data);
	}
	
	/**
	 * 
	 * @param ammount How many bytes to be read.
	 * @return The data requested.
	 * @throws BufferException When something weird happens.
	 */
	public byte[] receiveData(long ammount) throws BufferException {
		byte[] data = receiveBuffer.getData(readBease, readBease+ammount);
		readBease += ammount;
		return data;
	}
}
