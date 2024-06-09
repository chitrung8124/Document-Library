package Function;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import dao.BorrowdocumentsDAO;
import dao.HistoryborrowDAO;
import dao.docfavouriteDAO;
import dao.documentDAO;
import dao.userDAO;
import modul.BorrowDocuments;
import modul.Docfavourite;
import modul.Documents;
import modul.Users;
import modul.HistoryBorrow;

public class User_Fun extends Function{
	static ArrayList<Users> user_List = userDAO.getInstance().selectAll();
	static ArrayList<Documents> doc_List = documentDAO.getInstance().selectAll();
	static ArrayList<Docfavourite> favourite_list = docfavouriteDAO.getInstance().selectAll();
	static ArrayList<BorrowDocuments> borrowDocuments_List = BorrowdocumentsDAO.getInstance().selectAll();
	static ArrayList<HistoryBorrow> historyborrows_List = HistoryborrowDAO.getInstance().selectAll();
	static Documents documents = new Documents();
	static Scanner scanner = new Scanner(System.in);
	static String nameLogin = "";
	static String idLogin = "";


//MENU
	public void Menu() {
		while(true) {
			System.out.println("------------MENU------------");
			System.out.println("1. Crate account");
			System.out.println("2. Login account");
			String line = scanner.nextLine();
			switch (line) {
			case "1":
				createAccount();
				user_List = userDAO.getInstance().selectAll();
				break;
			case "2":
				login();
				break;
			case "0" : return;
			default:
				break;
			}
		}
	}
	
//LOGIN ACCOUNT
	private static void login() {
		System.out.println("Enter userName of user : "); 
		String userName = scanner.nextLine();
		nameLogin = userName;
		System.out.println("Enter passWord of user : "); 
		String passWord = scanner.nextLine();
		testResults(userName, passWord);
	}
	
	//CHECK ACCOUNT
	private static boolean  checkAccount(String nameUser , String Pass) {
		//ArrayList<Users> user_List2 = userDAO.getInstance().selectAll();
		for (Users users : user_List) {
			if(users.getUserName().equals(nameUser) && users.getPassWord().equals(Pass)) {
				return true;
			}
		}
		return false;
	}
	
	//TEST RESULTS
	private static void testResults(String nameUser , String Pass) {
		if(checkAccount(nameUser, Pass)) {
			menuPermission();
		} else {
			System.out.println("Username does not exist or Passowrd incorrect");
			System.out.println("Please log in again");
			login();
		}
	}
	
//PERMIISSION
	private static void permission() {
			System.out.println("------------MENU.PERMISSION------------");
			System.out.println("1. show all documents");
			System.out.println("2. search document ");
			System.out.println("3. add favourite document");
			System.out.println("4. delete favourite document");
			System.out.println("5. show favourite document");
			System.out.println("6. Borrow Document");
			System.out.println("7. Show Documents Borrow");
			System.out.println("8. Evaluate + Pay ");
			System.out.println("9. ");
	}
	
	//MENU AFTER LOGIN
	private static void menuPermission() {
		while(true) {
			permission();
			String line = scanner.nextLine();	
			switch (line) {
				case "1":
					showDocuments();
				break;
				case "2":
					menuSearch();
					break;
				case "3":
					addFavourite();
					break;
				case "4":
					deleteFatourite();
					break;
				case "5":
					showFavourite();
					break;
				case "6":
					borrowDocuments();
					break;
				case "7":
					showBorrow();
					break;
				case "8":
					System.out.println("Choose ID of document you want pay : "); 
					String id = scanner.nextLine();
					payDocument(id);
					break;
				case "0" : return;
				default:
					break;
			}
		}
	}
	
