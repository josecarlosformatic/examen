package nomeMesesGalego;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	public static int PORT=1111;
	public static String HOST="127.0.0.1";
	public static void main(String[] args) {
		System.err.println("Intentando conectar con el servido");
		Socket skt=(Socket)null;
		try {skt = new Socket(HOST, PORT);}
		catch (Exception ex) {
			System.err.println("La telefonista no está en línea");
			System.exit(-1);
		}
		System.out.println("conectado");
		int tel;
		BufferedReader teclado=new BufferedReader(new
				InputStreamReader(System.in));
		try {
			DataOutputStream salida = new
					DataOutputStream(skt.getOutputStream());

			DataInputStream entrada = new 
					DataInputStream(skt.getInputStream());

			tel=leerInt(teclado);
			salida.writeInt(tel);
			salida.flush();
			String n = entrada.readUTF();
			System.out.println(""+n);
			salida.close();
			entrada.close();
			skt.close();
			System.exit(0);
		}catch (IOException ex1) {ex1.printStackTrace(System.err);}
	}
	public static int leerInt(BufferedReader buff){
		int lee=0;
		boolean error;
		do {
			error=false;
			try {lee = Integer.parseInt(buff.readLine());}
			catch (NumberFormatException ex) {
				System.err.println("Entrada erronea, repetir:?");
				error=true;}
			catch (Exception ex){ex.printStackTrace(System.err);}
		} while (error);
		return lee;
	}
}

