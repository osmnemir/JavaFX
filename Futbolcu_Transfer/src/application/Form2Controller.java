package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.databasemysql.Util.databaseUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.*;

public class Form2Controller {
	public Form2Controller() {
		baglanti=databaseUtil.Baglan();
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_login;
    
    @FXML
    private Button grs_ekle;

    @FXML
    private TextField kul_ad;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private TextField sifre;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    

    
    @FXML
    void grs_ekle_click(ActionEvent event) {
    	
    	sql="insert into islemler (kullanıcı_adı,sifre,YETKİ ) values (?,?,?) ";
    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, kul_ad.getText().trim());
    		sorguIfadesi.setString(2, sifre.getText().trim());
    		sorguIfadesi.setString(3, "0");
    		
    		
    	
    		sorguIfadesi.executeUpdate();
    		lbl_sonuc.setText("yeni kullanıcı eklenmiştir");
			
		} catch (Exception e) {
			// TODO: handle exception
			lbl_sonuc.setText(e.getMessage().toString());
		}

    }
    
    
    
    

    @FXML
    void login_click(ActionEvent event) throws IOException {
    	
    	
    	Stage stage = new Stage();
    	BorderPane pane1=(BorderPane) FXMLLoader.load(getClass().getResource("AnaForm.fxml"));
    	
    	Scene scene =new Scene(pane1);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	
    	
    	
    	sql="select * from islemler where kullanıcı_adı=? and sifre=?";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, kul_ad.getText().trim());
    		sorguIfadesi.setString(2, sifre.getText().trim());
    		
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		
    		if(!getirilen.next()) {
    			lbl_sonuc.setText("kullanıcı veya şifre hatalı");
    		}
    		else {
    			getirilen.getString(1);
    			System.out.println("kID:" + getirilen.getString("iID"));
    			System.out.println("kullanıcı:" + getirilen.getString("kullanıcı_adı"));
    			System.out.println("sifre:" + getirilen.getString("sifre"));
    			System.out.println("yetki:" + getirilen.getString("YETKİ"));
    			
    		}
    		
		} catch (Exception e) {	
			lbl_sonuc.setText(e.getMessage().toString());
		}

    }


    

    @FXML
    void initialize() {
        
    }

}
