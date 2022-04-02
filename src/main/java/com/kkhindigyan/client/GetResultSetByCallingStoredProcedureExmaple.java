package com.kkhindigyan.client;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.kkhindigyan.util.DBUtil;

/**
 * Get ResultSet By Calling StoredProcedure Using CallableStatement
 * @author KK HindiGyan
 *
 */
public class GetResultSetByCallingStoredProcedureExmaple {

	public static void main(String[] args) {
	
		String CallStoreProc = "CALL getAllEmployees";
		
		try(Connection conn = DBUtil.getMySQLConnection();
				CallableStatement callableStatement = conn.prepareCall(CallStoreProc);
				ResultSet rs = callableStatement.executeQuery()) {
			
			while (rs.next()) {
				System.out.println("Employee Id ="+rs.getInt("employee_id"));
				System.out.println("Employee Name ="+rs.getString("employee_name"));
				System.out.println("Employee Salary  ="+rs.getDouble("employee_salary"));
				System.out.println("Employee Dept = "+rs.getString("employee_dept"));
				System.out.println("Employee DOJ = "+rs.getDate("employee_doj"));
				System.out.println("----------------------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}

