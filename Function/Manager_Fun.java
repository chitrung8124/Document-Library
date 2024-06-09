package Function;

import java.util.ArrayList;
import java.util.Scanner;

import dao.documentDAO;
import dao.userDAO;
import modul.Documents;
import modul.Users;
import utils.Validation;

public class Manager_Fun  extends Function{
	static ArrayList<Users> user_List = userDAO.getInstance().selectAll();
	static ArrayList<Documents> doc_List = documentDAO.getInstance().selectAll();
	static Validation validation = new Validation();
	static Scanner scanner = new Scanner(System.in);
	
//MENU
	public void Menu() {	
		while(true) {
			System.out.println("------------MENU------------");
			System.out.println("1. Add documnet");
			System.out.println("2. Create user");
			System.out.println("3. Show Data(document or user)");
			System.out.println("4. Search document");
			String line = scanner.nextLine();
			switch (line) {
			case "1":
				addDocument();
				doc_List = documentDAO.getInstance().selectAll();
				break;
			case "2":
				createAccount();
				user_List = userDAO.getInstance().selectAll();
				break;
			case "3":
				show(line);
				break;
			case "4":
				menuSearch();
				break;
			case "0" : return;
			default:
				break;
			}
		}
	}
	
//SHOW DATA
	public static void show(String key ) {
		System.out.println("-----MENU.SHOW-------");
		System.out.println("a. Show all document");
		System.out.println("b. Show all user");
		System.out.println("----------------------");
		String keyShow = scanner.nextLine();
		switch (keyShow) {
		case "a":
			showDocuments();
			break;
		case "b":
			for (int i = 0; i < user_List.size(); i++) {
				int j = i + 1;
				System.out.println("user " + j);
				System.out.println(user_List.get(i).toString()+"\n");
			}
		case "0" : 
			return;
		default:
			break;
		}
	}
	
//ADD DOCUMENT
	public static void addDocument() {
		System.out.println("nhập ID of document : "); 
		String id = String.valueOf(validation.checkDocumentID());
		System.out.println("nhập Type of document : "); 
		String type = type();
		System.out.println("nhập Name of document : "); 
		String name = scanner.nextLine();
		System.out.println("nhập Author of document : "); 
		String author = scanner.nextLine();
		System.out.println("nhập Title of document : "); 
		String title = scanner.nextLine();
		System.out.println("nhập year of document : "); 
		int year = scanner.nextInt();
		Documents documents = new Documents(id, type, name, author, title, year, 0, 0, 0, 1);
		documentDAO.getInstance().insert(documents);
		scanner.nextLine();
	}
	
//CHOSSE TYPE
	private static String type() {
		System.out.println("-----DOCUMENTTYPE------");
		System.out.println("a. SPIRITUAL");
		System.out.println("b. HISTORY");
		System.out.println("c. PHILOSOPHY");
		System.out.println("d. INFORMATION TECHNOLOGY");
		String key = scanner.nextLine();
		switch (key) {
		case "a":
			key = "SPIRITUAL" ;
			break;
		case "b":
			key = "HISTORY" ;
			break;
		case "c":
			key = "PHILOSOPHY" ;
			break;
		case "d":
			key = "INFORMATION TECHNOLOGY" ;
			break;
		default:
			break;
		}
		return key ;
	}
}
