package nomeMesesGalego;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static int PORT=1111;
	public static void main(String[] args) {
		ServerSocket ss = (ServerSocket)null;
		Socket socket = (Socket)null;
		DataInputStream entrada = (DataInputStream)null;
		DataOutputStream salida = (DataOutputStream)null;
		int numMes =0;
		String nomeMes = "";
		
		try {
			ss = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			socket= ss.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			entrada = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			salida = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			numMes = entrada.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(numMes) {
		case 1:
			nomeMes ="Xaneiro";
			break;
		case 2:
			nomeMes ="Febreiro";
			break;
		case 3:
			nomeMes ="Marzo";
			break;
		case 4:
			nomeMes ="Xaneiro";
			break;
		case 5:
			nomeMes ="Xaneiro";
			break;
		case 6:
			nomeMes ="Xaneiro";
			break;
		case 7:
			nomeMes ="Xaneiro";
			break;
		case 8:
			nomeMes ="Xaneiro";
			break;
		case 9:
			nomeMes ="Xaneiro";
			break;
		case 10:
			nomeMes ="Xaneiro";
			break;
		case 11:
			nomeMes ="Xaneiro";
			break;
		case 12:
			nomeMes ="Xaneiro";
			break;
		}
		try {
			salida.writeUTF(nomeMes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

