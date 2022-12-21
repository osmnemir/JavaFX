package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.databasemysql.Util.databaseUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class futbolcualController {
	public futbolcualController() {
		// TODO Auto-generated constructor stub
		baglanti=databaseUtil.Baglan();

	
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_sat�nal;

    @FXML
    private ComboBox<String> cmb_mvki;

    @FXML
    private ComboBox<Integer> cmb_yas�;

    @FXML
    private TextField ekle_ad�;

    @FXML
    private TextField ekle_alacak;

    @FXML
    private TextField ekle_fiyat;

    @FXML
    private TextField ekle_id;

    @FXML
    private TextField ekle_tak�m�;

    @FXML
    private Label lbl_sonuc;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btn_sat�nal_click(ActionEvent event) {
    	sql="update ftblara set tak�m�=? where futbolcuad�=? ";

    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		
    		sorguIfadesi.setString(2, ekle_ad�.getText().trim());
    		sorguIfadesi.setString(1, ekle_tak�m�.getText().trim());
    		sorguIfadesi.executeUpdate();
    		
    		lbl_sonuc.setText("Transfer Ger�ekle�mi�tir.");
			
		} catch (Exception e) {
			// TODO: handle exception
			lbl_sonuc.setText(e.getMessage().toString());
		}
    	

    }

    @FXML
    void initialize() {

       

    }

}
