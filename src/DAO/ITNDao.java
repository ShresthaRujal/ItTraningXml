package DAO;

import DatabaseHandler.DBHandler;
import Model.ITNModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruzal on 3/29/2017.
 */
public interface ITNDao {
    int insert(ITNModel itnModel);
    ArrayList<ITNModel> display();
    int update(ITNModel model);
    int delete(int id);



}
