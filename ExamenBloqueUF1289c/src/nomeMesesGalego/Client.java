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
		System.err.println("Intentando conectar con el servidor");
		Socket skt=(Socket)null;
		try {skt = new Socket(HOST, PORT);}
		catch (Exception ex) {
			System.err.println("El servidor no está en línea");
			System.exit(-1);
		}
		System.out.println("conectado");
		int numMes;
		String idioma;
		
		BufferedReader teclado=new BufferedReader(new
				InputStreamReader(System.in));
		try {
			DataOutputStream salida = new
					DataOutputStream(skt.getOutputStream());

			DataInputStream entrada = new 
					DataInputStream(skt.getInputStream());

			idioma = leerString(teclado);
			salida.writeUTF(idioma);
			salida.flush();
			numMes=leerInt(teclado);
			salida.writeInt(numMes);
			salida.flush();
			String nomeMes = entrada.readUTF();
			System.out.println(""+nomeMes);
			salida.close();
			entrada.close();
			skt.close();
			System.exit(0);
		}catch (IOException ex1) {ex1.printStackTrace(System.err);}
	}
	private static String leerString(BufferedReader buff) {
		String lee = "";
		boolean error;
		System.out.println("idioma");
		do {
			error=false;
			try {
				lee = buff.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(lee.compareTo("gallego") != 0){
				if(lee.compareTo("ingles") != 0){
					System.err.println("Solo en ingles o gallego:?");
					System.out.println("idioma");
					error = true;
				}
			}
			
		}while (error);
		return lee;
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

