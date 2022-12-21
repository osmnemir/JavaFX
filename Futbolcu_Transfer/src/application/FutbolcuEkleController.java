package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
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
import java.sql.*;


public class FutbolcuEkleController {
	
	public FutbolcuEkleController() {
		// TODO Auto-generated constructor stub
		baglanti=databaseUtil.Baglan();

	
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_sil;

    @FXML
    private ComboBox<String> cmb_mvki;

    @FXML
    private ComboBox<Integer> cmb_yasý;

    @FXML
    private TextField ekle_adý;

    @FXML
    private TextField ekle_fiyat;

    @FXML
    private TextField ekle_id;

    @FXML
    private TextField ekle_takýmý;

    @FXML
    private Label lbl_sonuc;
    
    
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    

    @FXML
    void btn_ekle_click(ActionEvent event) {
    	sql="insert into ftblara ( aÝD , futbolcuadý,  takýmý , mevki , yaþý, fiyat) values (?,?,?,?,?,?) ";
    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, ekle_id.getText().trim());
    		sorguIfadesi.setString(2, ekle_adý.getText().trim());
    		sorguIfadesi.setString(3, ekle_takýmý.getText().trim());
    		sorguIfadesi.setString(4, cmb_mvki.getValue().trim());
    		sorguIfadesi.setLong(5, cmb_yasý.getValue());
    		sorguIfadesi.setString(6, ekle_fiyat.getText().trim());
    		

    	
    		sorguIfadesi.executeUpdate();
    		lbl_sonuc.setText("kayýt eklenmiþtir");
			
		} catch (Exception e) {
			// TODO: handle exception
			lbl_sonuc.setText(e.getMessage().toString());
		}


    }

    @FXML
    void btn_guncelle_click(ActionEvent event) {

    }

    @FXML
    void btn_sil_click(ActionEvent event) {
    	sql="delete from ftblara where aÝD=? and futbolcuadý=? and takýmý=? and mevki=? and yaþý=? and fiyat=? ";
    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, ekle_id.getText().trim());
    		sorguIfadesi.setString(2, ekle_adý.getText().trim());
    		sorguIfadesi.setString(3, ekle_takýmý.getText().trim());
    		sorguIfadesi.setString(4, cmb_mvki.getValue().trim());
    		sorguIfadesi.setString(5, cmb_yasý.getPromptText().trim());
    		sorguIfadesi.setString(6, ekle_fiyat.getText().trim());
    		sorguIfadesi.executeUpdate();
    		lbl_sonuc.setText("kayýt silinmiþtir");
			
		} catch (Exception e) {
			// TODO: handle exception
			lbl_sonuc.setText(e.getMessage().toString());
		}

    }

    @FXML
    void initialize() {
    	
    	
    	ObservableList<Integer> list= FXCollections.observableArrayList(18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33);
    	
    	cmb_yasý.setItems(list);
    	
    	ObservableList<String> list2= FXCollections.observableArrayList("Kaleci","Sað Bek","Sol Bek","Stoper","Ön Libero","Merkez Orta Saha","Ofansif Orta Saha","Sað Kanat","Sol Kanat","Santrafor");
    	cmb_mvki.setItems(list2);
      

    }

}
