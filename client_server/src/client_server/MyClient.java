package client_server;
import java.net.*;
import java.io.*;

public class MyClient {
	public static void main (String args[]) {
		Socket socket;
		String s = "zizhan";
		String len;
		InputStream Is;
		OutputStream Os;
		DataInputStream DIs;
		PrintStream Ps;
		try {
			socket = new Socket("localhost", 4321);
			System.out.println("client ok");
			System.out.println("********************************");
			System.out.println("");
			Is = socket.getInputStream();
			Os = socket.getOutputStream();
			DIs = new DataInputStream(Is);
			Ps = new PrintStream(Os);
			DataInputStream in = new DataInputStream(System.in);
			while (true) {
				System.out.println("小甜甜 说: ");
				s = in.readLine();
				Ps.println(s);
				if(s.trim().equals("BYE")) 
					break;
				else {
					System.out.println("");
					System.out.println("please wait for server's message...");
					System.out.println("");
				}
				s = DIs.readLine();
				System.out.println("小猫咪说： " + s);
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
			System.out.println("Error: " + e);
		}
	}
}
