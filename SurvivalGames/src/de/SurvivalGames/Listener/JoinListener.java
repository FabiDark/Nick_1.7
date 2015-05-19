package de.SurvivalGames.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.SurvivalGames.main.SurvivalGames;

public class JoinListener implements Listener {
	
	private SurvivalGames plugin;
	
	public JoinListener(SurvivalGames survivalgames) {
		this.plugin = survivalgames;
		plugin.getServer().getPluginManager().registerEvents(this, survivalgames);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		e.setJoinMessage(plugin.prefix + p.getDisplayName() + " §6ist dem Spiel beigetreten!");
		
		
		
	}
}
