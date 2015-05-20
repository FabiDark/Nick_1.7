package de.legiamc.mysqlbansystem.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import de.legiamc.mysqlbansystem.Util.BanManager;

public class Listener_PlayerLoginEvent implements Listener {

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		Player p = event.getPlayer();
		if(BanManager.isBanned(p.getUniqueId().toString())) {
			long current = System.currentTimeMillis();
			long end = BanManager.getEnd(p.getUniqueId().toString());
			if(current < end | end == -1) {
				event.disallow(Result.KICK_BANNED, 
						"§cDu wurdes von dem Server gebannt!" +
						"\n" +
						"\n" +
						"§3Grund: §e" + BanManager.getReason(p.getUniqueId().toString()) +
						"\n" +
						"\n" +
						"§3Verbleibende Zeit: §e" + BanManager.getRemaningTime(p.getUniqueId().toString()));
			}
		}
 	}
	
}
