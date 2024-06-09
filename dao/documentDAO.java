package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import modul.Documents;


public class documentDAO implements DaoInterface<Documents> {
	public static documentDAO getInstance() {
		return new documentDAO();
	}
	@Override
	public int insert(Documents d) {
		int result=0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "INSERT INTO documents(documentID, documentType, documentName, authorName,title ,YEAR, STATUS, favourite ,evaluate ,mediumScore )"
						+" VALUES('"+
						d.getDocumentID()+"' , '"+d.getDocumentType() +"' , '"+d.getDocumentName()+"' , '"+d.getAuthorName()+
						"' , '"+d.getTitle()+"' , '"+d.getYear()+
						"' , '"+d.getStatus()+"' , '"+d.getFavourite()+"' , '"+d.getEvaluate()+"' , '"+d.getMediumScore()+"')";
			 result = st.executeUpdate(sql); 
			if(result >0) {
				System.out.println("đã thực thi "+sql);
				System.out.println("dòn bị thay đổi : " + result);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Documents d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "UPDATE documents "
						+" SET "
						+" documentType="+ d.getDocumentType()+"'"
						+", documentName="+ d.getDocumentName()
						+", authorName="+ d.getAuthorName()
						+", title="+  d.getTitle()
						+", YEAR="+  d.getYear()
						+", STATUS="+ d.getStatus()
						+", favourite="+ d.getFavourite()
						+", evaluate="+ d.getEvaluate()
						+", mediumScore="+ d.getMediumScore()
						+" WHERE documentID='"+d.getDocumentID()+"\'";
			 result = st.executeUpdate(sql); 
			 JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateStatus(Documents d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "UPDATE documents "
						+" SET "
						+" STATUS="+ d.getStatus()
						+" WHERE documentID='"+d.getDocumentID()+"\'";
			 result = st.executeUpdate(sql); 
			if(result >0) {
				System.out.println("đã thực thi "+sql);
				System.out.println("dòn bị thay đổi : " + result);
			}
			 JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//UPDATE FAVOURITE
	public int updateFavourite(Documents d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "UPDATE documents "
						+" SET "
						+" favourite="+ d.getFavourite()
						+" WHERE documentID='"+d.getDocumentID()+"\'";
			 result = st.executeUpdate(sql); 
			if(result >0) {
				System.out.println("đã thực thi "+sql);
				System.out.println("dòn bị thay đổi : " + result);
			}
			 JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateMediumScore(Documents d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "UPDATE documents "
						+" SET "
						+" mediumScore="+ d.getMediumScore()
						+" WHERE documentID='"+d.getDocumentID()+"\'";
			 result = st.executeUpdate(sql); 
			if(result >0) {
				System.out.println("đã thực thi "+sql);
				System.out.println("dòn bị thay đổi : " + result);
			}
			 JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateEvaluate(Documents d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "UPDATE documents "
						+" SET "
						+" evaluate="+ d.getEvaluate()
						+" WHERE documentID='"+d.getDocumentID()+"\'";
			 result = st.executeUpdate(sql); 
			if(result >0) {
				System.out.println("đã thực thi "+sql);
				System.out.println("dòn bị thay đổi : " + result);
			}
			 JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Documents d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "DELETE from documents "
						+" WHERE documentID='"+d.getDocumentID()+"'";
			 result = st.executeUpdate(sql); 
			if(result >0) {
				System.out.println("đã thực thi "+sql);
				System.out.println("dòn bị thay đổi : " + result);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Documents> selectAll() {
		ArrayList<Documents> result = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "SELECT * FROM documents";
			 ResultSet rs =  st.executeQuery(sql); 
			while(rs.next()) {
			     String documentID = rs.getNString("documentID") ;
				 String documentType = rs.getNString("documentType") ;
				 String documentName = rs.getNString("documentName") ;
				 String authorName = rs.getNString("authorName") ;
				 String title = rs.getNString("title") ;
				 int year = rs.getInt("YEAR") ;
				 int status = rs.getInt("STATUS") ;
				 int favourite = rs.getInt("favourite") ;
				 double evaluate = rs.getDouble("evaluate"); 
				 double mediumScore = rs.getDouble("mediumScore");
				 Documents document = new Documents(documentID, documentType, documentName
						 				, authorName, title, year, status, favourite, evaluate,mediumScore);
				 result.add(document);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Documents> selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Documents> selectByCondition(Documents condition) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
