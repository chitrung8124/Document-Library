package modul;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryBorrow extends BorrowDocuments{
		private String borrowedDay ;
		private String payDay ;
		public HistoryBorrow(String documnentID, String accountID, String borrowedDay, String payDay) {
			super(documnentID, accountID);
			this.borrowedDay = borrowedDay;
			this.payDay = payDay;
		}
		public LocalDateTime getBorrowedDay() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        LocalDateTime dateTime = LocalDateTime.parse(borrowedDay, formatter);
			return  dateTime;
		}
		public void setBorrowedDay(String borrowedDay) {
			this.borrowedDay = borrowedDay;
		}
		public LocalDateTime getPayDay() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        LocalDateTime dateTime = LocalDateTime.parse(payDay, formatter);
			return  dateTime;
		}
		public void setPayDay(String payDay) {
			this.payDay = payDay;
		}

}
