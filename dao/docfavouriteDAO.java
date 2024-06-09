package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import modul.Docfavourite;

public class docfavouriteDAO implements DaoInterface<Docfavourite>{
	public static docfavouriteDAO getInstance() {
		return new docfavouriteDAO();
	}

	@Override
	public int insert(Docfavourite d) {
		int result=0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "INSERT INTO docfavourite(documentID ,accountID )"
						+" VALUES('"+d.getDocumnentID()+
						"' , '"+d.getAccountID()+"')";
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
	public int update(Docfavourite t) {
		return 0;
	}

	@Override
	public int delete(Docfavourite d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "DELETE from docfavourite "
						+" WHERE documentID='"+d.getDocumnentID()+"'";
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
	public ArrayList<Docfavourite> selectAll() {
		ArrayList<Docfavourite> result = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "SELECT * FROM docfavourite";
			 ResultSet rs =  st.executeQuery(sql); 
			while(rs.next()) {
				 String accountID = rs.getNString("accountID") ;
				 String documentID = rs.getNString("documentID") ;
				 Docfavourite user = new Docfavourite(documentID, accountID);
				 result.add(user);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Docfavourite> selectById(String t) {
		ArrayList<Docfavourite> result = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "SELECT * FROM docfavourite"
					+" WHERE  documentID='"+t+"\'";;
			 ResultSet rs =  st.executeQuery(sql); 
			while(rs.next()) {
				 String accountID = rs.getNString("accountID") ;
				 String documentID = rs.getNString("documentID") ;
				 Docfavourite user = new Docfavourite(documentID, accountID);
				 result.add(user);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Docfavourite> selectByCondition(Docfavourite condition) {
		return null;
	}
	
}
