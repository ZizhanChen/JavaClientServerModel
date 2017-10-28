package client_server;
import java.net.*;
import java.io.*;

public class DaytimeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hostname;
		if(args.length > 0){
			hostname = args[0];
		}
		else {
			hostname = "localhost";
		}
		try{
			Socket theSocket = new Socket(hostname, 13);
			InputStream timeStream = theSocket.getInputStream();
			StringBuffer time = new StringBuffer();
			int c;
			while ((c = timeStream.read()) != -1)
			{
				time.append((char) c);
			}
			String timeString = time.toString().trim();
			System.out.println("It is " + timeString + " at " + hostname);
		}
		catch (UnknownHostException e){
			System.out.println(e);
		}
		catch (IOException e){
			System.out.println(e);
		}

	}

}
