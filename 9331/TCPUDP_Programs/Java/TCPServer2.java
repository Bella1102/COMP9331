
// Example: Java Server (TCP)

import java.io.*; 
import java.net.*;

class TCPServer {

	public static void main(String argv[]) throws Exception {

		String clientSentence; 
		String capitalizedSentence;
		ServerSocket doorbellSocket = new ServerSocket(6789); //Create welcoming socket at port 6789

		while(true) {

			Socket connectSocket = doorbellSocket.accept(); // Wait, on welcoming socket for contact by client
			BufferedReader inFromClient =                   // Create input stream, attached to socket
				new BufferedReader(new 
				InputStreamReader(connectSocket.getInputStream()));

			DataOutputStream outToClient =
				new DataOutputStream(connectSocket.getOutputStream());  // Create output stream, attached to socket

			clientSentence = inFromClient.readLine();				    // Read in line from socket

			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);                // Write out line to socket
		}// End of while loop, loop back and wait for another client connection
	}
}


// Pseudo code TCP server

// Create socket (doorbellSocket)
// Bind socket to a specific port where clients can contact you
// Register with the kernel your willingness to listen that on 
// 	socket for client to contact you
// Loop
// 	Listen to doorbell Socket for an incoming connection, 
// 	get a connectSocket
// 	Read and Write Data Into connectSocket to 
// 	Communicate with client
// 	Close connectSocket 
// End Loop
// Close doorbellSocket
















