package de.SurvivalGames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.SurvivalGames.main.SurvivalGames;
import de.SurvivalGames.util.SGManager;
import de.SurvivalGames.util.UUIDFetcher;

public class StatsCommand implements CommandExecutor {

	private SurvivalGames plugin;

	public StatsCommand(SurvivalGames survivalgames) {
		this.plugin = survivalgames;
	}

	public double kd(int kills, int deaths) {
		return (double)kills / (double)deaths;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(args.length == 0) {
			p.sendMessage("§8[]===[ §6SurvivalGames §8┃	§cStats §8]===[]");
			p.sendMessage("§6Spieler: §c§l" + p);
			p.sendMessage("§6Kills: §c§l" + SGManager.getKills(p.getUniqueId().toString()));
			p.sendMessage("§6KDR: §c§l" + kd(SGManager.getKills(p.getUniqueId().toString()), SGManager.getDeaths(p.getUniqueId().toString())));
			p.sendMessage("§6Deathmatch: §c§l" + SGManager.getDeathmatch(p.getUniqueId().toString()));
			p.sendMessage("§6Wins: §c§l" + SGManager.getWins(p.getUniqueId().toString()));
			p.sendMessage("§8[]===[ §6SurvivalGames §8┃	§cStats §8]===[]");
		}
		
		if(args.length == 1) {
			String playername = args[0];
			
			try {
				if(SGManager.isInMySQL(UUIDFetcher.getUUIDOf(playername).toString())) {
					p.sendMessage("§8[]===[ §6SurvivalGames §8┃	§cStats §8]===[]");
					p.sendMessage("§6Spieler: §c§l" + playername);
					p.sendMessage("§6Kills: §c§l" + SGManager.getKills(UUIDFetcher.getUUIDOf(playername).toString()));
					p.sendMessage("§6KDR: §c§l" + kd(SGManager.getKills(UUIDFetcher.getUUIDOf(playername).toString()), SGManager.getDeaths(UUIDFetcher.getUUIDOf(playername).toString())));
					p.sendMessage("§6Deathmatch: §c§l" + SGManager.getDeathmatch(UUIDFetcher.getUUIDOf(playername).toString()));
					p.sendMessage("§6Wins: §c§l" + SGManager.getWins(UUIDFetcher.getUUIDOf(playername).toString()));
					p.sendMessage("§8[]===[ §6SurvivalGames §8┃	§cStats §8]===[]");
				} else {
					p.sendMessage(plugin.prefix + "§6Der Spieler wurde nicht gefunden!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
