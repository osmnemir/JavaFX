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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.sql.*;

public class tabloDBController {
	
	public tabloDBController() {
		baglanti=databaseUtil.Baglan();
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_reflesh;

    @FXML
    private TableColumn<kayýtlar_login, Integer> col_id;

    @FXML
    private TableColumn<kayýtlar_login, String> col_sifre;

    @FXML
    private TableColumn<kayýtlar_login, String> col_tkmadý;

    @FXML
    private TableColumn<kayýtlar_login, Integer> col_yetki;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_yetki;

    @FXML
    private TableView<kayýtlar_login> tablewiew_kayýtlar;

    @FXML
    private TextField text_kul;

    @FXML
    private TextField text_sifre;

    @FXML
    void btn_reflesh_click(ActionEvent event) {
    	DegerleriGetir(tablewiew_kayýtlar);

    }
    
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public void DegerleriGetir(TableView tablo) {
    	sql="select * from islemler";
    	ObservableList<kayýtlar_login> kayýtlarliste=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen = sorguIfadesi.executeQuery();
    		while(getirilen.next()) {
    			kayýtlarliste.add(new kayýtlar_login(getirilen.getInt("iID"), getirilen.getString("kullanýcý_adý"), getirilen.getString("sifre"), getirilen.getInt("YETKÝ")));
    			
    		}
    		
    		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		col_tkmadý.setCellValueFactory(new PropertyValueFactory<>("kullanýcý_adý"));
    		col_sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    		col_yetki.setCellValueFactory(new PropertyValueFactory<>("yetki"));
    		
    		tablewiew_kayýtlar.setItems(kayýtlarliste);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    	
    	
    	
    }

    @FXML
    void tablewiew_mouse_click(MouseEvent event) {
    	kayýtlar_login kayit= new kayýtlar_login();
    	kayit=(kayýtlar_login) tablewiew_kayýtlar.getItems().get(tablewiew_kayýtlar.getSelectionModel().getSelectedIndex());
    	
    	text_kul.setText(kayit.getkullanýcý_adý());
    	text_sifre.setText(kayit.getSifre());
    	lbl_id.setText(String.valueOf(kayit.getId()));
    	if(kayit.getYetki()==0) {
    		lbl_yetki.setText("yönetici");
    		
    	}
    	else if (kayit.getYetki()==1) {
    		lbl_yetki.setText("normal kullanýcý");
			
		}

    }

    @FXML
    void initialize() {
    	DegerleriGetir(tablewiew_kayýtlar);
        
    }

}
