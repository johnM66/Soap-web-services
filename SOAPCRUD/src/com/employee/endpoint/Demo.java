package com.employee.endpoint;

import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

import com.employee.db.DBConfig;
import com.employee.service.EmployeeService;

public class Demo {
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DBASE = "empdb";
	private static final String DB_UID = "root";
	private static final String DB_PWD = "root";
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	private static final Logger LOG = Logger.getLogger(Demo.class.getName());
	
	public  static DBConfig getDBConfig() {
		DBConfig dbcfg = new DBConfig();

		dbcfg.setDrivername(DRIVER_NAME);
		dbcfg.setHost(DB_HOST);
		dbcfg.setPort(DB_PORT);
		dbcfg.setUid(DB_UID);
		dbcfg.setPwd(DB_PWD);
		dbcfg.setDb(DBASE);
		return dbcfg;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConfig db = getDBConfig();
		  Endpoint.publish("http://localhost:9874/ws/hello", new EmployeeService(db));
	}

}
