package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	int i=0;
	int x=0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtTime;

    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	 long startTime = System.nanoTime();

    	String parola = txtParola.getText().trim();
    	if (parola.length()==0) {
    		if (i==0) {
    		txtResult.appendText("devi inserire una parola");
    		txtParola.clear();
    		i++;
    		x++;
    		long elapsedNanos = System.nanoTime() - startTime;
        	txtTime.setText("inserisci impiega "+elapsedNanos+" nano secondi\n");
    		return;
    		}
    		txtResult.appendText("\ndevi inserire una parola");
    		txtParola.clear();
    		i++;
    		x++;
    		long elapsedNanos = System.nanoTime() - startTime;
        	txtTime.setText("inserisci impiega "+elapsedNanos+" nano secondi\n");
    		return;
    	} 
    	for (int k=0; k<parola.length(); k++) {
    			if (Character.isLetter(parola.charAt(k))==false) {
    				if (x==0) {
    				txtResult.appendText("la parola deve contenere solo lettere");
    				txtParola.clear();
    				x++;
    				i++;
    				long elapsedNanos = System.nanoTime() - startTime;
    		    	txtTime.setText("inserisci impiega "+elapsedNanos+" nano secondi\n");
    				return;
    		}
    				txtResult.appendText("\nla parola deve contenere solo lettere");
    				txtParola.clear();
    				i++;
    	    		x++;
    	    		long elapsedNanos = System.nanoTime() - startTime;
    	        	txtTime.setText("inserisci impiega "+elapsedNanos+" nano secondi\n");
    				return;
    	}}
    	
    	elenco.addParola(parola);
    	String ss="";
    	
    	for (String s : elenco.getElenco()) {
    		ss+=s.trim();
    		i++;
    	if (i!=elenco.getElenco().toString().length()-1)
    			ss+="\n"; 
    	}
    	txtTime.clear();
    	txtResult.setText(ss.trim());
    	txtParola.clear();
    	
    	long elapsedNanos = System.nanoTime() - startTime;
    	txtTime.setText("inserisci impiega "+elapsedNanos+" nano secondi\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	long startTime = System.nanoTime();
    	
    	elenco.reset();
    	txtResult.clear();
    	txtTime.clear();
    	x=0;
    	i=0;
    	
    	long elapsedNanos = System.nanoTime() - startTime;
    	txtTime.setText("reset impiega "+elapsedNanos+" nano secondi\n");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long startTime = System.nanoTime();
    	
    	String cancella = txtResult.getSelectedText();
    	elenco.cancella(cancella);
    	
    
    String ss="";
	
	for (String s : elenco.getElenco()) {
		ss+=s+"\n";
		i++;
		if (i==elenco.getElenco().toString().length()-1)
			ss+=s;
	}
	txtTime.clear();
	txtResult.setText(ss.trim());
	
	long elapsedNanos = System.nanoTime() - startTime;
	txtTime.setText("cancella impiega "+elapsedNanos+" nano secondi\n");
}
	

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
