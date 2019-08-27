
//Example: Java Client (TCP)

import java.io.*; 
import java.net.*; 

class TCPClient {

	public static void main(String argv[]) throws Exception {

		String sentence;
		String modifiedSentence;

		BufferedReader inFromUser =
		new BufferedReader(new InputStreamReader(System.in));	// Create input stream

		Socket connectSocket = new Socket("hostname", 6789);	// Create client socket, connect to server

		DataOutputStream outToServer =
		new DataOutputStream(connectSocket.getOutputStream());	// Create output stream attached to socket

		BufferedReader inFromServer =
			new BufferedReader(new 
			InputStreamReader(connectSocket.getInputStream()));

		sentence = inFromUser.readLine(); 

		outToServer.writeBytes(sentence + '\n'); 

		modifiedSentence = inFromServer.readLine();

		System.out.println("FROM SERVER: " + modifiedSentence); 

		connectSocket.close();
	}
}


// Pseudo code TCP client

// Create socket, connectSocket
// Do an active connect specifying the IP address and 
// 	port number of server
// Read and Write Data Into  connectSocket to 
// 	Communicate with server
// Close connectSocket












