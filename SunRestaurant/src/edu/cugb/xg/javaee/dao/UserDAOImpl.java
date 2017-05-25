package edu.cugb.xg.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import edu.cugb.xg.javaee.bean.Users;
import edu.cugb.xg.javaee.utils.JDBCUtils;

public class UserDAOImpl extends baseDAO implements UserDAO {

	@Override
	public ArrayList<Users> findUsers() {
		// TODO Auto-generated method stub
		String sql = "select userid Userid,username "
				+ "Username,password Password from users";
		return findObjs(sql,null,Users.class);
	}

	@Override
	public boolean findUser(Users user) {
		// TODO Auto-generated method stub
		String sql = "select userid Userid,username "
				+ "Username,password Password from users where username=? and password=?";
		Object[] params = {user.getUsername(),user.getPassword()};
		if(findObj(sql,params,Users.class) != null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int insertUser(Users user) {
		// TODO Auto-generated method stub
		String sql = "insert into users(userid,username,password,"
				+ "createdate) values(?,?,?,?)";
		Object[] params = {user.getUserid(),user.getUsername(),user.getPassword(),user.getCreatedate()};
		return modifyObj(sql, params);
	}

	@Override
	public int updateUser(Users user) {
		// TODO Auto-generated method stub
		String sql="update users set userid=?,password=?,createdate=? where username=?";
		Object[] params = {user.getUserid(),user.getPassword(),user.getCreatedate(),user.getUsername()};
		return modifyObj(sql, params);
	}

	@Override
	public int deleteUser(Users user) {
		// TODO Auto-generated method stub
		String sql = "delete from users where username=?";
		Object[] params = {user.getUsername()};
		return modifyObj(sql, params);
	}

}
