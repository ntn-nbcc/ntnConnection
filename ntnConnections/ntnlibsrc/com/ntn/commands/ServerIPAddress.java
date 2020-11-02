package com.ntn.commands;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerIPAddress {

	public ServerIPAddress() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerIPAddress si = new ServerIPAddress();
		si.getHostIP();
	}
	
	public String getHostIP() {
		String ip = "";
	try(final DatagramSocket socket = new DatagramSocket()){
		  socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
		  ip = socket.getLocalAddress().getHostAddress();
		  System.out.println("ip address: "+ip);
		}
	catch(Exception e) {
		
	}
	return ip;
	}
}
