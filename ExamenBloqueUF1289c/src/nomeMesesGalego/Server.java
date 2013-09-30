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
		while(true) {
			try {
				socket= ss.accept();
				System.err.println("Nueva conexión aceptada");
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
				nomeMes = "Xaneiro";
				break;
			case 2:
				nomeMes = "Febreiro";
				break;
			case 3:
				nomeMes = "Marzo";
				break;
			case 4:
				nomeMes ="Abril";
				break;
			case 5:
				nomeMes = "Maio";
				break;
			case 6:
				nomeMes = "Xuño";
				break;
			case 7:
				nomeMes = "Xullo";
				break;
			case 8:
				nomeMes = "Agosto";
				break;
			case 9:
				nomeMes = "Septembro";
				break;
			case 10:
				nomeMes = "Outubro";
				break;
			case 11:
				nomeMes = "Novembro";
				break;
			case 12:
				nomeMes = "Decembro";
				break;
			default:
				nomeMes = "Os meses do ano estan entre un e doce. Pailán";
			}
			try {
				salida.writeUTF(nomeMes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Conexion terminada");
		}
	}
}

