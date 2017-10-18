package com.employee.service;

import java.sql.SQLException;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.soap.SOAPException;

import com.employee.dao.EmployeeDao;
import com.employee.db.DBConfig;
import com.employee.model.EmployeeModel;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class EmployeeService {
	private static final Logger LOG = Logger.getLogger(EmployeeService.class.getName());
	private EmployeeDao dao = null;

	public EmployeeService(DBConfig cfg) {
		dao = new EmployeeDao(cfg);
	}
   @WebMethod
	public EmployeeModel getEmployee(@WebParam(name = "empNo") int empNo)
			throws ClassNotFoundException, SQLException, SOAPException {
		LOG.info("Service get employee called...");
		EmployeeModel e = dao.getEmp(empNo);
		if (e == null) {
			throw new SOAPException("No such Employee");
			
		}

		return e;
	}
	
   @WebMethod
	public int createEmployee(@WebParam(name = "employee") EmployeeModel employee) throws Exception {
		LOG.info("Service create employee called...");
		return dao.createEmployee(employee);
	}
   @WebMethod
	public boolean updateEmployee(@WebParam(name="employee") EmployeeModel employee)throws Exception {
		LOG.info("Service update employee called...");
		return dao.updateEmployee(employee);
	}
   @WebMethod
	public boolean deleteEmployee(@WebParam(name = "empNo") int empNo)throws Exception {
		LOG.info("Service Delete employee called...");
		return dao.deleteEmployee(empNo);
	}
}
