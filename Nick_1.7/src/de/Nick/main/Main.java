package de.Nick.main;

import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

import de.Nick.Nick.Nick;

public class Main extends JavaPlugin {
	
	public String prefix = "§8[§cNick§8] ";
	public String noperm = "";
	public String unknow = "§cUnbekannter Befehl";
	
	private static Main instance;
	
	public HashMap<String, String> nick = new HashMap<String, String>();
	
	@Override
	public void onLoad() {
		instance = this;
	}
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Nick(),this);
		getCommand("nick").setExecutor(new Nick());
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Main getInstance() {
		return instance;
	}
}
