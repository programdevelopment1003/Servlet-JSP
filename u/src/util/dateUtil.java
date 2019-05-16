package util;

import dao.UserDao;
import dto.UserDto;
import exception.SystemException;

public class dateUtil {

	public static boolean isNumeric(String str) {
		boolean result = true;

		try {
			Integer.parseInt(str);
		} catch(NumberFormatException e) {
			result = false;
		}

		return result;
	}
	/**
	 * メールアドレス
	 *
	 * @param mail
	 * @return true : 形式OK　false : 形式NG
	 */
	//public static boolean isMail(String mail) {
		//String mailFormat = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";

		//if(!mail.matches(mailFormat)) {
			//return false;
		//}
		//return true;
	//}

	/**
	 * メールアドレスの複数チェック
	 *
	 * @param mailAddress
	 * @return
	 */
	public static boolean duplicatemail(String mail) throws SystemException{

		UserDao dao = new UserDao();
		UserDto userdto;
		try {
			 userdto = dao.getUser(mail);
		} catch (Exception e){
			throw new SystemException();
		}
		return (userdto == null ? false:true);

	}
	public static boolean ismail(String mail) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
