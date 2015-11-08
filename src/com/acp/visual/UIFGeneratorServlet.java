package com.acp.visual;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.StopWatch;
import org.json.simple.JSONObject;

import com.acp.graph.Node;
import com.acp.instance.RuleInstance;

/**
 * Servlet implementation class VisualizerServlet
 */
public class UIFGeneratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UIFController controller;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UIFGeneratorServlet() {
        super();
        // TODO Auto-generated constructor stub
        controller = new UIFController();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		
			String process_name = request.getParameter("process");
			int step = Integer.parseInt(request.getParameter("step"));
			
			if(process_name.length()>4 && step >0)
			{	
				
				 StopWatch timer = new StopWatch();
				 
				 timer.start();
			
				JSONObject jsonObj = this.controller.getPartialProcessGraph(process_name, step);
				
				
			
				timer.stop();
				
				System.out.println(timer.getTime());
				
				jsonObj.put("time",timer.getTime());
				
				
				
				
				if(jsonObj  != null)
				{	
					response.setContentType("application/json");	
			
					response.getWriter().write(jsonObj.toString());
				}	
			}
			//response.getWriter().flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
