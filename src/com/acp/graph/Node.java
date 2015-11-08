package com.acp.graph;

public class Node<RuleInstance> implements Comparable<Node<RuleInstance>> {

	protected RuleInstance data;
    protected boolean visited;
    public Integer index = null;
    public Integer lowlink = null;
    public double distance = Double.POSITIVE_INFINITY;
    public Node<RuleInstance> predecessor = null;
     
    public Node(RuleInstance data) {
        this.data = data;
        
        
    }
     
    public Node() {
         
    }
     
    public boolean isVisited() {
        return visited;
    }
     
    public void visit() {
        visited = true;
    }
     
    public void unvisit() {
        visited = false;
    }
     
    public int compareTo(Node<RuleInstance> ob) {
        String tempA = this.toString();
        String tempB = ob.toString();
         
        return tempA.compareTo(tempB);
    }
     
   
    
    
    public RuleInstance getData()
    {
    	
    	 return this.data;
    	
    	
    }
    
  
    public String toString() {
    	
    	
    	com.acp.instance.RuleInstance rule = (com.acp.instance.RuleInstance) this.data;
    	
        return rule.getRuleName();
    }
	
}
