package de.SurvivalGames.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.SurvivalGames.main.SurvivalGames;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 19.05.2015
 * Time: 16:45:20
 */

public class FileManager {

	// Config File
	public static File getConfigFile() {
		return new File(SurvivalGames.getInstance().getDataFolder(), "config.yml");
	}
	public static FileConfiguration getConfigFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getConfigFile());
	}
	
	// MySQL File
	public static File getMySQLFile() {
		return new File(SurvivalGames.getInstance().getDataFolder(), "mysql.yml");
	}
	public static FileConfiguration getMySQLFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getMySQLFile());
	}
	
	// Config File setup
	public static void setDefaultConfig() {
		FileConfiguration cfg = getConfigFileConfiguration();
		cfg.options().copyDefaults(true);
		cfg.addDefault("prefix", "&7[&6SurvivalGames&7] ");
		cfg.addDefault("topplayer.1.x", "0");
		cfg.addDefault("topplayer.1.y", "0");
		cfg.addDefault("topplayer.1.z", "0");
		cfg.addDefault("topplayer.2.x", "0");
		cfg.addDefault("topplayer.2.y", "0");
		cfg.addDefault("topplayer.2.z", "0");
		cfg.addDefault("topplayer.3.x", "0");
		cfg.addDefault("topplayer.3.y", "0");
		cfg.addDefault("topplayer.3.z", "0");
		cfg.addDefault("topplayer.4.x", "0");
		cfg.addDefault("topplayer.4.y", "0");
		cfg.addDefault("topplayer.4.z", "0");
		cfg.addDefault("topplayer.5.x", "0");
		cfg.addDefault("topplayer.5.y", "0");
		cfg.addDefault("topplayer.5.z", "0");
		try {
			cfg.save(getConfigFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readConfig() {
		FileConfiguration cfg = getConfigFileConfiguration();
		SurvivalGames.getInstance().prefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("prefix") + "§r ");
		MySQLRanging.topplayer1x = cfg.getInt("topplayer.1.x");
		MySQLRanging.topplayer1y = cfg.getInt("topplayer.1.y");
		MySQLRanging.topplayer1z = cfg.getInt("topplayer.1.z");
		MySQLRanging.topplayer2x = cfg.getInt("topplayer.2.x");
		MySQLRanging.topplayer2y = cfg.getInt("topplayer.2.y");
		MySQLRanging.topplayer2z = cfg.getInt("topplayer.2.z");
		MySQLRanging.topplayer3x = cfg.getInt("topplayer.3.x");
		MySQLRanging.topplayer3y = cfg.getInt("topplayer.3.y");
		MySQLRanging.topplayer3z = cfg.getInt("topplayer.3.z");
		MySQLRanging.topplayer4x = cfg.getInt("topplayer.4.x");
		MySQLRanging.topplayer4y = cfg.getInt("topplayer.4.y");
		MySQLRanging.topplayer4z = cfg.getInt("topplayer.4.z");
		MySQLRanging.topplayer5x = cfg.getInt("topplayer.5.x");
		MySQLRanging.topplayer5y = cfg.getInt("topplayer.5.y");
		MySQLRanging.topplayer5z = cfg.getInt("topplayer.5.z");
	}
	
	//MySQL File setup
	public static void setDefaultMySQL() {
		FileConfiguration cfg = getMySQLFileConfiguration();
		cfg.options().copyDefaults(true);
		cfg.addDefault("username", "root");
		cfg.addDefault("passwort", "");
		cfg.addDefault("host", "localhost");
		cfg.addDefault("port", "3306");
		cfg.addDefault("database",  "minecraft_sg");
		try {
			cfg.save(getMySQLFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readMySQL() {
		FileConfiguration cfg = getMySQLFileConfiguration();
		MySQL.username = cfg.getString("username");
		MySQL.password = cfg.getString("passwort");
		MySQL.host = cfg.getString("host");
		MySQL.port = cfg.getString("port");
		MySQL.database = cfg.getString("database");
	}
	
	// Setup all Configs
	public static void setupConfigs() {
		FileManager.setDefaultConfig();
		FileManager.readConfig();
		FileManager.setDefaultMySQL();
		FileManager.readMySQL();
	}
	
}
