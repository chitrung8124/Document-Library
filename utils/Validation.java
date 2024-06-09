package utils;

import java.util.Scanner;

public class Validation {
	final String regex_UserPass = "^[A-Z][A-Z|a-z|0-9]{7,11}$";
	final String regex_documentType = "^(SPIRITUAL|HISTORY|PHILOSOPHY|INFORMATION TECHNOLOGY)$";
	final String regex_userID = "^[7][0-9]{6}$"; 
	final String regex_documentID = "^[0-9]{7}$"; 
	final String regex_MangagerName = "admin";
	final String regex_MangagerPassWord = "123456";
	
	Scanner scanner = new Scanner(System.in);
	public String checkPass() {
		String pass = scanner.nextLine();
		 if (pass != null && pass.matches(regex_UserPass)) {
		        return pass;
		    } else {
		        System.out.println("Invalid password. Please re-enter!");
		        System.out.println("Enter pass : ");
		        return checkPass();
		    }
	}
	
	public String checkUserID() {
		String ID = scanner.nextLine();
		 if (ID != null && ID.matches(regex_userID)) {
		        return ID;
		    } else {
		        System.out.println("Invalid userID. Please re-enter!");
		        System.out.println("Enter userID : ");
		        return checkUserID();
		    }
	}
	
	public String checkDocumentID() {
		String ID = scanner.nextLine();
		 if ( ID.matches(regex_documentID)) {
		        return ID;
		    } else {
		        System.out.println("Invalid userID. Please re-enter!");
		        System.out.println("Enter documentID : ");
		        return checkDocumentID();
		    }
	}
	
	public boolean checkMangagerName() {
		String name = scanner.nextLine();
		if (name != null && name.matches(regex_MangagerName)) {
	        return true;
	       } else {
	        return false;
	       }
	}
	
	public boolean checkMangagerPassWord() {
		String pass = scanner.nextLine();
		if (pass != null && pass.matches(regex_MangagerPassWord)) {
	        return true;
	      } else {
	        return false;
	      }
	}
	
}	
