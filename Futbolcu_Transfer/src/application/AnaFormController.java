package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AnaFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane borderpane;
    

    @FXML
    void anasayfa(MouseEvent event) {
    	borderpane.setCenter(null);

    }

    @FXML
    void close(MouseEvent event) {
    	Stage stage=(Stage) borderpane.getScene().getWindow();
    	stage.close();

    }

    @FXML
    void futbolcual(MouseEvent event) {
    	loadFtbl("futbolcual");

    }
    
    

    

    @FXML
    void futbolcuekle(MouseEvent event) {
    
    	loadFtbl("futbolcuekle");
    	
    }

    @FXML
    void futbolcular(MouseEvent event) {
    	loadFtbl("futbolcular");
    	
    	
    	}
    	
    @FXML
    void takýmgirisbilgileri(MouseEvent event) {
        	
        loadFtbl("takýmgirisbilgileri");

    }
    void loadFtbl(String ftbl) {
    	Parent root = null;
		try {
			root=FXMLLoader.load(getClass().getResource(ftbl+".fxml"));
			
			
		} catch (IOException e) {
			Logger.getLogger(AnaFormController.class.getName()).log(Level.SEVERE, null , e);
			// TODO Auto-generated catch block
			
		}
		borderpane.setCenter(root);
		
	}
    
    
   

    

    @FXML
    void initialize() {
    	


    	
    }

}
