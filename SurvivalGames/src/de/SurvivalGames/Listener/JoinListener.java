package de.SurvivalGames.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.Nick.Nick.Nick;
import de.SurvivalGames.main.SurvivalGames;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 19.05.2015
 * Time: 16:45:20
 */

public class JoinListener implements Listener {
	
	private SurvivalGames plugin;
	
	public JoinListener(SurvivalGames survivalgames) {
		this.plugin = survivalgames;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		if(p.hasPermission("system.nick")) {
			Nick.setNick(p);
		}
		
		e.setJoinMessage(plugin.prefix + p.getDisplayName() + " §6ist dem Spiel beigetreten!");
		
	}
}
