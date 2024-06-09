package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import modul.BorrowDocuments;

public class BorrowdocumentsDAO implements DaoInterface<BorrowDocuments>{
	public static BorrowdocumentsDAO getInstance() {
		return new BorrowdocumentsDAO();
	}

	@Override
	public int insert(BorrowDocuments d) {
		int result=0;
		try {
			//B1 : tạo kết nối tới cơ sở dữ liệu 
			Connection connection = JDBCUtil.getConnection();
			//B2 : tạo đối tượng Statement
			java.sql.Statement st = connection.createStatement();
			//B3 : thực thi
			String sql = "INSERT INTO borrowdocuments(documentID ,accountID )"
						+" VALUES('"+d.getDocumnentID()+
						"' , '"+d.getAccountID()+"')";
			 result = st.executeUpdate(sql); 
			//B4 : xử lí
			if(result >0) {
				System.out.println("đã thực thi "+sql);
				System.out.println("dòn bị thay đổi : " + result);
			}
			//B5 : đóng
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<BorrowDocuments> selectAll() {
		ArrayList<BorrowDocuments> result = new ArrayList<>();
		try {
			//B1 : tạo kết nối tới cơ sở dữ liệu 
			Connection connection = JDBCUtil.getConnection();
			//B2 : tạo đối tượng Statement
			java.sql.Statement st = connection.createStatement();
			//B3 : thực thi
			String sql = "SELECT * FROM borrowdocuments";
			//System.out.println(sql);
			 ResultSet rs =  st.executeQuery(sql); 
			//B4 : xử lí
			while(rs.next()) {
				 String accountID = rs.getNString("accountID") ;
				 String documentID = rs.getNString("documentID") ;
				 BorrowDocuments user = new BorrowDocuments(documentID, accountID);
				 result.add(user);
			}
			//B5 : đóng
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int update(BorrowDocuments t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BorrowDocuments d) {
		int result = 0;
		try {
			//B1 : tạo kết nối tới cơ sở dữ liệu 
			Connection connection = JDBCUtil.getConnection();
			//B2 : tạo đối tượng Statement
			java.sql.Statement st = connection.createStatement();
			//B3 : thực thi
			String sql = "DELETE from borrowdocuments "
						+" WHERE documentID='"+d.getDocumnentID()+"'";
			 result = st.executeUpdate(sql); 
			//B4 : xử lí
			if(result >0) {
				System.out.println("đã thực thi "+sql);
				System.out.println("dòn bị thay đổi : " + result);
			}
			//B5 : đóng
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<BorrowDocuments> selectById(String id) {
		ArrayList<BorrowDocuments> result = new ArrayList<>();
		try {
			//B1 : tạo kết nối tới cơ sở dữ liệu 
			Connection connection = JDBCUtil.getConnection();
			//B2 : tạo đối tượng Statement
			java.sql.Statement st = connection.createStatement();
			//B3 : thực thi
			String sql = "SELECT * FROM borrowdocuments"
					+" WHERE  accountID='"+id+"\'";;
			//System.out.println(sql);
			 ResultSet rs =  st.executeQuery(sql); 
			//B4 : xử lí
			while(rs.next()) {
				 String accountID = rs.getNString("accountID") ;
				 String documentID = rs.getNString("documentID") ;
				 BorrowDocuments user = new BorrowDocuments(documentID, accountID);
				 result.add(user);
			}
			//B5 : đóng
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<BorrowDocuments> selectByCondition(BorrowDocuments condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
