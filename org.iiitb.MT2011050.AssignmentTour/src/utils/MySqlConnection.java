package utils;


import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	
	static Connection uniqueConn;
	
	/**
	 * This function loads the Driver class,
	 * Makes a connection using the RunTimeSettings
	 * 
	 * @return Connection that already is present or is made for the first time
	 */
	public static Connection getConnection(){
		
		if(uniqueConn ==null){
			
			try{
		    	/* 
		    	 * The code loads the driver class and get the Connection 
		    	 * */
				
				Class.forName("com.mysql.jdbc.Driver");
			    uniqueConn=DriverManager.getConnection(RunTimeSettings.url+RunTimeSettings.dbName,RunTimeSettings.dbUser,RunTimeSettings.dbPwd);
		    	
		    	
				}
			catch (Exception e) {
			
				e.printStackTrace();
			}
			
			return uniqueConn;
		}else{
			
			return uniqueConn;
			
		}
		
		
		
	}

}
