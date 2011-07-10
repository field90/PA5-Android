package org.twenty;

public class QNode extends Node{

	private String question;

	
	public QNode(String question){
		this.question = question;
		this.parent = null;
		this.yes = null;
		this.no = null;
	}

	public QNode(String question, Node parent){
		this.question = question;
		this.parent = parent;
		this.yes = null;
		this.no = null;
	}

	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public void setYes(Node yesNode) {
		this.yes = yesNode;
		yesNode.parent = this;
	}

	@Override
	public void setNo(Node newno) {
		this.no = newno;
		newno.parent = this;
	}

	@Override
	public Node getYes() {
		return this.yes;
	}

	@Override
	public Node getNo() {
		return this.no;
	}

	@Override
	public boolean hasYes() {
		if(this.yes == null){
			return false;
		}
		return true;
	}
	@Override
	public boolean hasNo() {
		if(this.no == null){
			return false;
		}
		return true;
	}
	@Override
	public Node getParent() {
		return this.parent;
	}


}
