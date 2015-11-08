package com.acp.graph;

import com.acp.instance.RuleInstance;

public class Edge {

	 	public Node<RuleInstance> a, b;
	    public double weight;
	     
	    public Edge(Node<RuleInstance> a, Node<RuleInstance> b) {
	        this(a, b, Double.POSITIVE_INFINITY);
	    }
	     
	    public Edge(Node<RuleInstance> a, Node<RuleInstance> b, double weight) {
	        this.a = a;
	        this.b = b;
	        this.weight = weight;
	    }
	     
	    public double getWeight() {
	        return weight;
	    }
	     
	    public String toString() {
	        return a.getData().getRuleName() + " ==> " + b.getData().getRuleName();
	    }
	
}
