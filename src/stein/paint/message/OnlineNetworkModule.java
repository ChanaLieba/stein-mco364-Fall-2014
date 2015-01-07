package stein.paint.message;

import java.io.IOException;

import stein.paint.PaintClient;

public class OnlineNetworkModule implements NetworkModule{

	private PaintClient client;
	
	public OnlineNetworkModule(PaintClient client){
		this.client = client;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		try{
			client.sendMessage(message);
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
}
