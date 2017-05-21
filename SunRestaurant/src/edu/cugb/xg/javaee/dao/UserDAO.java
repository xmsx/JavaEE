package edu.cugb.xg.javaee.dao;

import java.util.ArrayList;

import edu.cugb.xg.javaee.bean.Users;

public interface UserDAO {
	public ArrayList<Users> findUsers();
	public boolean findUser(Users user);
	public int insertUser(Users user);
	public int updateUser(Users user);
	public int deleteUser(Users user);

}
