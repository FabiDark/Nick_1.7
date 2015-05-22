package de.SurvivalGames.Listener;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import de.SurvivalGames.main.SurvivalGames;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 19.05.2015
 * Time: 16:45:20
 */

public class DeathChest implements Listener {

	@SuppressWarnings("unused")
	private SurvivalGames plugin;

	public DeathChest(SurvivalGames survivalgames) {
		this.plugin = survivalgames;
	}
	
	public static HashMap<Block, Inventory> DeathChest = new HashMap<Block, Inventory>();
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		
		Player p = e.getEntity();
		
		Block blockchest = p.getWorld().getBlockAt(p.getLocation().add(0,0.5,0));
		blockchest.setType(Material.CHEST);
		
		Inventory inv = Bukkit.createInventory(null, 36, "§7" + p.getName() + "§7s Inventar");
		 
		DeathChest.put(blockchest, inv);
		
		e.getDrops().clear();
	}
	
	@EventHandler
	public void onOpen(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType() == Material.CHEST) {
				Block block = e.getClickedBlock();
				
				for(Block blocks : DeathChest.keySet()) {
					if(blocks.getLocation().equals(block.getLocation())) {
						e.setCancelled(true);
						e.getPlayer().openInventory(DeathChest.get(blocks));
					}
				}
			}
		}
	}

}
