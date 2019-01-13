package nl.hanze.web.rdw.server;

import java.net.InetAddress;

import javax.xml.ws.Endpoint;

public class RDWPublisher {
	public static void main(String[] args) {
		try {
			//String localHost = InetAddress.getLocalHost().getHostAddress();
			String localHost = "localhost";
			Endpoint.publish("http://"+ localHost + ":8888/RDWServices", new RDWServices());
			System.out.println("now serving RDW at " + localHost + ":8888");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}