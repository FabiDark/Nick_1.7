package de.Nick.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 19.05.2015
 * Time: 16:45:20
 */

public class MySQL {
	
	public static String host;
	public static String password;
	public static String username;
	public static String port;
	public static String database;
	public static Connection con;
	
	
	private static ExecutorService executor;
	
	static {
		executor = Executors.newCachedThreadPool();
	}
	
	public static void connect() {
		if(!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				setupNick();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect() {
		if(isConnected()) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isConnected() {
		try {
			return con !=null && con.isValid(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Setup MySQL
		private static void setupNick() {
			if(isConnected()) {
				executor.execute(new Runnable() {
					@Override
					public void run() {
						try {
							String qry = "CREATE TABLE IF NOT EXISTS `Nick` (uuid TEXT, playername TEXT, Nickname TEXT)";
							PreparedStatement stmt;
							stmt = con.prepareStatement(qry);
							stmt.executeUpdate();
							stmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
		
		// MySQL update
		public static void update(final String query) {
			if(isConnected()) {
				executor.execute(new Runnable() {
					@Override
					public void run() {
						try {
							PreparedStatement stmt;
							stmt = con.prepareStatement(query);
							stmt.executeUpdate();
							stmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
		
		// MySQL result
		public static ResultSet getResult(String query) {
			if(isConnected()) {
				try {
					return con.prepareStatement(query).executeQuery();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	
}
