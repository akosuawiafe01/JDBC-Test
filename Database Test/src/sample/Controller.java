package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;




public class Controller extends Main{

    public Button btnOkay;
    public TextField tfName;
    public  TextField tfClientID;

    private Connection conn ;
    private Statement state;
    private ResultSet rset;
    private PreparedStatement pstate =null;

    public void updateDatabase() throws Exception{



        String uName =tfName.getText();
        String uID = tfClientID.getText();

        String sql = "INSERT INTO client(CLIENTID,FIRSTNAME) VALUES ('"+uID+"','"+uName+"')";

        if(!uName.equals("[A-Za-z]") && (uID.length() != 8) ){

            JOptionPane.showMessageDialog(null, "Error in user name or ID field");

        }else{

            conn = DatabaseConnectivity.getCon();

            DatabaseConnectivity.updateDb(sql);

            btnOkay.getScene().getWindow().hide();

            JOptionPane.showMessageDialog(null,"Record saved");

        }



    }




}