	//CHECK NAME LOGIN AFTER RETURN ID LOGIN
	private static String checkNameLogin() {
		for (Users u : user_List) {
			if(u.getUserName().equals(nameLogin)) {
				return u.getAccountID();
			}
		} return "";
	}
	
//ADD FAVOURITE DOCUMENT 	
	private static void addFavourite() {
		System.out.println("Choose your favorite ID of document  : "); 
		String id = scanner.nextLine();
				Docfavourite docF = new Docfavourite(id,checkNameLogin());
				docfavouriteDAO.getInstance().insert(docF);
				favourite_list = docfavouriteDAO.getInstance().selectAll();
				updateFavourite(id,"1");
	}
	
//UPDATE FAVOURITE
	private static void updateFavourite(String id,String line) {
		if(line == "1") {
			for (Documents doc : doc_List) {
				if(doc.getDocumentID().equals(id)) {
					int i = doc.getFavourite();
					doc.setFavourite(i+1);
					documentDAO.getInstance().updateFavourite(doc);
				}
			}
		} else {
			for (Documents doc : doc_List) {
				if(doc.getDocumentID().equals(id)) {
					int i = doc.getFavourite()-1;
					doc.setFavourite(i);
					documentDAO.getInstance().updateFavourite(doc);
				}
			}
		}
		doc_List = documentDAO.getInstance().selectAll();
	}
	
//DELETE FAVOURITE DOCUMENT 	
	private static void deleteFatourite() {
		System.out.println("Choose ID of document you want delete : "); 
		String id = scanner.nextLine();
		for (Docfavourite f : favourite_list) {
			if(f.getAccountID().equals(checkNameLogin())) {
				if(f.getDocumnentID().equals(id))
					docfavouriteDAO.getInstance().delete(f);
				favourite_list = docfavouriteDAO.getInstance().selectAll();
			}
		}
		updateFavourite(id,"2");
	}
	
//SHOW FAVOURITE DOCUMENT 
	private static void showFavourite() {
		for (Docfavourite f : favourite_list) {
				if(f.getAccountID().equals(checkNameLogin()))
				System.out.println(f.toString());
			}
		}

//BORROW DOCUMENTS	
	private static void borrowDocuments() {
		System.out.println("Choose ID of document you want borrow  : "); 
		String id = scanner.nextLine();
				BorrowDocuments docB = new BorrowDocuments(id,checkNameLogin());
				BorrowdocumentsDAO.getInstance().insert(docB);	
				borrowDocuments_List = BorrowdocumentsDAO.getInstance().selectAll();
				updateStatus(id);
				historybBorrow(id);
	}
	
	//HistorybBorrow
	private static void historybBorrow(String idA) {
		LocalDateTime borrowDay = LocalDateTime.now();
		DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String borrowDayS =borrowDay.format(formatter );
		HistoryBorrow hb = new HistoryBorrow(checkNameLogin(), idA, borrowDayS, null );
		HistoryborrowDAO.getInstance().insert(hb);
		historyborrows_List = HistoryborrowDAO.getInstance().selectAll();		
	}

//SHOW DOCUMENTS BORROW
	private static void showBorrow() {
		for (BorrowDocuments borrowDocuments : borrowDocuments_List) {
			if(borrowDocuments.getAccountID().equals(checkNameLogin()))
			System.out.println(borrowDocuments.toString());
		}
	}
	
//EVALUETE 
	private static void evaluate(String id) {
		for (Documents d : doc_List) {
			if(d.getDocumentID().equals(id)) {
				mediumScore(d);
			}
		}
	}

	//MEDIUM SCORE + EVALUETE
	private static void mediumScore(Documents doc) {
		double count = doc.getEvaluate();
		double medium = pointEvaluation();
			   medium = doc.getMediumScore()*count + medium ;
			   count = count + 1 ;
		double medium_score = medium / count   ;
		doc.setEvaluate(count);
		documentDAO.getInstance().updateEvaluate(doc);
		doc.setMediumScore(medium_score);
		documentDAO.getInstance().updateMediumScore(doc);
		scanner.nextLine();
	}
	
	//CONSTRAINT
	private static double pointEvaluation() {
		double medium = 0;
		do {
			System.out.println("Enter point evaluation ");
			medium = scanner.nextDouble();
		} while(medium < 0 || medium >5) ;
		return medium ;
	}
	
//PAY DOCUMENT	
	private static void payDocument(String id) {
		evaluate(id);
		for (BorrowDocuments b : borrowDocuments_List) {
			if(b.getAccountID().equals(checkNameLogin())) {
				if(b.getDocumnentID().equals(id)) {
					BorrowdocumentsDAO.getInstance().delete(b);
					updateStatus(b.getDocumnentID());
				}
			}
		}
	}
	//UPDATE PAYDAY
	private static void updatePayDay(String idA,String idD) {
		for (HistoryBorrow historyborrow : historyborrows_List) {
			if(historyborrow.getAccountID().equals(idA) && historyborrow.getDocumnentID().equals(idD)) {
				LocalDateTime payDay = LocalDateTime.now();
				DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String borrowDayS =payDay.format(formatter);
				historyborrow.setPayDay(borrowDayS);
				HistoryborrowDAO.getInstance().update(historyborrow);		
			}
		}
	}

}
