package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import modul.Users;


public class userDAO implements DaoInterface<Users> {
	public static userDAO getInstance() {
		return new userDAO();
	}
	@Override
	public int insert(Users d) {
		int result=0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "INSERT INTO users(accountID ,userName ,passWord )"
						+" VALUES('"+d.getAccountID()+
						"' , '"+d.getUserName()+
						"' , '"+d.getPassWord()+"')";
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
	public int update(Users d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "UPDATE users "
						+" SET "
						+", userName="+ d.getUserName()+"'"
						+", passWord="+ d.getPassWord()
						+" WHERE accountID='"+d.getAccountID()+"\'";
			 result = st.executeUpdate(sql); 
			 JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Users d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "DELETE from users "
						+" WHERE accountID='"+d.getAccountID()+"'";
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
	public ArrayList<Users> selectAll() {
		ArrayList<Users> result = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "SELECT * FROM users";
			 ResultSet rs =  st.executeQuery(sql); 
			while(rs.next()) {
				 String accountID = rs.getNString("accountID") ;
				 String userName = rs.getNString("userName") ;
				 String passWord = rs.getNString("passWord") ;
				 Users user = new Users(accountID, userName, passWord);
				 result.add(user);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Users> selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> selectByCondition(Users condition) {
		// TODO Auto-generated method stub
		return null;
	}
}
