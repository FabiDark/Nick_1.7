package de.SurvivalGames.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 19.05.2015
 * Time: 16:45:20
 */

public class SGManager {
	
	public static boolean isInMySQL(String uuid) {
		ResultSet rs = MySQL.getResult("SELECT uuid FROM `SurvivalGames` WHERE playername = '" + uuid + "'");
		try {
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void addtoMySQL(String uuid, String playername, int kills, int deaths, int deathmatch, int wins, int punkte) {
		if(!isInMySQL(uuid)) {
			MySQL.update("INSERT INTO `SurvivalGames` (uuid, playername, kills, deaths, deathmatch, wins, punkte) VALUES ('" + uuid + "', '" + playername + "', '" + kills + "', '" + deaths + "', '" + deathmatch + "', '" + wins + "', '" + punkte + "')");
		}
	}
	
	public static void deletefromMySQL(String uuid) {
		if(isInMySQL(uuid)) {
			MySQL.update("DELETE FROM `SurvialGames` WHERE uuid = '" + uuid +"'");
		}
	}
	
	public static void setDeathmatch(String uuid, int deathmatch) {
		MySQL.update("UPDATE `SurvivalGames` SET deathmatch = '" + deathmatch + "' WHERE uuid = '" + uuid + "'");
	}
	
	public static void setWins(String uuid, int wins) {
		MySQL.update("UPDATE `SurvivalGames` SET wins = '" + wins + "' WHERE uuid = '" + uuid + "'");
	}
	
	public static void setKills(String uuid, int kills) {
		MySQL.update("UPDATE `SurvivalGames` SET kills = '" + kills + "' WHERE uuid = '" + uuid + "'");
	}
	
	public static void setDeaths(String uuid, int deaths) {
		MySQL.update("UPDATE `SurvivalGames` SET deaths = '" + deaths + "' WHERE uuid = '" + uuid + "'");
	}
	
	public static void setPoints(String uuid, int punkte) {
		MySQL.update("UPDATE `SurvivalGames` SET punkte = '" + punkte + "' WHERE uuid = '" + uuid + "'");
	}
	
	public static int getKills(String uuid) {
		if(isInMySQL(uuid)) {
			ResultSet rs = MySQL.getResult("SELECT * FROM `SurvivalGames` WHERE uuid = '" + uuid + "'");
			try {
				while(rs.next()) {
					return rs.getInt("kills");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static int getDeaths(String uuid) {
		if(isInMySQL(uuid)) {
			ResultSet rs = MySQL.getResult("SELECT * FROM `SurvivalGames` WHERE uuid = '" + uuid + "'");
			try {
				while(rs.next()) {
					return rs.getInt("deaths");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static int getDeathmatch(String uuid) {
		if(isInMySQL(uuid)) {
			ResultSet rs = MySQL.getResult("SELECT * FROM `SurvivalGames` WHERE uuid = '" + uuid + "'");
			try {
				while(rs.next()) {
					return rs.getInt("deathmatch");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static int getWins(String uuid) {
		if(isInMySQL(uuid)) {
			ResultSet rs = MySQL.getResult("SELECT * FROM `SurvivalGames` WHERE uuid = '" + uuid + "'");
			try {
				while(rs.next()) {
					return rs.getInt("wins");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static int getPoints(String uuid) {
		if(isInMySQL(uuid)) {
			ResultSet rs = MySQL.getResult("SELECT * FROM `SurvivalGames` WHERE uuid = '" + uuid + "'");
			try {
				while(rs.next()) {
					return rs.getInt("punkte");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
