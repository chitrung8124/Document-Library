package modul;

public class Users {
		private String userName ;
		private String passWord ;	
		private String accountID ="7000000"; 
		public Users( String accountID ,String userName, String passWord) {
			super();
			this.userName = userName;
			this.passWord = passWord;
			this.accountID = accountID;
		}
		public Users() {}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWord() {
			return passWord;
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		public String getAccountID() {
			return accountID;
		}
		public void setAccountID(String accountID) {
			this.accountID = accountID;
		}
		@Override
		public String toString() {
			return "[userName : " + userName + ", passWord : " + passWord + ", accountID : " + accountID + "]";
		}
		
}
