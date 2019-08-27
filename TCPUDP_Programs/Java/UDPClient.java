
//Example: Java Client (UDP)

import java.io.*; 
import java.net.*; 

class TCPClient {

	public static void main(String argv[]) throws Exception {

		BufferedReader inFromUser =
		new BufferedReader(new InputStreamReader(System.in));	// Create input stream

		DatagramSocket clientSocket = new DatagramSocket();	   //Create client socket, DatagramSocket, but no port

		InetAddress IPAddress = InetAddress.getByName("hostname");	//Translate hostname to IP address using DNS

		byte[] sendData = new byte[1024]; 
		byte[] receiveData = new byte[1024];

		String sentence = inFromUser.readLine();

		sendData = sentence.getBytes(); 

		DatagramPacket sendPacket =
			new DatagramPacket(sendData, sendData.length, IPAddress, 9876);    //Create datagram with data-to-send, length, IP addr, port

		clientSocket.send(sendPacket);	//Send datagram to server

		DatagramPacket receivePacket =
			new DatagramPacket(receiveData, receiveData.length);

		clientSocket.receive(receivePacket);	//Read datagram from server

		String modifiedSentence =
			new String(receivePacket.getData());

		System.out.println("FROM SERVER:" + modifiedSentence); 

		clientSocket.close();
	}
}



// Pseudo code UDP client

// Create socket
// Loop
// 	(Send Message To Well-known port of server)+
// 	(Receive Message From Server) 
// Close Socket







