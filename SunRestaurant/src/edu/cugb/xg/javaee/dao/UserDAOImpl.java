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
		return null;
	}

	@Override
	public boolean findUser(Users user) {
		// TODO Auto-generated method stub
		try {
			Connection con = JDBCUtils.getConnection();
			String sql = "Select * from Users where Username = ?";
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, user.getUsername());
			int rs = sta.executeUpdate();
			JDBCUtils.free(null, sta, con);
			if (rs == 0)
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public int insertUser(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
