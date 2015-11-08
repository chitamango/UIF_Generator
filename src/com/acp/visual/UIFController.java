package com.acp.visual;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.lang3.StringEscapeUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

import org.json.simple.JSONObject;

import com.acp.factory.AcpFactory;
import com.acp.graph.Edge;
import com.acp.graph.Graph;
import com.acp.graph.Node;
import com.acp.instance.ProcessInstance;
import com.acp.instance.RuleInstance;
import com.acp.instance.TransitionRule;
import com.acp.process.AndType.Atom;

public class UIFController {
	
	
	private AcpFactory fac;
	
	
	public UIFController()
	{
		fac = new AcpFactory();
		
	}
	
	
	
	/*
	 * 	Method to return all nodes
	 * 
	 */
	
	public ArrayList<Node<RuleInstance>> getAllNodes(String ProcessName)
	{
		
		
		ArrayList<RuleInstance> RuleList = null;
		ArrayList<Node<RuleInstance>> Nodelist = new ArrayList<Node<RuleInstance>>();
		
		try {
			
		
			
			RuleList = this.fac.getRuleInstanceList(ProcessName);
			
			ListIterator<RuleInstance> itr = RuleList.listIterator();
			
			while(itr.hasNext())
			{
				
				RuleInstance rule = itr.next();
				
				Node<RuleInstance> node = new Node<RuleInstance>(rule);
				
				Nodelist.add(node);
				
			}
			
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Nodelist;
		
	}
	
	/*
	 *   method to return all edges
	 * 
	 */
	
	public ArrayList<Edge> getAllEdges(ArrayList<Node<RuleInstance>> nodelist)
	{
		
		//ArrayList to store edges 
		ArrayList<Edge> EdgeList = new ArrayList<Edge>(); 
		
		
		Node<RuleInstance> a = null;
		Node<RuleInstance> b = null;
		
		
		try {
			
			//compare current node to other node
			//to determine b
			//current node is going to be a 
			//we compare a node artifact,toState
			//b node artifact,fromState
			
			ListIterator<Node<RuleInstance>> itr = nodelist.listIterator() ;
			//loop all a node
			while(itr.hasNext())
			{
			
				//the current node always be a node in the edge
				a = itr.next();  
				
				
				//System.out.println(a.toString()+":");
				
				
				//loop to search for node b
				for(int i = 0; i <nodelist.size(); i++ )
				{
					int match_state = 0;
					int match_atom = 0;
					
					// skip itself
					if(a != nodelist.get(i))
					{
						
						//System.out.println(nodelist.get(i).toString());
						
						//System.out.println("in i");
						
						//get rule instance for node a and b
						RuleInstance Node_A_rule_instance = a.getData();
						RuleInstance Node_B_rule_instance = nodelist.get(i).getData();
						
						//get transition rule for node a and b
						ArrayList<TransitionRule> Node_A_transition_rule =  Node_A_rule_instance.getTransitionRules();
						ArrayList<TransitionRule> Node_B_transition_rule = Node_B_rule_instance.getTransitionRules();
						
						//get atoms list for a node and  node b
						ArrayList<Atom> Node_A_Atoms = Node_A_rule_instance.getAtoms();
						ArrayList<Atom> Node_B_Atoms = Node_B_rule_instance.getAtoms();
						
						int number_of_state_in_atom_b = 0;
						
						for(int x = 0; x < Node_B_Atoms.size(); x ++ )
						{
							Atom atom_con_b = Node_B_Atoms.get(x);
							
							if(atom_con_b.getType().equalsIgnoreCase("state"))
							 {
								number_of_state_in_atom_b++;
								
							 }
							
							
						}
						
						//each transition rule in node a 
						//System.out.println("transition a contains " + Node_A_transition_rule.size() + " Rules");
						
						for(int j = 0; j < Node_A_transition_rule.size(); j++)
						{
								
							TransitionRule   transition_rule_a =    Node_A_transition_rule.get(j); 
							String artifactName_rule_a = transition_rule_a.getArtifact();
							String fromState_rule_a = transition_rule_a.getFromState();
							String toState_rule_a  = transition_rule_a.getToState();
							
							
							//System.out.println("Node B Atom contains " + Node_B_Atoms.size() + " atoms");
							
							
							for(int l =0; l < Node_B_Atoms.size(); l++ )
							{
								
					
								 Atom atom_con_b = Node_B_Atoms.get(l);
								 
								 if(atom_con_b.getType().equalsIgnoreCase("state"))
								 {
									 String artifactName_atom_b = atom_con_b.getArtifact();
									 String artifactState_atom_b = atom_con_b.getValue();
								
									 //compare condition atom b to transition rule  a
									 if(artifactName_atom_b.equalsIgnoreCase(artifactName_rule_a)&& artifactState_atom_b.equalsIgnoreCase(toState_rule_a)  )
									 {
										    match_atom++;
										  //  System.out.println("matched");
										    //problem with multiple transitions	
		 
									 }
									else if(Node_A_transition_rule.size()< number_of_state_in_atom_b)
									{
										
										
										//check if artifact in con b exist in con a or not
										//System.out.println("Node A Atom contains " + Node_A_Atoms.size() + " atoms");
										
										for(int m =0; m < Node_A_Atoms.size();m++)
										{
											
											 Atom atom_con_a = Node_A_Atoms.get(m);
											 
										
										
											 if(atom_con_a.getType().equalsIgnoreCase("state"))
											 {
												 String artifactName_atom_a = atom_con_a.getArtifact();
												 String artifactState_atom_a = atom_con_a.getValue();
												
												
												 
												 //skip atom b that match with transition a
												//if(!(artifactName_atom_b.equalsIgnoreCase(artifactName_rule_a) && artifactState_atom_b.equalsIgnoreCase(toState_rule_a))) 
												// {
													 //compare condition atom a to condition atom  b
													 
													 if(!artifactName_atom_a.equalsIgnoreCase(artifactName_atom_b ))  
													 {
														 if(!artifactState_atom_a.equalsIgnoreCase(artifactState_atom_b ))
														 {
															 if( !artifactState_atom_b.equalsIgnoreCase("start") )
															 {	 
																 match_atom--;
														      //  System.out.println("unmatched");
															 }
															
														 }  
								 
													 }
													 else
													 {
														 
														 
														 if(artifactName_atom_b.equalsIgnoreCase(artifactName_rule_a) ) 
														 {
															 if( artifactState_atom_b.equalsIgnoreCase(toState_rule_a))
															 { 
																 match_atom++;
															 }
														 }	 
													
														 
														 
													 }
													 
												// }
										
											 
										
										
											 }
											 
										}
										
										
										
									}
								

									 
								 }
								
								
							}
							
						}
						
						
						
						//System.out.println(match_atom);
						
						if( match_atom >0 && match_atom == Node_A_transition_rule.size() )
						{	
						
							b = nodelist.get(i);
							
							
							Edge edge = new Edge(a,b);
							
							//System.out.println(edge.toString());
							
							EdgeList.add(edge);
							
							
							
						}	
					
						
						
					}//end of if
										
					
				}
				
			
				
			}
			
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return EdgeList;
		
	}
	
	
	public  JSONObject getPartialProcessGraph( String ProcessName,int step) 
	{
		
		 JSONObject JsonObj = null;
		
		try {
			
			if(this.fac.getProcessLocation(ProcessName).exists());
			{
			
				
				ArrayList<Node<RuleInstance>> Nodes = this.getAllNodes(ProcessName);
				ArrayList<Edge> Edges = this.getAllEdges(Nodes);
				
				Graph process_graph = new Graph();
				process_graph.setDirected();
				
				//add node and add edges
				for(int i =0; i < Nodes.size(); i++)
				{
					Nodes.get(i).index = i;
					process_graph.addNode(Nodes.get(i));
					
					
				}
				
				for(int j = 0; j < Edges.size(); j++ )
				{
					
					process_graph.addEdge(Edges.get(j));
					
					
				}
				
				
				//process_graph.printNodes();
				//process_graph.printEdges();
				
	
				
				process_graph.findConnectedProcessNodes(Nodes.get(0),step, 0);
				
				
				ArrayList<Node<RuleInstance>> visitednodes = process_graph.getVisitedNodes();
				ArrayList<Edge> visitedEdges = process_graph.getVisitedEdges();
				
				//System.out.println(visitednodes.toString());
				//System.out.println(visitedEdges.toString());
				
				  JsonObj = this.processToJsonTexT(visitednodes, visitedEdges);
			
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("file location not found");
		}
		
		
		
		
		
		return JsonObj;
		
		
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject  processToJsonTexT(ArrayList<Node<RuleInstance>> nodes, ArrayList<Edge>  edges)
	{
			
		
		JSONObject main_obj = new JSONObject();
		
		
		//array of json object
		JSONObject[] node_array = new JSONObject[nodes.size()]; 
		JSONObject[] edge_array = new JSONObject[edges.size()]; 
		
		//insert nodes
		
		for(int i =0; i < nodes.size(); i++)
		{
			
			
			
			JSONObject obj = new JSONObject();
	
			
			Node<RuleInstance> current_node = nodes.get(i);
			
			ArrayList<Atom> atoms = current_node.getData().getAtoms();
			ArrayList<String> ui_list = new ArrayList<String>(); 
			
			
			for(int j =0; j < atoms.size(); j++)
			{
				
				Atom current_atom = atoms.get(j);
				
				if(current_atom.getType().equalsIgnoreCase("input"))
				{
					
					
					String input =   current_atom.getAttribute();
					
					ui_list.add(input);
		 
				}
					

			}
			
			
			
			String[] ui_array = new String[ui_list.size()];
			
			for(int l =0; l < ui_list.size(); l++)
			{
				 ui_array[l] = ui_list.get(l);
				
	
			}
			
			
			// {id: 1, label: 'Get HTML', image: url, shape: 'image'}
			
			//String test = ui.replaceAll("\\", "");
			 obj.put("shape","image");  
			 obj.put("image",ui_array);
		      obj.put("label",current_node.getData().getRuleName());
		      obj.put("id",current_node.index);
			
			
		      node_array[i] = obj;
		     
		}
		
		
		for(int k = 0; k < edges.size(); k++)
		{
			//{from: 1, to: 2, length: 300}
			
			Edge current_edge = edges.get(k);
			
			int from = current_edge.a.index;
			int to  = current_edge.b.index;
			int length = 300;
			
			JSONObject obj = new JSONObject();
			 
			 obj.put("length",length);
		      obj.put("to",to);
		      obj.put("from",from);
			
		    // System.out.println( obj.toJSONString());
		      
		      edge_array[k] = obj;
			
		}
		
		
		main_obj.put("nodes", node_array);
		main_obj.put("edges", edge_array);
		
		
		 
		
		
		return main_obj;
		
	}
	
	

	
	
	
	
	

}
