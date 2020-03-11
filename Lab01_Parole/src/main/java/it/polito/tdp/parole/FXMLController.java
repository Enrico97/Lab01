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
    void doInsert(ActionEvent event) {
    	// TODO
    	String parola = txtParola.getText().trim();
    	if (parola.length()==0) {
    		if (i==0) {
    		txtResult.appendText("devi inserire una parola");
    		txtParola.clear();
    		i++;
    		x++;
    		return;}
    		txtResult.appendText("\ndevi inserire una parola");
    		txtParola.clear();
    		i++;
    		x++;
    		return;
    	} 
    	for (int k=0; k<parola.length(); k++) {
    			if (Character.isLetter(parola.charAt(k))==false) {
    				if (x==0) {
    				txtResult.appendText("la parola deve contenere solo lettere");
    				txtParola.clear();
    				x++;
    				i++;
    				return;
    		}
    				txtResult.appendText("\nla parola deve contenere solo lettere");
    				txtParola.clear();
    				i++;
    	    		x++;
    				return;
    	}}
    	
    	elenco.addParola(parola.trim());
    	String ss="";
    	
    	for (String s : elenco.getElenco()) {
    		ss+=s+"\n";
    		i++;
    		if (i==elenco.getElenco().toString().length()-1)
    			ss+=s;
    	}
    	txtResult.setText(ss.trim());
    	txtParola.clear();
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	elenco.reset();
    	txtResult.clear();
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	String cancella = txtResult.getSelectedText();
    	elenco.cancella(cancella);
    	
    
    String ss="";
	
	for (String s : elenco.getElenco()) {
		ss+=s+"\n";
		i++;
		if (i==elenco.getElenco().toString().length()-1)
			ss+=s;
	}
	txtResult.setText(ss.trim());
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
