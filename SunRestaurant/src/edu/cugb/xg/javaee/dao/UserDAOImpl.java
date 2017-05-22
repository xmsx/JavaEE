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
		java.sql.PreparedStatement ps=null;
		Connection connection=null;
		int addSuccessful=0;
		try {
			String sql="insert into Users values(?,?,?,?);";
			connection= JDBCUtils.getConnection();
			ps=connection.prepareStatement(sql);
			ps.setInt(1, user.getUserid());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAddress());

			//System.out.println(ps.toString());
			addSuccessful=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.free(null, ps, connection);
		}
		if (addSuccessful>0) {
			return user.getUserid();
		}
		return 0;
	}

	@Override
	public int updateUser(Users user) {
		// TODO Auto-generated method stub
		java.sql.PreparedStatement ps=null;
		Connection connection=null;
		int modifySuccessful=0;
		try {
			String sql="update USER set UserName='"+user.getUsername()+"',UserPassword='"+user.getPassword()+"',Address='"+user.getAddress()+"' where UserId='"+user.getUserid()+"'";
			connection= JDBCUtils.getConnection();
			ps=connection.prepareStatement(sql);

			//System.out.println(ps.toString());
			modifySuccessful=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.free(null, ps, connection);
		}
		if (modifySuccessful>0) {
			return user.getUserid();
		}
		return 0;
	}

	@Override
	public int deleteUser(Users user) {
		// TODO Auto-generated method stub
		java.sql.PreparedStatement ps=null;
		Connection connection=null;
		int removeSuccessful=0;
		try {
			String sql="delete from student where UserId="+user.getUserid();
			connection= JDBCUtils.getConnection();
			ps=connection.prepareStatement(sql);

			//System.out.println(ps.toString());
			removeSuccessful=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.free(null, ps, connection);
		}
		if (removeSuccessful>0) {
			return user.getUserid();
		}
		return 0;
	}

}
