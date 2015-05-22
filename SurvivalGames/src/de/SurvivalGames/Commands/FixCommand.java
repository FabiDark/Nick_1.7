package de.SurvivalGames.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.SurvivalGames.main.SurvivalGames;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 22.05.2015
 * Time: 15:37:48
 */

public class FixCommand implements CommandExecutor {
	
	private SurvivalGames plugin;
	
	public FixCommand(SurvivalGames plugin) {
		this.plugin = plugin;
	}
	
	@Override
    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args){
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDu kannst diesen Befehl nur Ingame nutzen!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(args.length == 0) {
			fixPlayer(p);
		} else if(args.length >= 1) {
			String name = args[1];
			if(p.hasPermission("system.admin")) {
				if(Bukkit.getPlayer(name) != null) {
					Player target = Bukkit.getPlayer(name);
					p.sendMessage(plugin.prefix + "§cDu hast §6" + target.getName() + " §cgefixt!");
				} else {
					p.sendMessage(plugin.prefix + "§cDer Spieler ist nicht Online!");
				}
			} else {
				p.sendMessage(plugin.prefix + "§cDu hast keine Berechtigung!");
			}
		}
		
		return true;
		
	}
   
   
   
    public void fixPlayer(Player player){
           
            player.sendMessage(plugin.prefix + "§cDu wurdest gefixt!");
            player.teleport(player.getLocation().add(0,1.5,0));
            refreshPlayer(player);
    }
   
    @SuppressWarnings("deprecation")
	public void refreshPlayer(final Player player){
            for(Player players : Bukkit.getOnlinePlayers()){
                    players.hidePlayer(player);
            }
            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                   
                    public void run() {
                            for(Player players : Bukkit.getOnlinePlayers()){
                                    players.showPlayer(player);
                            }
                           
                    }
            }, 2);
    }
}
