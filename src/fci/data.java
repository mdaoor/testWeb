package fci;

import java.sql.*;

import java.util.Random;

class data {
	
	
	public  static String DBurl , DBpass, DBuser ; 
	public int USER_ID ; 
	public java.sql.Statement  stmt  ; 
	
	public data () {
		
		DBurl = "jdbc:mysql://localhost/aqar_db" ; 
		DBpass="" ; 
		DBuser="root" ; 
		Random rand = new Random();
		 USER_ID = rand.nextInt(5000000);
		
	}

	
public 	void AddnewUser(String user , String pass) {
	
	// @SuppressWarnings("rawtypes")
	
	try {
		
	Class.forName("com.mysql.jdbc.Driver") ; 
	//Class<?> c = Class.forName("com.mysql.jdbc.Drive");
	 Connection connect = DriverManager.getConnection(DBurl, DBuser , DBpass);
	 
	 stmt = connect.createStatement() ; 
	 
	 ResultSet rst = stmt.executeQuery("select * from aqar_db.users"); 

	 writeResultSet(rst); 
	 
	 PreparedStatement pst = connect.prepareStatement("insert into  `aqar_db`.`users` values (?, ?, ?, ?, ? , ?, ? , ?)");
	 
	 pst.setInt(1, USER_ID);
	 pst.setString(2, user);
	 pst.setString(3, pass);
	 pst.setString(4, "firstname");
	 pst.setString(5, "secoundname");
	 pst.setString(6, "address");
	 pst.setString(7, "personal_pic"); 
	 pst.setString(8, "phone_number"); 

	 pst.executeUpdate();
	 
	 
	// java.sql.Statement statement = connect.createStatement();
	} 
	 
	catch (SQLException | ClassNotFoundException e) {
		
		 System.out.println (e.getMessage()) ; 
	}
	 
	
	
}

private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
        // It is possible to get the columns via name
        // also possible to get the columns via the column number
        // which starts at 1
        // e.g. resultSet.getSTring(2);
        String user = resultSet.getString("username");
        String password = resultSet.getString("password");
  
        System.out.println("User: " + user);
        System.out.println("Website: " + password);

    }
}
	
	
public String login (String user , String pass) {
	
	// get the data from Db where user==user and password ==pass
	// if ok return loggedIN 
	
	return "loggedIN" ;
	//return "Error" ;
	
	
}	

}
