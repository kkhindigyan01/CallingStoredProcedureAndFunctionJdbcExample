package com.kkhindigyan.client;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

import com.kkhindigyan.util.DBUtil;

public class CallingStoredProcedureExample {

	public static void main(String[] args) {
		
		String CallStoreProc = "CALL getEmployeeNameAndSalaryById(?,?,?)";
		try(Connection conn = DBUtil.getMySQLConnection();
				CallableStatement callableStatement = conn.prepareCall(CallStoreProc);
				Scanner scanner = new Scanner(System.in) ) {
			
			System.out.println("Enter Employee Id:");
			
			int empId = scanner.nextInt();
			
			callableStatement.setInt(1, empId);
			
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			callableStatement.registerOutParameter(3, Types.DOUBLE);
			
			//callableStatement.execute();
			
			int result = callableStatement.executeUpdate();
			
			if(result >0) {
				System.out.println("Employee Id ="+empId);
				System.out.println("Employee Name ="+callableStatement.getString("empName"));
				System.out.println("Employee Salary  ="+callableStatement.getDouble("empSal"));
			}else {
				System.out.println("Employee with Id ="+empId+" not found in database");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
