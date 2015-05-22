package de.SurvivalGames.Commands;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.SurvivalGames.main.SurvivalGames;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 22.05.2015
 * Time: 15:48:16
 */
public class HubCommand implements CommandExecutor {
	
	private SurvivalGames plugin;
	
	public HubCommand(SurvivalGames plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDu kannst diesen Befehl nur Ingame nutzen!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(args.length == 0) {
			joinServer(p, "lobby", plugin.prefix + "§cConnecting to Lobby...");
		} else {
			p.sendMessage(plugin.prefix + "§cVerwendung: /hub");
		}
		
		return true;
	}
	
	private void joinServer(Player p, String servername, String message) {
		
		ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        
        try {
        	
        	out.writeUTF("Connect");
        	out.writeUTF(servername);
        	
        }catch (Exception ex) {
        }
        
        p.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
        p.sendMessage(message);
	}

}
