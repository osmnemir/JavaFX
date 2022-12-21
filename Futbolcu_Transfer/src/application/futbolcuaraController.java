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
    private TableColumn<futbolcu_ara, String> column_futbolcuad�;

    @FXML
    private TableColumn<futbolcu_ara, Integer> column_id;

    @FXML
    private TableColumn<futbolcu_ara, String> column_mevki;

    @FXML
    private TableColumn<futbolcu_ara, String> column_tak�m;

    @FXML
    private TableColumn<futbolcu_ara, String> column_tak�m�;

    @FXML
    private TableColumn<futbolcu_ara, Integer> column_ya��;

    @FXML
    private ComboBox<String> combo_tak�m;

    @FXML
    private TableView<futbolcu_ara> tableView_Aramalar;

    @FXML
    private TextField txt_arama;
    @FXML
    private TextField txt_ba�;

    @FXML
    private TextField txt_son;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btn_ara_click(ActionEvent event) {
		sql="select * from ftblara where fiyat> '"+txt_ba�.getViewOrder()+"' and fiyat<'"+txt_son.getViewOrder()+"' " ;
		DegerleriGetir(tableView_Aramalar, sql);

    


    }

    @FXML
    void combo_tak�m_onaciton(ActionEvent event) {

    }

    @FXML
    void txt_arama_Keypresed(KeyEvent event) {
    	if(txt_arama.getText().equals("")) {
    		sql="select * from ftblara";
    		
    	}
    	else {
    		sql="select * from ftblara  where  mevki like '%"+txt_arama.getText()+"%'  or tak�m� like '%"+txt_arama.getText()+"%'  or futbolcuad� like '%"+txt_arama.getText()+"%' ";
    		
    	}
    	
    	
    	DegerleriGetir(tableView_Aramalar, sql);

    }
    @FXML
    void txt_arama_action(ActionEvent event) {
    	

    }
    
    public void DegerleriGetir(TableView tablo, String sql) {
    	//sql="select * from ftblara";
    	ObservableList<futbolcu_ara> kay�tlarliste=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen = sorguIfadesi.executeQuery();
    		while(getirilen.next()) {
    			kay�tlarliste.add(new futbolcu_ara(getirilen.getInt("a�D"), getirilen.getString("tak�m"), getirilen.getString("futbolcuad�"), getirilen.getString("tak�m�"),getirilen.getString("mevki"),getirilen.getInt("ya��"),getirilen.getInt("fiyat")));
    			
    		}
    		
    		column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		column_tak�m.setCellValueFactory(new PropertyValueFactory<>("tak�m"));
    		column_futbolcuad�.setCellValueFactory(new PropertyValueFactory<>("futbolcu_ad�"));
    		column_tak�m�.setCellValueFactory(new PropertyValueFactory<>("tak�m�"));
    		column_mevki.setCellValueFactory(new PropertyValueFactory<>("mevki"));
    		column_ya��.setCellValueFactory(new PropertyValueFactory<>("ya��"));
    		column_fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
    		
    		
    		tableView_Aramalar.setItems(kay�tlarliste);

    		
			
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


