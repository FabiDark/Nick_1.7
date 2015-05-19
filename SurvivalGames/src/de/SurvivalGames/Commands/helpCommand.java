package de.SurvivalGames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.SurvivalGames.Methoden.HelpMethoden;
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
			
			HelpMethoden.HelpChat(p);
			
		}
		
		if(args.length >= 1) {
			
			HelpMethoden.HelpChat(p);
			
		}
		
		return true;
	}

}
