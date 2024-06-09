package Test;

import java.util.ArrayList;
import java.util.Scanner;

import Function.Manager_Fun;
import Function.User_Fun;
import dao.documentDAO;
import dao.userDAO;
import modul.Documents;
import modul.Users;
import utils.Validation;

public class Test {
	static Scanner scanner = new Scanner(System.in);
	static Manager_Fun manager = new Manager_Fun();
	static Validation validation = new Validation();
	static User_Fun user = new User_Fun();
	static Users users = new Users();
	static ArrayList<Users> user_List  = userDAO.getInstance().selectAll();
	public static Documents documents =  new Documents();

//MAIN
	public static void main(String[] args) {
		menu();
	}
	
//MENU	
	private static void menu() {
		while(true) {
			System.out.println("------------MENU------------");
			System.out.println("1. Manager");
			System.out.println("2. User");
			String line = scanner.nextLine();
			switch (line) {
			case "1":
				AccessManagement();
				break;
			case "2":
				user.Menu();
				break;
			case "3":
				addUser();
				addDocument();
				break;
			case "0" : return;
			default:
				break;
			}
		}
	}
	
//ACCESS MANAGEMENT
	private static void AccessManagement() {
		System.out.println("Enter Account, please!");
		String managerName = String.valueOf(validation.checkMangagerName());
		String managerPass = String.valueOf(validation.checkMangagerPassWord());
		if(managerName == "true" && managerPass == "true") {
			manager.Menu();
		} else {
			System.out.println("Invalid managerName or managerPass.");
		}
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	static void addDocument() {
		int n = 1 ;
		for (int i = 1; i <= 30; i++) {
			if(i%Math.pow(10, n)!=0) {
				Documents document = new Documents(documents.getDocumentID()+i, "SPIRITUAL ",
						"Name SPIRITUAL "+i,"Author "+i, "SPIRITUAL is "+i, 2000+i,0, 0, 0 ,0);
				documentDAO.getInstance().insert(document);
			}else {
				n = n+1;
				String id = documents.getDocumentID().substring(0,documents.getDocumentID().length()-1);
				documents.setDocumentID(id);
				Documents document = new Documents(documents.getDocumentID()+i, "SPIRITUAL ",
						"Name SPIRITUAL "+i,"Author "+i, "SPIRITUAL is "+i, 2000+i,0, 0, 0,0);
				documentDAO.getInstance().insert(document);
			}
		}
		for (int i = 31; i <= 50; i++) {
			if(i%Math.pow(10, n)!=0) {
				Documents document = new Documents(documents.getDocumentID()+i, "HISTORY ",
						"Name HISTORY "+i,"Author "+i, "HISTORY is "+i, 2000+i,0, 0, 0,0);
				documentDAO.getInstance().insert(document);
			}else {
				n = n+1;
				String id = documents.getDocumentID().substring(0,documents.getDocumentID().length()-1);
				documents.setDocumentID(id);
				Documents document = new Documents(documents.getDocumentID()+i, "HISTORY ",
						"Name HISTORY "+i,"Author "+i, "HISTORY is "+i, 2000+i,0, 0, 0,0);
				documentDAO.getInstance().insert(document);
			}
		}
		for (int i = 51; i <= 70; i++) {
			if(i%Math.pow(10, n)!=0) {
				Documents document = new Documents(documents.getDocumentID()+i, "PHILOSOPHY ",
						"Name PHILOSOPHY "+i,"Author "+i, "PHILOSOPHY is "+i, 2000+i,0, 0, 0,0);
				documentDAO.getInstance().insert(document);
			}else {
				n = n+1;
				String id = documents.getDocumentID().substring(0,documents.getDocumentID().length()-1);
				documents.setDocumentID(id);
				Documents document = new Documents(documents.getDocumentID()+i, "PHILOSOPHY ",
						"Name PHILOSOPHY "+i,"Author "+i, "PHILOSOPHY is "+i, 2000+i,0, 0, 0,0);
				documentDAO.getInstance().insert(document);
			}
		}
		for (int i = 71; i <= 101; i++) {
			if(i%Math.pow(10, n)!=0) {
				Documents document = new Documents(documents.getDocumentID()+i, "INFORMATION TECHNOLOGY ",
						"Name INFORMATION TECHNOLOGY "+i,"Author "+i, "INFORMATION TECHNOLOGY is "+i, 2000+i,0, 0, 0,0);
				documentDAO.getInstance().insert(document);
			}else {
				n = n+1;
				String id = documents.getDocumentID().substring(0,documents.getDocumentID().length()-1);
				documents.setDocumentID(id);
				Documents document = new Documents(documents.getDocumentID()+i, "INFORMATION TECHNOLOGY ",
						"Name INFORMATION TECHNOLOGY "+i,"Author "+i, "INFORMATION TECHNOLOGY is "+i, 2000+i,0, 0, 0,0);
				documentDAO.getInstance().insert(document);
			}
		}
	}
	static void addUser() {
		int n = 1;
		int j = user_List.size()+1;
		int N = n(j,n);
		String iD = users.getAccountID().substring(0,users.getAccountID().length()-N);
		users.setAccountID(iD);
		for (int i = 1; i <= 9; i++) {
				Users user = new Users(users.getAccountID()+i,"chitrung"+i,"Afidnsd"+i);
				userDAO.getInstance().insert(user);
			}
		}
	static int n(int i,int n) {
			if(i >=10) {
				 n++;
				return n(i/10,n);
				
			}else return n;
		}
}


