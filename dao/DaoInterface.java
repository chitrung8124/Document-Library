package dao;

import java.util.List;

public interface DaoInterface <T> {
	public  int insert(T t);
	public  int update(T t);
	public  int delete(T t);
	public   List<T> selectAll();
	public  List<T> selectById(String t);
	public 	 List<T> selectByCondition(T condition);
}
