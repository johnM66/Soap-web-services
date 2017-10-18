package com.employee.endsvrconfig;

import com.employee.db.DBConfig;

public class EndpointSvrConfig {
	private String listenHostName = "localhost";
	private String listenPort = "9999";
	private String listenInterface = "HelloWorld";
	private String listenProtocol = "http";
	private DBConfig dbcfg = new DBConfig();

	public String getListenHostName() {
		return listenHostName;
	}

	public void setListenHostName(String listenHostName) {
		this.listenHostName = listenHostName;
	}

	public String getListenPort() {
		return listenPort;
	}

	public void setListenPort(String listenPort) {
		this.listenPort = listenPort;
	}

	public String getListenInterface() {
		return listenInterface;
	}

	public void setListenInterface(String listenInterface) {
		this.listenInterface = listenInterface;
	}

	public String getListenProtocol() {
		return listenProtocol;
	}

	public void setListenProtocol(String listenProtocol) {
		this.listenProtocol = listenProtocol;
	}

	public DBConfig getDbcfg() {
		return dbcfg;
	}

	public void setDbcfg(DBConfig dbcfg) {
		this.dbcfg = dbcfg;
	}

}
