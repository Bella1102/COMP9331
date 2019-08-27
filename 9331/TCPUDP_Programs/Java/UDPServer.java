
//Example: Java Server (UDP)

import java.io.*; 
import java.net.*;

class UDPServer {

	public static void main(String args[]) throws Exception{

		DatagramSocket serverSocket = new DatagramSocket(9876);    //Create datagram socket at port 9876

		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];

		while(true) {

			DatagramPacket receivePacket =
				new DatagramPacket(receiveData, receiveData.length);	//Create space for received datagram

			serverSocket.receive(receivePacket);	//Receive datagram

			String sentence = new String(receivePacket.getData()); 

			InetAddress IPAddress = receivePacket.getAddress();    //Get IP addr port #, of sender

			int port = receivePacket.getPort();

			String capitalizedSentence = sentence.toUpperCase();

			sendData = capitalizedSentence.getBytes();

			DatagramPacket sendPacket =
				new DatagramPacket(sendData, sendData.length, IPAddress,port);	//Create datagram to send to client

			serverSocket.send(sendPacket);	//Write out datagram to socket
		}
	}
}



// Pseudo code UDP server

// Create socket

// Bind socket to a specific port where clients can contact you
// Loop

// 	(Receive UDP Message from client x)+ 
// 	(Send UDP Reply to client x)*
// Close Socket






