package org.twenty;

public abstract class Node {

	protected Node parent;
	protected Node yes;
	protected Node no;


	public abstract String getQuestion();
	public abstract void setYes(Node yesNode);
	public abstract Node getYes();
	public abstract void setNo(Node newno);
	public abstract Node getNo();
	public abstract boolean hasYes();
	public abstract boolean hasNo();
	public abstract Node getParent();
}