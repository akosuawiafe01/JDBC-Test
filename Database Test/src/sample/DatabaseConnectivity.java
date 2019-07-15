package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.System.*;



public class DatabaseConnectivity {

    private static Connection con ;
    private static Statement st ;

    public static  Connection getCon(){

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtesting", "root","");

            st = con.createStatement();

            if (con!=null){
                out.println("Connection established");
            }



        }catch(Exception dbe){
            out.println("Kindly check the error below: \n" + dbe);
        }

        return con;
    }


    public static void getDatabaseInfo()throws Exception{

        String sql ="Select * from client";
        ResultSet rs = st.executeQuery(sql);



        while (rs.next()){
            out.println("ID:"+ rs.getString("CLIENT ID"));
        }


    }

    public  static void updateDb(String sql) throws Exception{

        try {

            st.getConnection().createStatement().executeUpdate(sql);

        }catch (Exception udbe){
            out.println("Error: "+ udbe);
        }finally {
            st.close();
            con.close();
        }


    }


}
