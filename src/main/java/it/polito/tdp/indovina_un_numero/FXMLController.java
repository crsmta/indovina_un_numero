package it.polito.tdp.indovina_un_numero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLController {
	private int tentativiRimasti;
	private int segreto;
	private final int nMax=100;
	private final int tMax=8;
	private boolean ingame=false;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton radioDiff1;

    @FXML
    private ToggleGroup group1;

    @FXML
    private RadioButton radioDiff2;

    @FXML
    private RadioButton radioDiff3;

    @FXML
    private Button buttonNuovaPartita;

    @FXML
    private TextField txtTentativi;

    @FXML
    private TextField txtNumero;

    @FXML
    private Label txtRisposta;

    @FXML
    private Button buttonOk;

    @FXML
    void handlerButtonNuovaPartita(ActionEvent event) {
    	this.txtTentativi.setText(Integer.toString(tMax));
    	this.segreto=(int)( Math.random()*nMax)+1; 
    	this.tentativiRimasti=tMax;
    	this.ingame=true;
     	txtRisposta.setText(null);
    	txtNumero.clear();
    	
    }

    @FXML
    void handlerButtonOk(ActionEvent event) {
    	if (ingame) {
    		int numT=0;
	    	if (tentativiRimasti<=0) {
	    		txtRisposta.setText("tentativi esauriti\nnuova partita?");
	    		ingame=false;
	    		return;
	    	}
	    	tentativiRimasti--;
	    	try {
	    		numT=Integer.parseInt(txtNumero.getText());
			} catch (NumberFormatException e) {
				txtRisposta.setText("Devi inserire un numero");
				tentativiRimasti++;
				return;
			}
	    	if (numT==segreto) {
	    		ingame=false;
	    		txtRisposta.setText("Corretto!\nnuova partita?");    		
	    	}else if(numT<segreto) {
	    		txtRisposta.setText("Più grande"); 
	    	}else if(numT>segreto) {
	    		txtRisposta.setText("Più piccolo");	
	    	}
	    	txtTentativi.setText(Integer.toString(tentativiRimasti));
    	}else {
    		txtRisposta.setText("avvia Nuova partita");
    	}
    }

    @FXML
    void initialize() {
        assert radioDiff1 != null : "fx:id=\"radioDiff1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert group1 != null : "fx:id=\"group1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert radioDiff2 != null : "fx:id=\"radioDiff2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert radioDiff3 != null : "fx:id=\"radioDiff3\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonNuovaPartita != null : "fx:id=\"buttonNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumero != null : "fx:id=\"txtNumero\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisposta != null : "fx:id=\"txtRisposta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonOk != null : "fx:id=\"buttonOk\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

