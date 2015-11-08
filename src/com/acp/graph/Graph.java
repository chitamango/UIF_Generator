package com.acp.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import com.acp.instance.RuleInstance;

public class Graph {
	
	protected Vector<Node<RuleInstance>> nodes = new Vector<Node<RuleInstance>>();
    protected Vector<Edge> edges = new Vector<Edge>();
    protected boolean directed = false;
    protected boolean sortedNeighbors = false;
 
     
    public double[][] getAdjacencyMatrix() {
        double[][] adjMatrix = new double[nodes.size()][nodes.size()];
         
        for(int i = 0; i < nodes.size(); i++)
            for(int j = 0; j < nodes.size(); j++)
                if(i == j)
                    adjMatrix[i][j] = 0;
                else
                    adjMatrix[i][j] = Double.POSITIVE_INFINITY;
                 
        for(int i = 0; i < nodes.size(); i++) {
            Node node = nodes.elementAt(i);
            //System.out.println("Current node: " + node);
             
            for(int j = 0; j < edges.size(); j++) {
                Edge edge = edges.elementAt(j);
                 
                if(edge.a == node) {
                    int indexOfNeighbor = nodes.indexOf(edge.b);
                     
                    adjMatrix[i][indexOfNeighbor] = edge.weight;
                }
            }
        }
         
        return adjMatrix;
    }
     
    public void setDirected() {
        directed = true;
    }
     
    public void setUndirected() {
        directed = false;
    }
     
    public boolean isDirected() {
        return directed;
    }
     
    public boolean isSortedNeighbors() {
        return sortedNeighbors;
    }
     
    public void setSortedNeighbors(boolean flag) {
        sortedNeighbors = flag;
    }
     
    public int indexOf(Node a) {
        for(int i = 0; i < nodes.size(); i++)
            if(nodes.elementAt(i).data.equals(a.data))
                return i;
                 
        return -1;
    }
     
    public Vector<Node<RuleInstance>> getNodes() {
        return nodes;
    }
     
    public Vector<Edge> getEdges() {
        return edges;
    }
     
    public Node<RuleInstance> getNodeAt(int i) {
        return nodes.elementAt(i);
    }
     
    public void unvisitAllNodes() {
        for(int i = 0; i < nodes.size(); i++)
            nodes.elementAt(i).unvisit();
    }
    
    /*
     * 
     * method to get member
     * 
     * 
     */
    
    public Vector<Node<RuleInstance>> getNeighbors(Node<RuleInstance> a) {
    	
        Vector<Node<RuleInstance>> neighbors = new Vector<Node<RuleInstance>>();
         
        for(int i = 0; i < edges.size(); i++) {
            Edge edge = edges.elementAt(i);
             
            if(edge.a == a)
                neighbors.add(edge.b);
                 
            if(!directed && edge.b == a)
                neighbors.add(edge.a);
        }
         
        if(sortedNeighbors)
            Collections.sort(neighbors);
         
        return neighbors;
        
    }
     
    public int addNode(Node<RuleInstance> a) {
        nodes.add(a);
         
        return nodes.size() - 1;
    }
     
    public void addEdge(Edge a) {
        edges.add(a);
         
        if(!directed)
            edges.add(new Edge(a.b, a.a, a.weight));
    }
     
    public void printNodes() {
        System.out.println(nodes);
    }
     
    public void printEdges() {
        System.out.println(edges);
    }
    
   /*
    * 
    *  method to find process step 
    * 
    */
    public  void findConnectedProcessNodes(Node<RuleInstance> start_node, int step, int step_count) {
        
    	
    	
    	//set visit
    	start_node.visit();
    	
    	//System.out.println(start_node.toString());
    	
    	//System.out.println(step_count);
    	
    	//System.out.println(step);
    	
    	//compare value of a global step with user step
    	if(step_count < step && step != 1)
    	{
    		//increase global step
    		step_count ++;
    		    		
	        //get all neighbors of a start node
	    	Vector<Node<RuleInstance>> neighbors = this.getNeighbors(start_node);
	    	
	    	//System.out.println(neighbors);
	 
	    	//loop through each member
	        for(int i = 0; i < neighbors.size(); i++)
	        {	
	        	//if node is not visited 
	            if(!neighbors.elementAt(i).isVisited())
	            {	
	            
	            		
	            	
	            	//call recursive on the  current neighbors node
	            	findConnectedProcessNodes( neighbors.elementAt(i), step,  step_count );
	                
	            }    
	        }
    	
    	}
    	else if(step == 1)
    	{
    		
    		Vector<Node<RuleInstance>> neighbors = this.getNeighbors(start_node);
    		
    		for(int i = 0; i < neighbors.size(); i++)
	        {
    			neighbors.elementAt(i).visit();
    		
	        }
    		
    	}
   
    }
    
 
	
	public ArrayList<Node<RuleInstance>> getVisitedNodes()
	{
		
		ArrayList<Node<RuleInstance>> visitedNodes = new ArrayList<Node<RuleInstance>>();
		
		for(int i = 0;i < this.nodes.size(); i++ )
		{
			if(this.nodes.elementAt(i).isVisited() == true)
			{
			
				visitedNodes.add(this.nodes.elementAt(i));
				
			}
			
		}
		
		
		return visitedNodes;
			
	}
	
	public ArrayList<Edge> getVisitedEdges()
	{
		
		   ArrayList<Node<RuleInstance>> visitedNodes = this.getVisitedNodes();
		
		   ArrayList<Edge> visitedEdges =  new ArrayList<Edge>();
	         
	        for(int i = 0; i < edges.size(); i++) {
	        	
	            Edge edge = edges.elementAt(i);
	            Node<RuleInstance> a_node = edge.a;
	            Node<RuleInstance> b_node = edge.b;
	            boolean  a_node_check = false;
	            boolean  b_node_check = false;
	            
	            	//loop find a
	               for(int j = 0; j < visitedNodes.size(); j++)
	               {
	            	   if(a_node == visitedNodes.get(j) )
	            	   {
	            		   
	            		   a_node_check = true;
	            		   break;
	            		   
	            	   }
	     
	               }
	               
	               //loop find b
	               for(int k = 0; k < visitedNodes.size(); k++)
	               {
	            	   if(b_node == visitedNodes.get(k) )
	            	   {
	            		   
	            		   b_node_check = true;
	            		   break;
	            		   
	            	   }
	            	   
	            	   
	            	   
	               }
	               
	              if(a_node_check && b_node_check)
	              {
	            	  
	            	  visitedEdges.add(edge);
	            	  
	            	  
	              }
	            
	            
	          
	        }
	        
	        
	        return visitedEdges;
	         
	        
		
	}

	
	

}
