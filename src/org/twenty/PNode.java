package org.twenty;




public class PNode extends Node{

	private String pokemon;

	public PNode(String pokemon){
		this.pokemon = pokemon;
		this.parent = null;
		this.yes = null;
		this.no = null;
	}

	public PNode(String pokemon, Node parent){
		this.pokemon = pokemon;
		this.parent = parent;
		this.yes = null;
		this.no = null;
	}

	@Override
	public String getQuestion() {
		return "Are you thinking of a " + pokemon + "?";
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


	public String getpokemon() {
		return pokemon;
	}

	@Override
	public Node getParent() {
		return this.parent;
	}
}
