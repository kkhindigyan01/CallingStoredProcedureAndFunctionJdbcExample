package com.kkhindigyan.client;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

import com.kkhindigyan.util.DBUtil;

public class CallingStoredFunctionExample {

	public static void main(String[] args) {
		
		String CallStoreProc = "{? = CALL sum_of_two_numbers(?,?)}";
		
		try(Connection conn = DBUtil.getMySQLConnection();
				CallableStatement callableStatement = conn.prepareCall(CallStoreProc);
				Scanner scanner = new Scanner(System.in) ) {
			
			callableStatement.registerOutParameter(1, Types.INTEGER);
			
			System.out.println("Enter First Number:");
			int firstNumber = scanner.nextInt();
			
			System.out.println("Enter Second Number:");
			
			int secondNumber = scanner.nextInt();
			
			callableStatement.setInt(2, firstNumber);
			callableStatement.setInt(3, secondNumber);
			
			callableStatement.execute();
			System.out.println("Sum of two numbers is = "+callableStatement.getInt(1));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
