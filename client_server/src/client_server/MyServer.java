package client_server;
import java.net.*;
import java.io.*;

public class MyServer {
	public static void main(String args[]) {
		ServerSocket server;
		Socket socket;
		String s;
		InputStream Is;
		OutputStream Os;
		DataInputStream DIs;
		PrintStream Ps;
		try {
			server = new ServerSocket(4321);
			socket = server.accept();
			System.out.println("Server is ok");
			System.out.println("********************************");
			System.out.println("");
			Is = socket.getInputStream();
			Os = socket.getOutputStream();
			DIs = new DataInputStream(Is);
			Ps = new PrintStream(Os);
			
			DataInputStream in = new DataInputStream(System.in);
			while (true) {
				System.out.println("");
				System.out.println("please wait for client's massage... ");
				System.out.println("");
				s = DIs.readLine();
				System.out.println("小甜甜说： " + s);
				if (s.trim().equals("BYE"))
					break;
				System.out.println("小猫咪说： ");
				s = in.readLine();
				Ps.println(s);
				if(s.trim().equals("BYE"))
					break;
			}
			DIs.close();
			Ps.close();
			Is.close();
			Os.close();
			socket.close();
		}
		catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
}
