package model;

import dao.UserDao;
import dto.UserDto;
import exception.SystemException;

public class UserManage {

	/**登録処理
	 *
	 *
	 * @param userdto
	 */
	public void register(UserDto userdto) throws SystemException{

		UserDao userdao = new UserDao();

		try {
			userdao.insert(userdto);
		} catch(Exception e) {
			throw new SystemException("ユーザーの登録に失敗しました");
		}
	}
	/**
	 * 更新処理
	 *
	 * @param userdto
	 */
	public void update(UserDto userdto) {

		UserDao userdao = new UserDao();

		userdao.update(userdto);
	}
	/**
	 * ユーザー情報取得
	 *
	 * @param mail
	 * @return
	 */
	public UserDto getmail(String mail) {

		UserDao userdao = new UserDao();

		return userdao.getUserByID(mail);
	}
	public UserDto getId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
