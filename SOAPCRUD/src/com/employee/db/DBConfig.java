package com.employee.db;

public class DBConfig {
	private String subport = "mysql";
	private String host = "localhost";
	private String port = "3306";
	private String db = "empdb";
	private String uid = "root";
	private String pwd = "root";
	private String drivername = "com.mysql.jdbc.Driver";

	public String getSubport() {
		return subport;
	}

	public void setSubport(String subport) {
		this.subport = subport;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

}
