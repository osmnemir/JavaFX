package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import java.sql.*;
import com.databasemysql.Util.databaseUtil;
public class futbolcuaraController {
	
	 public futbolcuaraController() {
		// TODO Auto-generated constructor stub
		baglanti=databaseUtil.Baglan();

	
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ara;

    @FXML
    private TableColumn<futbolcu_ara, Integer> column_fiyat;

    @FXML
    private TableColumn<futbolcu_ara, String> column_futbolcuadý;

    @FXML
    private TableColumn<futbolcu_ara, Integer> column_id;

    @FXML
    private TableColumn<futbolcu_ara, String> column_mevki;

    @FXML
    private TableColumn<futbolcu_ara, String> column_takým;

    @FXML
    private TableColumn<futbolcu_ara, String> column_takýmý;

    @FXML
    private TableColumn<futbolcu_ara, Integer> column_yaþý;

    @FXML
    private ComboBox<String> combo_takým;

    @FXML
    private TableView<futbolcu_ara> tableView_Aramalar;

    @FXML
    private TextField txt_arama;
    @FXML
    private TextField txt_baþ;

    @FXML
    private TextField txt_son;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btn_ara_click(ActionEvent event) {
		sql="select * from ftblara where fiyat> '"+txt_baþ.getViewOrder()+"' and fiyat<'"+txt_son.getViewOrder()+"' " ;
		DegerleriGetir(tableView_Aramalar, sql);

    


    }

    @FXML
    void combo_takým_onaciton(ActionEvent event) {

    }

    @FXML
    void txt_arama_Keypresed(KeyEvent event) {
    	if(txt_arama.getText().equals("")) {
    		sql="select * from ftblara";
    		
    	}
    	else {
    		sql="select * from ftblara  where  mevki like '%"+txt_arama.getText()+"%'  or takýmý like '%"+txt_arama.getText()+"%'  or futbolcuadý like '%"+txt_arama.getText()+"%' ";
    		
    	}
    	
    	
    	DegerleriGetir(tableView_Aramalar, sql);

    }
    @FXML
    void txt_arama_action(ActionEvent event) {
    	

    }
    
    public void DegerleriGetir(TableView tablo, String sql) {
    	//sql="select * from ftblara";
    	ObservableList<futbolcu_ara> kayýtlarliste=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen = sorguIfadesi.executeQuery();
    		while(getirilen.next()) {
    			kayýtlarliste.add(new futbolcu_ara(getirilen.getInt("aÝD"), getirilen.getString("takým"), getirilen.getString("futbolcuadý"), getirilen.getString("takýmý"),getirilen.getString("mevki"),getirilen.getInt("yaþý"),getirilen.getInt("fiyat")));
    			
    		}
    		
    		column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		column_takým.setCellValueFactory(new PropertyValueFactory<>("takým"));
    		column_futbolcuadý.setCellValueFactory(new PropertyValueFactory<>("futbolcu_adý"));
    		column_takýmý.setCellValueFactory(new PropertyValueFactory<>("takýmý"));
    		column_mevki.setCellValueFactory(new PropertyValueFactory<>("mevki"));
    		column_yaþý.setCellValueFactory(new PropertyValueFactory<>("yaþý"));
    		column_fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
    		
    		
    		tableView_Aramalar.setItems(kayýtlarliste);

    		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    	
    }
    	
    	

    	 @FXML
	    void initialize() {
    		 sql="select * from ftblara";
 	    	
 	    	DegerleriGetir(tableView_Aramalar, sql);
 	    
	    	
	    }
   
   
       
    }


