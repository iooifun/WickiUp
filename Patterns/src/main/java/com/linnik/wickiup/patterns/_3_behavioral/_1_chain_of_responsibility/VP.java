package com.linnik.wickiup.patterns._3_behavioral._1_chain_of_responsibility;

/**
 * @author LinnykOleh
 */
public class VP extends Handler {

	@Override
	public void handleRequest(Request request) {
		if(request.getRequestType() == RequestType.PURCHASE){
			if(request.getAmount() < 1500){
				System.out.println("VPs can approve purchases below 1500");
			}else{
				successor.handleRequest(request);
			}
		}
	}
}
