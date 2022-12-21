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
    private TableColumn<kay�tlar_login, Integer> col_id;

    @FXML
    private TableColumn<kay�tlar_login, String> col_sifre;

    @FXML
    private TableColumn<kay�tlar_login, String> col_tkmad�;

    @FXML
    private TableColumn<kay�tlar_login, Integer> col_yetki;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_yetki;

    @FXML
    private TableView<kay�tlar_login> tablewiew_kay�tlar;

    @FXML
    private TextField text_kul;

    @FXML
    private TextField text_sifre;

    @FXML
    void btn_reflesh_click(ActionEvent event) {
    	DegerleriGetir(tablewiew_kay�tlar);

    }
    
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public void DegerleriGetir(TableView tablo) {
    	sql="select * from islemler";
    	ObservableList<kay�tlar_login> kay�tlarliste=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen = sorguIfadesi.executeQuery();
    		while(getirilen.next()) {
    			kay�tlarliste.add(new kay�tlar_login(getirilen.getInt("iID"), getirilen.getString("kullan�c�_ad�"), getirilen.getString("sifre"), getirilen.getInt("YETK�")));
    			
    		}
    		
    		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		col_tkmad�.setCellValueFactory(new PropertyValueFactory<>("kullan�c�_ad�"));
    		col_sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    		col_yetki.setCellValueFactory(new PropertyValueFactory<>("yetki"));
    		
    		tablewiew_kay�tlar.setItems(kay�tlarliste);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    	
    	
    	
    }

    @FXML
    void tablewiew_mouse_click(MouseEvent event) {
    	kay�tlar_login kayit= new kay�tlar_login();
    	kayit=(kay�tlar_login) tablewiew_kay�tlar.getItems().get(tablewiew_kay�tlar.getSelectionModel().getSelectedIndex());
    	
    	text_kul.setText(kayit.getkullan�c�_ad�());
    	text_sifre.setText(kayit.getSifre());
    	lbl_id.setText(String.valueOf(kayit.getId()));
    	if(kayit.getYetki()==0) {
    		lbl_yetki.setText("y�netici");
    		
    	}
    	else if (kayit.getYetki()==1) {
    		lbl_yetki.setText("normal kullan�c�");
			
		}

    }

    @FXML
    void initialize() {
    	DegerleriGetir(tablewiew_kay�tlar);
        
    }

}
