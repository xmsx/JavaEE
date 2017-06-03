package edu.cugb.xg.javaee.biz;

import edu.cugb.xg.javaee.bean.Users;
import edu.cugb.xg.javaee.dao.UserDAO;
import edu.cugb.xg.javaee.dao.UserDAOImpl;
import edu.cugb.xg.javaee.utils.DAOFactory;

public class UserService {
	public boolean validateUser(Users user){
		//ȥDB�в���ָ���û����Ϳ�����û�
		UserDAO userdao = (UserDAO) DAOFactory.newInstance("UserDAO");
		return userdao.findUser(user);		
	}
}
