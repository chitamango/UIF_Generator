package com.acp.test;

import com.acp.factory.AcpFactory;

public class TestFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AcpFactory factory = new AcpFactory();
		
		try {
			
			 System.out.println(factory.getProcessLocation("order_process"));
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
