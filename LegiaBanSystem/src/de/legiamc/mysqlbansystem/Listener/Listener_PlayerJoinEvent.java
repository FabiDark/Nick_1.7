package de.legiamc.mysqlbansystem.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.legiamc.mysqlbansystem.Util.BanManager;

public class Listener_PlayerJoinEvent implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if(BanManager.isBanned(p.getUniqueId().toString())) {
			BanManager.unban(p.getUniqueId().toString());
		}
	}
	
}
