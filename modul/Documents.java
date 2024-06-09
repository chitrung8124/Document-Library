package modul;

public class Documents {
		private String documentID = "800000"; // nếu muốn thêm hàn loạt thì bỏ 1 con số 0
		private String documentType ;
		private String documentName ;
		private String authorName ;
		private String title ;  // tiêu đề	
		private int year ;
		private int status;		// trạng thái 
		private int favourite ;	// số lượng yêu thích
		private double evaluate ; // số sao đánh giá
		private double mediumScore ;
		
	public Documents(String documentID, String documentType
			, String documentName, String authorName, String title,
			int year, int status, int favourite, double evaluate,double mediumScore) {
		super();
		this.documentID = documentID;
		this.documentType = documentType;
		this.documentName = documentName;
		this.authorName = authorName;
		this.title = title;
		this.year = year;
		this.status = status;
		this.favourite = favourite;
		this.evaluate = evaluate;
		this.mediumScore = mediumScore;
	}
	
	public Documents() {}
	
	public String getDocumentID() {
		return documentID;
	}
	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getFavourite() {
		return favourite;
	}
	public void setFavourite(int d) {
		this.favourite = d;
	}
	public double getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(double evaluate) {
		this.evaluate = evaluate;
	}
	
	public double getMediumScore() {
		return mediumScore;
	}
	public void setMediumScore(double mediumScore) {
		this.mediumScore = mediumScore;
	}
	@Override
	public String toString() {
		return "Documents [documentID=" + documentID + ", documentType=" + documentType + ", documentName="
				+ documentName + ", authorName=" + authorName + ", title=" + title + ", year=" + year + ", status="
				+ status + ", favorite=" + favourite + ", evaluate=" + evaluate + ", mediumScore=" + mediumScore + "]";
	}
		
}
