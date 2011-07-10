package org.twenty;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

public class TQ extends Activity implements OnClickListener 
{
	TextView textView;
	EditText editText;
	String input;
	boolean again=true;
	//Node head;
	Node newPokemon;
	Node newQuestion;
	Node root;
	Node head;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textView = (TextView) this.findViewById(R.id.gameText);
		
		//head = new Node("Sn")
		head=new QNode("Is it a fire type?");
				head.setYes(new PNode("Charmander"));
				head.setNo(new PNode("Venasaur"));
				root=head;
				textView.setText(head.getQuestion());
				 View yesButton = findViewById(R.id.yesButton);
			        View noButton =  findViewById(R.id.noButton);
			       
			        
			        //editButton.setOnClickListener(this);
			        yesButton.setOnClickListener(this);
			        noButton.setOnClickListener(this);

				editText= (EditText) findViewById(R.id.editText);
				editText.setOnKeyListener(new OnKeyListener() {
		            public boolean onKey(View v, int keyCode, KeyEvent event) {
		                // If the event is a key-down event on the "enter" button
		                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
		                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
		                	input = editText.getText().toString().toLowerCase();
		                  editText.setText(null); 
		                  textView.setText(getNextQuestion()); 
		                  return true;
		                }
		                return false;
		            }
		        });

		        
		    }

			/**
			 * the prompt to find the next output (not only a question, could be a direction)
			 * 
			 * @return The string for the output
			 */
		    public String getNextQuestion(){
		    	
		    	
		    	
		    	//If the user inputs a question, simplified by a string with a '?' in it, 
		    	// this sets up a new question node with the given string input.
		    	// Then prompts user for the animal.
		    	if (input.contains("?")){
		    		newQuestion = new QNode(input);
		    		return ("Who's that pokemon?");
		    	}
		    	
		    	
		    	else if(input.equals("retry")){
		    		head = root;
		    		return head.getQuestion();
		    	}
		    	else if(input.equals("quit")){
		    		finish();
		    		return null;
		    	}
		    	else{
		    		newPokemon= new PNode(input);
		    		rebranch();
		    		return("Type retry to play again and quit to stop playing");
		    	}
		    }
			public void rebranch(){
				Node parent = head.getParent();

				//Checks to see if rebranching on no subtree or yes subtree.
				//Allows for improvement on game.
				if(parent.getNo().equals(head)){
					parent.setNo(newQuestion);
				}else{
					parent.setYes(newQuestion);
				}

				newQuestion.setNo(head);
				newQuestion.setYes(newPokemon);

			}
			
			
			@Override
			public void onClick(View v) {
				switch(v.getId()){
				case R.id.yesButton:
					if (head.hasYes()) {
						head = head.getYes();
						textView.setText(head.getQuestion()); 
					}
		    		else{
		    			Log.d("Do I get here?","Do I?");
		    			textView.setText("I won! Enter retry to play again and quit to exit");
		    		}
				case R.id.noButton:
						
			    		if(head.hasNo()){
			    			head = head.getNo();
			    			textView.setText(head.getQuestion());
			    		}
			    		else{
			    			if(head instanceof PNode){
			    				PNode animal = (PNode) head;
			    				textView.setText("I give up. What is a question that the answer would be yes for your Pokemon, but no for " + animal.getpokemon() + "?");
			    			}
			    		}
			    
				}
				
			}
	
	
}
