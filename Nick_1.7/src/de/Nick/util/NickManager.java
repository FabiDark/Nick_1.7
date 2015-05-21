package de.Nick.util;

import java.sql.ResultSet;
import java.sql.SQLException;


public class NickManager {
	
	public static boolean isInMySQL(String uuid) {
		ResultSet rs = MySQL.getResult("SELECT uuid FROM `Nick` WHERE uuid = '" + uuid + "'");
		try {
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void addtoMySQL(String uuid, String playername, String Nickname) {
		if(!isInMySQL(uuid)) {
			MySQL.update("INSERT INTO `Nick` (uuid, playername, nickname) VALUES ('" + uuid + "', '" + playername + "', '" + Nickname + "')");
		}
	}

	public static void deletefromMySQL(String uuid) {
		if(isInMySQL(uuid)) {
			MySQL.update("DELETE FROM `Nick` WHERE uuid = '" + uuid + "'");
		}
	}
	
	public static String getName(String uuid) {
		if(isInMySQL(uuid)) {
			ResultSet rs = MySQL.getResult("SELECT * FROM `Nick` WHERE uuid = '" + uuid + "'");
			try {
				while(rs.next()) {
					return rs.getString("playername");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
