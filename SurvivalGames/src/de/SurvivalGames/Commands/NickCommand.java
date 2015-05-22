package de.SurvivalGames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Nick.Nick.Nick;
import de.Nick.main.Main;
import de.Nick.util.NickManager;
import de.SurvivalGames.main.SurvivalGames;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 21.05.2015
 * Time: 17:43:13
 */
public class NickCommand implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private SurvivalGames plugin;
	
	public NickCommand(SurvivalGames plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDu kannst diesen Befehl nur Ingame nutzen!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(p.hasPermission("system.nick")) {
			if(NickManager.isInMySQL(p.getUniqueId().toString())) {
				Nick.removeNick(p);
				p.sendMessage(Main.getInstance().prefix + "§cDu hast dein Nickname entfernt!");
			} else {
				p.sendMessage(Main.getInstance().prefix + "§cDu kannst dir keinen neuen Nickname geben lassen!");
			}
		} else {
			p.sendMessage(Main.getInstance().prefix + Main.getInstance().noperm);
		}
		
		return true;
	}

}
