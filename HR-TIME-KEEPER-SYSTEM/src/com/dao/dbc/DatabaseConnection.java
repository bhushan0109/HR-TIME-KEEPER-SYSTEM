package com.dao.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
   // public static final String JdbcDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/daoproject";
    private static final String DBUSER="root";
    private static final String PWD="root";
    private Connection conn=null;

    public DatabaseConnection() {
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL, DBUSER, PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.conn;
    }

    public void closeConnection(){
        if(this.conn!=null){
            try{
                this.conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

}
