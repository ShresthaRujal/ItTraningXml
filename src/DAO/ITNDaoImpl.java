package DAO;

import DatabaseHandler.DBHandler;
import Model.ITNModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Ruzal on 3/29/2017.
 */

public class ITNDaoImpl implements ITNDao {

    @Override
    public int insert(ITNModel itnModel) {

        DBHandler dbHandler= new DBHandler();
        Connection con =dbHandler.getConnected();


        try {
            Statement stmt = con.createStatement();
            String sql = "Insert into itndb(username,email,password) values('" + itnModel.getUsername() + "','" + itnModel.getEmail() + "','" + itnModel.getPassword() + "')";
            int x = stmt.executeUpdate(sql);
            con.close();
            return x;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }


    }



    @Override
    public ArrayList<ITNModel> display(){

        DBHandler dbHandler= new DBHandler();
        Connection con = dbHandler.getConnected();

        ArrayList<ITNModel> list= new ArrayList<>();
        Statement stmt= null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql="Select * from itndb";
        try {

            ResultSet rs =stmt.executeQuery(sql);
            while (rs.next()){
                ITNModel model = new ITNModel();
                model.setId(rs.getInt("id"));
                model.setUsername(rs.getString("username"));
                model.setEmail(rs.getString("email"));
                model.setPassword(rs.getString("password"));

                list.add(model);

                System.out.println("resultset good");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public int update(ITNModel model) {

        int status=0;
        DBHandler dbHandler=new DBHandler();
        Connection con=dbHandler.getConnected();

        String sql="update itndb set username='"+model.getUsername()+"',email='"+model.getEmail()+"',password='"+model.getPassword()+"' where id="+model.getId()+"";
        try{
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception e){

        }
        return status;

    }

    @Override
    public int delete(int id) {
        DBHandler dbHandler=new DBHandler();
        Connection con=dbHandler.getConnected();
        int status=0;
        String sql="Delete from itndb where id='"+id+"'";
        try {
            Statement stmt= con.createStatement();
            status=stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return status;
    }
}
