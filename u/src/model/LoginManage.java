package model;

import dao.UserDao;
import dto.LoginDto;

public class LoginManage {

	public LoginDto login(String mail,String pass){
		LoginDto login = new LoginDto();

		UserDao dao = new UserDao();

		login = dao.login(mail,pass);
		System.out.println(login+"*login");

		return login;
	}

}
