package modul;

public class BorrowDocuments {
	private String documnentID;
	private String accountID ;
	public BorrowDocuments(String documnentID, String accountID) {
		this.documnentID = documnentID;
		this.accountID = accountID;
	}
	
	public BorrowDocuments() {}
	
	public String getDocumnentID() {
		return documnentID;
	}
	
	public void setDocumnentID(String documnentID) {
		this.documnentID = documnentID;
	}
	
	public String getAccountID() {
		return accountID;
	}
	
	public void setAccountID(String userID) {
		this.accountID = userID;
	}
	
	@Override
	public String toString() {
		return "Docfavourite [documnentID=" + documnentID + ", accountID=" + accountID + "]";
	}
}
