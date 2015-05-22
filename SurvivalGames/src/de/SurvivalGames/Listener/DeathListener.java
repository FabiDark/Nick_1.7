package de.SurvivalGames.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.SurvivalGames.main.SurvivalGames;
import de.SurvivalGames.util.MySQLRanging;
import de.SurvivalGames.util.SGManager;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 19.05.2015
 * Time: 16:45:20
 */

public class DeathListener implements Listener {
	
	private SurvivalGames plugin;
	
	public DeathListener(SurvivalGames survivalgames) {
		this.plugin = survivalgames;
	}
	
	@EventHandler
	public void ondeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		
		MySQLRanging.set();
		
		if(p instanceof Player) {
			if(k instanceof Player) {
				SGManager.setPoints(k.getUniqueId().toString(), 2);
				SGManager.setKills(k.getUniqueId().toString(), 1);
				
				SGManager.setDeaths(p.getUniqueId().toString(), 1);
				if(!(SGManager.getPoints(p.getUniqueId().toString()) == 0) && !(SGManager.getPoints(p.getUniqueId().toString()) == 1)) {
					SGManager.setPoints(p.getUniqueId().toString(), -2);
				}
				
				if(!plugin.death.contains(p.getName())) {
					plugin.death.add(p.getName());
				}
			}
		}
	}
	
}
