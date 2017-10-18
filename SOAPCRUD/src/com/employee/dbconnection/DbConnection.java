package com.employee.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
	private static final Logger LOG = Logger.getLogger(DbConnection.class.getName());
private static final String ERROR_MSG="ERROR";
private Connection conn=null;

public Connection getConn() {
	return conn;
}
private DbConnection(String driverName,String subport,String host,String port,String db,String uid,String pwd) throws ClassNotFoundException {
	LOG.info("Getting DB connection...");
	try {
		Class.forName(driverName);
		String url=String.format("jdbc:%s://%s:%s/%s?user=%s&password=%s",subport,host,port,db,uid,pwd);
		conn=DriverManager.getConnection(url);
	}
	catch(Exception e) {
		LOG.log(Level.SEVERE,ERROR_MSG+e);
	}
}

public static  DbConnection getInstance(String driverName,String subport,String host,String port,String db,String uid,String pwd) throws ClassNotFoundException {
	return new DbConnection(driverName,subport,host,port,db,uid,pwd);
}
public void close()
{
	if(conn!=null) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn=null;
		
	}
}



}
