package edu.cugb.xg.javaee.bean;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import edu.cugb.xg.javaee.dao.UserDAO;

public class Users {
	public Users(){
		
	}
	public Users(String user,String pass){
		this.username = user;
		this.password = pass;
	}
	private Integer userid;
	private String username;
	private String password;
	private String address;

	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	
}
