package Function;


import java.util.ArrayList;
import java.util.Scanner;

import dao.documentDAO;
import dao.userDAO;
import modul.Documents;
import modul.Users;
import utils.Validation;

public class Function {
	static ArrayList<Users> user_List  = userDAO.getInstance().selectAll();
	static ArrayList<Documents> doc_List = documentDAO.getInstance().selectAll();
	static Validation validation = new Validation();
	static Users users = new Users();
	static Scanner scanner = new Scanner(System.in);
	
//CREATE ACCOUNT	
	protected static void createAccount() {
		String userID = userID();
		System.out.println("Enter userName of user : "); 
		String userName = scanner.nextLine();
		System.out.println("Enter passWord of user : "); 
		String passWord = String.valueOf(validation.checkPass());
		Users user = new Users(userID,userName, passWord);
		userDAO.getInstance().insert(user);
	}
	
//AUTO USER'S ID 
	private static String userID() {
		int i = user_List.size()+1;
		int n = 1 ;
		int N = n(i,n);
				String iD = users.getAccountID().substring(0,users.getAccountID().length()-N);
				users.setAccountID(iD);
				String id = users.getAccountID()+i;
				return id ; 
	}
	private static int n(int i,int n) {
		
		if(i >=10) {
			 n++;
			return n(i/10,n);
			
		}else return n;
	}
	
//SEARCH DOCUMENT
	protected static void menuSearch() {
		System.out.println("-------MENU.SEARCH------");
		System.out.println("a. Search by ID");
		System.out.println("b. Search by name");
		System.out.println("c. Search by name's Author");
		System.out.println("d. Search by title");
		System.out.println("------------------------");
		System.out.println("Enter your choise ");
		String line = scanner.nextLine();
		search(line);
	}
	
	private static void search(String line) {
		switch (line) {
		case "a":
			System.out.println("Enter ID : ");
			String id = scanner.nextLine();
			searchID(id);
			break;
		case "b":
			System.out.println("Enter book's name : ");
			String nameb = scanner.nextLine();
			searchName(nameb);
			break;
		case "c":
			System.out.println("Enter author's name : ");
			String nameA = scanner.nextLine();
			searchAuthor(nameA);
			break;
		case "d":
			System.out.println("Enter title : ");
			String title = scanner.nextLine();
			searchTitle(title);
			break;
			case "0" : return;
		default:
			
			break;
		}
	}
	
//SEARCH BY ID 
	private static void searchID(String id) {
		for (Documents documents : doc_List) {
			if(documents.getDocumentID().equals(id)) {
				System.out.println(documents.toString());
			}
		}
	}
	
   //SEARCH BY NAME DOCUMENT
	private static void searchName(String name) {
		for (Documents documents : doc_List) {
			if(documents.getDocumentName().equals(name)) {
				System.out.println(documents.toString());
			}
		}
	}
	
	//SEARCH BY AUTHOR
	private static void searchAuthor(String name) {
		for (Documents documents : doc_List) {
			if(documents.getAuthorName().equals(name)) {
				System.out.println(documents.toString());
			}
		}
	}
	
	//SEARCH BY TITLE
	private static void searchTitle(String name) {
		for (Documents documents : doc_List) {
			if(documents.getTitle().contains(name)) {
				System.out.println(documents.toString());
			}
		}
	}

//SHOW DOCUMENTS	
	protected static void showDocuments() {
		ArrayList<Documents> doc_List = documentDAO.getInstance().selectAll();
		for (int i = 0; i < doc_List.size(); i++) {
			int j = i + 1;
			System.out.println("user " + j);
			System.out.println(doc_List.get(i).toString()+"\n");
		}
	}

//UPDATE STATUS
	protected static void updateStatus(String id) {
		for (Documents documents : doc_List) {
			if(documents.getDocumentID().equals(id)) {
				status(documents);
				documentDAO.getInstance().updateStatus(documents);
			}
		}
		doc_List = documentDAO.getInstance().selectAll();
	}
	
	private static void status(Documents doc) {
		if(doc.getStatus() == 0 ) doc.setStatus(1);
		else doc.setStatus(0);
	}
//cập nhập số lượng yêu thích
}
