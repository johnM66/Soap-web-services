package com.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.employee.db.DBConfig;
import com.employee.dbconnection.DbConnection;
import com.employee.model.EmployeeModel;
import com.mysql.jdbc.PreparedStatement;

public class EmployeeDao {
	private static final String GET_TOTAL_EMP_NO = "select max(emp_no) from employees";
	private static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEES(EMP_NO,FIRST_NAME,LAST_NAME,DOB,GENDER,HIRE_DATE) VALUES(?,?,?,?,?,?)";
	private static final String UPDATE_EMPLOYEE = "UPDATE EMPLOYEES SET FIRST_NAME=?,LAST_NAME=?,DOB=?,GENDER=?,HIRE_DATE=? WHERE EMP_NO=?";
	private static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEES WHERE EMP_NO=?";
	private static final String GET_EMPLOYEE = "SELECT *FROM EMPLOYEES WHERE EMP_NO=?";
	private static final Logger LOG = Logger.getLogger(EmployeeDao.class.getName());
	private DBConfig cfg = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public EmployeeDao(DBConfig cfg) {
		super();
		this.cfg = cfg;
		LOG.info("constructing employeedao");
	}

	protected EmployeeModel getEmployee(ResultSet rs) throws SQLException {
		LOG.info("get all employee called...");
		EmployeeModel emp = new EmployeeModel();
		emp.setEmpID(rs.getInt("emp_no"));
		emp.setFistname(rs.getString("first_name"));
		emp.setLastname(rs.getString("last_name"));
		emp.setDob(rs.getString("dob"));
		emp.setGender(rs.getString("gender"));
		emp.setHireDate(rs.getString("hire_date"));

		return emp;
	}

	public int createEmployee(EmployeeModel emp) throws ClassNotFoundException, SQLException {
		LOG.info("create employee called...");
		DbConnection dbconn = DbConnection.getInstance(cfg.getDrivername(), cfg.getSubport(), cfg.getHost(),
				cfg.getPort(), cfg.getDb(), cfg.getUid(), cfg.getPwd());

		try {
			stmt = (PreparedStatement) dbconn.getConn().prepareStatement(GET_TOTAL_EMP_NO);
			stmt.execute();
			rs = stmt.getResultSet();
			rs.next();
			int nextEmpNo = rs.getInt(1);
			stmt.close();
			rs.close();

			stmt = (PreparedStatement) dbconn.getConn().prepareStatement(INSERT_EMPLOYEE);
			stmt.setInt(1, emp.getEmpID());
			stmt.setString(2, emp.getFistname());
			stmt.setString(3, emp.getLastname());
			stmt.setString(4, emp.getDob());
			stmt.setString(5, emp.getGender());
			stmt.setString(6, emp.getHireDate());
			stmt.executeUpdate();
			return nextEmpNo;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			dbconn.close();
		}

	}

	public boolean updateEmployee(EmployeeModel emp) throws ClassNotFoundException, SQLException {
		LOG.info("update employee called...");
		DbConnection dbconn = DbConnection.getInstance(cfg.getDrivername(), cfg.getSubport(), cfg.getHost(),
				cfg.getPort(), cfg.getDb(), cfg.getUid(), cfg.getPwd());

		try {

			stmt = (PreparedStatement) dbconn.getConn().prepareStatement(UPDATE_EMPLOYEE);
			
			
			stmt.setString(1, emp.getFistname());
			
			stmt.setString(2, emp.getLastname());
			stmt.setString(3, emp.getDob());
			stmt.setString(4, emp.getGender());
			stmt.setString(5, emp.getHireDate());
			stmt.setInt(6, emp.getEmpID());
			stmt.execute();
			
			return true;

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			dbconn.close();
		}

	}

	public boolean deleteEmployee(int emp) throws ClassNotFoundException, SQLException {
		LOG.info("Delete employee called...");
		DbConnection dbconn = DbConnection.getInstance(cfg.getDrivername(), cfg.getSubport(), cfg.getHost(),
				cfg.getPort(), cfg.getDb(), cfg.getUid(), cfg.getPwd());

		try {
			stmt = (PreparedStatement) dbconn.getConn().prepareStatement(DELETE_EMPLOYEE);
			stmt.setInt(1, emp);
			stmt.execute();
			return true;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			dbconn.close();
		}

	}

	public EmployeeModel getEmp(int emp) throws ClassNotFoundException, SQLException {
		LOG.info("GET employee called...");
		DbConnection dbconn = DbConnection.getInstance(cfg.getDrivername(), cfg.getSubport(), cfg.getHost(),
				cfg.getPort(), cfg.getDb(), cfg.getUid(), cfg.getPwd());
		try {
			stmt = (PreparedStatement) dbconn.getConn().prepareStatement(GET_EMPLOYEE);
			stmt.setInt(1,emp);
		    rs=stmt.executeQuery();
		    if(rs.next()) {
		    	EmployeeModel e=new EmployeeModel();
		    	
		    	e.setEmpID(rs.getInt("emp_no"));
		    	e.setFistname(rs.getString("first_name"));
		    	e.setLastname(rs.getString("last_name"));
		    	e.setDob(rs.getString("dob"));
		    	e.setGender(rs.getString("gender"));
		    	e.setHireDate(rs.getString("hire_date"));
		    	return e;
		    }
			
		}  finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			dbconn.close();
		}
		return null;
	
	}
}

