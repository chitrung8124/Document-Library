package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import modul.HistoryBorrow;

public class HistoryborrowDAO implements DaoInterface<HistoryBorrow>{
	public static HistoryborrowDAO getInstance() {
		return new HistoryborrowDAO();
	}

	@Override
	public int insert(HistoryBorrow d) {
		int result=0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "INSERT INTO historybrrow(accountID ,documentID ,borrowedDay)"
						+" VALUES('"+d.getAccountID()+
						"' , '"+d.getDocumnentID()+"' , '"+d.getBorrowedDay()+"')";
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
	public int update(HistoryBorrow d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "UPDATE historybrrow "
						+" SET "
						+" payDay="+ d.getPayDay()
						+" WHERE  accountID='"+d.getAccountID()+"and documentID='"+d.getDocumnentID()+"\'";
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
	public int delete(HistoryBorrow d) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "DELETE from historybrrow "
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
	public ArrayList<HistoryBorrow> selectAll() {
		ArrayList<HistoryBorrow> result = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "SELECT * FROM historybrrow";
			 ResultSet rs =  st.executeQuery(sql); 
			while(rs.next()) {
				 String accountID = rs.getNString("accountID") ;
				 String documentID = rs.getNString("documentID") ;
				 String borrowedPay = rs.getNString("borrowedDay");
				 String payDay = rs.getNString("payDay");
				 HistoryBorrow hb = new HistoryBorrow(documentID, accountID, borrowedPay, payDay);
				 result.add(hb);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HistoryBorrow> selectById(String t) {
		ArrayList<HistoryBorrow> result = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sql = "SELECT * FROM historybrrow"
						+" WHERE  documentID='"+t+"\'";
			 ResultSet rs =  st.executeQuery(sql); 
			while(rs.next()) {
				 String accountID = rs.getNString("accountID") ;
				 String documentID = rs.getNString("documentID") ;
				 String borrowedPay = rs.getNString("borrowedDay");
				 //LocalDateTime sd = rs.get(0);
				 String payDay = rs.getNString("payDay");
				 HistoryBorrow hb = new HistoryBorrow(documentID, accountID, borrowedPay, payDay);
				 result.add(hb);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HistoryBorrow> selectByCondition(HistoryBorrow condition) {
		// TODO Auto-generated method stub
		return null;
	}
}
