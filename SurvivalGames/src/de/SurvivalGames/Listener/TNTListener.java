package de.SurvivalGames.Listener;

import org.bukkit.Material;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import de.SurvivalGames.main.SurvivalGames;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 22.05.2015
 * Time: 15:32:08
 */

public class TNTListener implements Listener {
	
    @SuppressWarnings("unused")
	private SurvivalGames plugin;
    
	public TNTListener(SurvivalGames plugin){
            this.plugin = plugin;
    }

   
    @EventHandler
    public void onBuild(BlockPlaceEvent event){
            if(event.getBlock().getType() == Material.TNT){
                    event.getBlock().setType(Material.AIR);
                    TNTPrimed tnt = (TNTPrimed)event.getBlock().getWorld().spawn(event.getBlock().getLocation(),TNTPrimed.class);
                    tnt.setFuseTicks(40);
            }
    }
   
    @EventHandler
    public void onEntityExplore(EntityExplodeEvent event){
            event.blockList().clear();
    }
	
}
