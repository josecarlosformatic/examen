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
		DataInputStream entrada2 = (DataInputStream)null;
		DataInputStream entrada1 = (DataInputStream)null;
		DataOutputStream salida = (DataOutputStream)null;
		int numMes =0;
		String nomeMes = "";
		String idioma = "";

		try {
			ss = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			System.out.println("Esperando conexion");
			try {
				socket= ss.accept();
				System.err.println("Nueva conexión aceptada");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				entrada1 = new DataInputStream(socket.getInputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				idioma = entrada1.readUTF();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				entrada2 = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				numMes = entrada2.readInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(idioma.compareTo("gallego") == 0){
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
			}
			else {
				switch(numMes) {
				case 1:
					nomeMes = "January";
					break;
				case 2:
					nomeMes = "February";
					break;
				case 3:
					nomeMes = "March";
					break;
				case 4:
					nomeMes ="April";
					break;
				case 5:
					nomeMes = "May";
					break;
				case 6:
					nomeMes = "June";
					break;
				case 7:
					nomeMes = "July";
					break;
				case 8:
					nomeMes = "August";
					break;
				case 9:
					nomeMes = "September";
					break;
				case 10:
					nomeMes = "October";
					break;
				case 11:
					nomeMes = "November";
					break;
				case 12:
					nomeMes = "December";
					break;
				default:
					nomeMes = "los meses van del 1 al doce.";
				}
			}
			try {
				salida = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

