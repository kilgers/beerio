package beerio;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
    	
    	//Read config from file and save in variables
    	String url = null;
    	String un = null;
    	String pw = null;
    	try {
        	BufferedReader br = new BufferedReader(new FileReader("dbConfig.txt"));
        	url = br.readLine();
        	un = br.readLine();
        	pw = br.readLine();
        	br.close();
    	}
        catch (IOException ioe) {
     	   ioe.printStackTrace();
            } 
    	
        config.setJdbcUrl(url);
        config.setUsername(un);
        config.setPassword(pw);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    private DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}