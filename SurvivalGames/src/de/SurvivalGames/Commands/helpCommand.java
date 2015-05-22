package de.SurvivalGames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.SurvivalGames.main.SurvivalGames;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 19.05.2015
 * Time: 16:45:20
 */

public class helpCommand implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private SurvivalGames plugin;
	
	public helpCommand(SurvivalGames survivalgames) {
		this.plugin = survivalgames;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		
		if(args.length == 0) {
			p.sendMessage("§8[]===[ §6SurvivalGames §8]===[]");
			p.sendMessage("§6Hilfe: §c/help");
			p.sendMessage("§cPlugin coded by FabiDark");
			p.sendMessage("§8[]===[ §6SurvivalGames §8]===[]");
		}
		
		if(args.length >= 1) {
			p.sendMessage("§8[]===[ §6SurvivalGames §8]===[]");
			p.sendMessage("§6Hilfe: §c/help");
			p.sendMessage("§6Stats: §c/stats <Name>");
			p.sendMessage("§8[]===[ §6SurvivalGames §8]===[]");
		}
		
		return true;
	}

}
