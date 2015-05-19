package de.SurvivalGames.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.SurvivalGames.Commands.StatsCommand;
import de.SurvivalGames.Commands.helpCommand;
import de.SurvivalGames.Listener.ChestListener;
import de.SurvivalGames.Listener.DeathChest;
import de.SurvivalGames.Listener.DeathListener;
import de.SurvivalGames.util.FileManager;
import de.SurvivalGames.util.MySQL;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 19.05.2015
 * Time: 16:45:20
 */

public class SurvivalGames extends JavaPlugin {
	
	public static SurvivalGames instance;
	
	public String prefix;
	
	public HashMap<Location, Inventory> chests = new HashMap<Location, Inventory>();
	
	public ArrayList<String> spectator = new ArrayList<String>();
	public ArrayList<String> life = new ArrayList<String>();
	public ArrayList<String> death = new ArrayList<String>();
	public ArrayList<String> lobby = new ArrayList<String>();
	
	public static GameStats status = GameStats.WAITING;
	
	@Override
	public void onLoad() {
		SurvivalGames.instance = this;
	}
	
	@Override
	public void onEnable() {
		FileManager.setupConfigs();
		MySQL.connect();
		Bukkit.getConsoleSender().sendMessage(prefix + "SurvivalGames: §2successfully!");
		Bukkit.getConsoleSender().sendMessage(prefix + "MySQL: " + (MySQL.con == null ? "§4error! must fix to enjoy this plugin! plugin will be disabled!" : "§2successfully!"));
		if (MySQL.con == null)
	    {
	      Plugin plugin = Bukkit.getPluginManager().getPlugin("SurvivalGames");
	      Bukkit.getPluginManager().disablePlugin(plugin);
	      Bukkit.getConsoleSender().sendMessage(prefix + "§4§lDas Plugin wurde deaktiviert, weil keine MySQL verbindung aufgebaut worden konnte!");
	    }
	}
	
	@Override
	public void onDisable() {
		MySQL.disconnect();
	}
	
	public void registerCommands() {
		getCommand("stats").setExecutor(new StatsCommand(this));
		getCommand("help").setExecutor(new helpCommand(this));
	}
	
	public void registerListener() {
		new ChestListener(this);
		new DeathChest(this);
		new DeathListener(this);
	}

	public static SurvivalGames getInstance() {
		return instance;
	}
	
}
