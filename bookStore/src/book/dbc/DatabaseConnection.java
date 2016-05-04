package book.dbc ;
import java.sql.*;
//import java.sql.Connection ;

//import java.sql.DriverManager ;
public class DatabaseConnection {
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
	public static final String DBURL = "jdbc:sqlserver://localhost:1433;databasename=mldn" ;
	public static final String DBUSER = "sa" ;
	public static final String DBPASSWORD = "123456" ;
	private Connection conn ;
	public DatabaseConnection() throws Exception {
		Class.forName(DBDRIVER) ;
		this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
	}
	public Connection getConnection(){
		return this.conn ;
	}
	public void close() throws Exception {
		if(this.conn != null){
			try{
				this.conn.close() ;
			}catch(Exception e){
				throw e ;
			}
		}
	}
}