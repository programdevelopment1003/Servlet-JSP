package model;

import java.util.ArrayList;

import javax.sql.DataSource;

public class ScheduleDAO extends DaoBase{

	public ScheduleDAO() {}
	//データソース
	DataSource ds=null;


	public InformationBean getLogin(String mail,String pass){
		InformationBean information ;

		try{
			//connection確率
			super.DbOpen();
			String sql ="select login.id , login.username, login.authority  from login, password"+
			" where login.id=password.id  and login.mail=? and password.password=? ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,mail);
			stmt.setString(2,pass);
			rs=stmt.executeQuery();

			//カーソルを１件目へ移動させる、データがなければcatch
			rs.next();
			//InformationBeanへ値を格納
			 information = new InformationBean(rs.getInt("id"),rs.getString("username"),rs.getString("authority"));


		}catch(Exception e){
			information=null;
			System.out.println(e);
		}finally{
			try{

			}catch(Exception e){
				System.out.println(e);
			}
		}

		return information;
	}

	//会員登録
	public void Register(String mail, String pass, String username, String name, String post, String address) {
		try{
			super.DbOpen();
			String authorty="U";
			String into="insert into login(username,mail,authority) values(?,?,?)";
			stmt=con.prepareStatement(into);
			System.out.println("x");
			stmt.setString(1,username);
			System.out.println("e");
			stmt.setString(2,mail);
			System.out.println("e3");
			stmt.setString(3,authorty);
			stmt.execute();
			String into2="insert into user(name,post,address) values(?,?,?)";
			stmt=con.prepareStatement(into2);
			stmt.setString(1,name);
			stmt.setString(2,post);
			stmt.setString(3, address);
			stmt.execute();
			String into3="insert into password(password) values(?)";
			stmt=con.prepareStatement(into3);
			stmt.setString(1, pass);
			stmt.execute();
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{

			}catch(Exception e){
				System.out.println(e);
			}

		}
	}
	//会員情報の習得
	public UserBean user(int id) {
		UserBean userBean;

		try{
			super.DbOpen();
			String user ="select login.username,login.mail,password.password,user.name,user.post,user.address  from  login,password,user where login.id=password.id and login.id=user.id and login.id=?";
			stmt=con.prepareStatement(user);
			stmt.setInt(1,id);

			rs=stmt.executeQuery();


			rs.next();
			userBean = new UserBean(rs.getString("username"),rs.getString("mail"),rs.getString("password"),rs.getString("name"),rs.getString("post"),rs.getString("address"));
		}catch(Exception e){
			userBean=null;
		}finally{
			try{
			}catch(Exception e){
			}
		}
		return userBean;
	}
	//会員情報の変更
	public void Change(String username, String mail, String name, String post, String address,int id) {
		try{
			super.DbOpen();
			String updatelogin ="UPDATE login SET username=?,mail=? where id=?";
			stmt=con.prepareStatement(updatelogin);
			stmt.setString(1,username);
			stmt.setString(2,mail);
			stmt.setInt(3, id);
			stmt.execute();
			String updateuser="UPDATE user SET name=?,post=?,address=? where id=?";
			stmt=con.prepareStatement(updateuser);
			stmt.setString(1,name);
			stmt.setString(2,post);
			stmt.setString(3,address);
			stmt.setInt(4, id);
			stmt.execute();
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}

	//パスワード変更
	public void PassChange(String pass, int id) {
		try{
			super.DbOpen();
			String updatepass ="UPDATE password SET password=? where id=?" ;
			stmt=con.prepareStatement(updatepass);
			stmt.setString(1,pass);
			stmt.setInt(2, id);
			rs=stmt.executeQuery();

		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
	//削除
	public void Erasing(int id) {
		try{
			super.DbOpen();
			String  deletelogin="DELETE FROM login WHERE id=?";
			stmt=con.prepareStatement(deletelogin);
			stmt.setInt(1, id);
			stmt.execute();
			String  deletepass="DELETE FROM password WHERE id=?";
			stmt=con.prepareStatement(deletepass);
			stmt.setInt(1, id);
			stmt.execute();
			String  deleteuser="DELETE FROM user WHERE id=?";
			stmt=con.prepareStatement(deleteuser);
			stmt.setInt(1, id);
			stmt.execute();
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
	//検索
	public ArrayList<ProduBean> getProdu(String search) {
		ProduBean produBean;
		ArrayList<ProduBean> produbean=new ArrayList<ProduBean>();

		try{
			super.DbOpen();
			String sql ="select Productname,Categoriesname,Description,price from product,categories where product.Categoriesid=categories.Categoriesid and Productname like' %"+search+"%'";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();

			while(rs.next()){
				produBean=new ProduBean(rs.getString("Productname"),rs.getString("Categoriesname"),rs.getString("Driesname"),rs.getString("price"));
				produbean.add(produBean);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
			}catch(Exception e){
				System.out.println(e);
			}
		}

		return produbean;
	}
//商品一覧
	public ArrayList<ProduBean> AllProduct() {
		ProduBean produBean;
		ArrayList<ProduBean> produbean=new ArrayList<ProduBean>();

		try{
			super.DbOpen();
			String sql ="select Productname,Categoriesname,Description,price from product,categories where product.Categoriesid=categories.Categoriesid ";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				produBean=new ProduBean(rs.getString("Productname"),rs.getString("Categoriesname"),rs.getString("Description"),rs.getString("price"));
				produbean.add(produBean);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
			}catch(Exception e){
				System.out.println(e);
			}
		}

		return produbean;
	}
//商品追加
	public void Addto(String name, String descr, String price, String description) {
		try{
			super.DbOpen();
			String updatelogin ="insert into product(Productname,Categoriesid,Description,price) values(?,?,?,?)";
			stmt=con.prepareStatement(updatelogin);
			stmt.setString(1,name);
			stmt.setString(2,description);
			stmt.setString(3, descr);
			stmt.setString(4,price);
			stmt.execute();
			//カーソルを１件目へ移動させる、データがなければcatch
			//InformationBeanへ値を格納



	}catch(Exception e){
		System.out.println(e);
	}finally{
		try{
		}catch(Exception e){
			System.out.println(e);
		}
	}

	}

	public void Cart(String name, String ption, String product, String produ, int id) {
		// TODO 自動生成されたメソッド・スタブ
		try{
			super.DbOpen();
			String updatelogin ="insert into cart(id,name,ption,Product,produ) values(?,?,?,?,?)";
			stmt=con.prepareStatement(updatelogin);
			stmt.setInt(1,id);
			stmt.setString(2,name);
			stmt.setString(3,ption);
			stmt.setString(4, product);
			stmt.setString(5,produ);
			stmt.execute();
	}catch(Exception e){
		System.out.println(e);
	}finally{
		try{
		}catch(Exception e){
			System.out.println(e);
		}
	}
	}

	public ArrayList<CartBean> getcart(int id) {
		CartBean cartBean;
		ArrayList<CartBean> cartbean=new ArrayList<CartBean>();
		System.out.println(id);
		try{
			super.DbOpen();
		String sql ="select name,ption,Product,produ  from cart"+
				" where id=? ";
				stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				rs=stmt.executeQuery();
				while(rs.next()){
					cartBean=new CartBean(rs.getString("name"),rs.getString("ption"),rs.getString("Product"),rs.getString("produ"));
					cartbean.add(cartBean);
				}

	}catch(Exception e){
		System.out.println(e);
	}finally{
		try{
		}catch(Exception e){
			System.out.println(e);
		}
	}
		return cartbean;
		}

	public ArrayList<UserBean> getuser() {
		UserBean information;
		ArrayList<UserBean> user= new ArrayList<UserBean>();
		try{
			super.DbOpen();
			String sql="select login.username,login.mail,password.password,user.name,user.post,user.address  from  login,password,user";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();

			//カーソルを１件目へ移動させる、データがなければcatch
			while(rs.next()){
			//ListBeanへ値を格納
			 information = new UserBean( rs.getString("username"),rs.getString("mail"),rs.getString("password"),rs.getString("name"),rs.getString("post"),rs.getString("address"));
			user.add(information);
			}

	}catch(Exception e){
		System.out.println(e);
	}finally{
		try{
			super.DbClose();
		}catch(Exception e){
			System.out.println(e);
		}

	}
		return  user;
	}
}





