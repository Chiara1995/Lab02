package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private Word dizionario=new Word();
	private boolean WordOk=false;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	for(int i=0; i<txtWord.getText().length(); i++){
    		if((txtWord.getText().toLowerCase().charAt(i)>='a' /*oppure txtWorld.matches("[a-zA-Z]*")*/&& txtWord.getText().toLowerCase().charAt(i)<='z') || txtWord.getText().toLowerCase().charAt(i)==' ' || txtWord.getText().toLowerCase().charAt(i)=='?')
    			WordOk=true;
    		else{	
    			txtResult.setText("Insert a word");
    			return;
    		}	
    	}
	    if(WordOk){
	    	if(txtWord.getText().contains(" ")){
	    		//Due word
	    		String array[]=txtWord.getText().split(" ");
	    		/*
	    		 * oppure
	    		 * StringTokenizer st=new StringTokenizer(riga, " ");
	    		 * String alienWord=st.nextToken();
	    		 * if(st.hasMoreTokens()){
	    		 * 		String translation=st.netxToken();
	    		 * 		...
	    		 * }
	    		 * 
	    		 */
	    		if(array.length>2){
	    			txtResult.setText("Insert only one or two words");
	    			return;
	    		}
	    		String AlienWord=array[0].toLowerCase();
	    		String TranslateWord=array[1].toLowerCase();
	    		dizionario.addWord(AlienWord, TranslateWord);
	    		txtResult.setText(TranslateWord);	
	    		txtWord.clear();
	    	}
	    	else{
	    		//Una word
	    		txtResult.setText(dizionario.TranslationWord(txtWord.getText().toLowerCase()));
	    		txtWord.clear();
	    	}
	    }

    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtWord.clear();
    }
    
}
