package de.SurvivalGames.Commands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.SurvivalGames.main.SurvivalGames;
import de.SurvivalGames.util.MySQL;
import de.SurvivalGames.util.SGManager;
import de.SurvivalGames.util.UUIDFetcher;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 19.05.2015
 * Time: 16:45:20
 */

public class StatsCommand implements CommandExecutor {

	private SurvivalGames plugin;

	public StatsCommand(SurvivalGames survivalgames) {
		this.plugin = survivalgames;
	}

	public double kd(int kills, int deaths) {
		return (double)kills / (double)deaths;
	}
	
	public int getrank(Player p) {
		
		HashMap<String, Integer> rang = new HashMap<String, Integer>();
		
		ResultSet rs = MySQL.getResult("SELECT playername FROM `SurvivalGames` ORDER BY kills");
		
		int in = 0;
		
		try {
			while(rs.next()) {
				in++;
				rang.put(rs.getString("playername"), in);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rang.get(p.getName());
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(args.length == 0) {
			p.sendMessage("§8[]===[ §6SurvivalGames §8┃	§cStats §8]===[]");
			p.sendMessage("§6Spieler: §c" + p);
			p.sendMessage("§6Kills: §c" + SGManager.getKills(p.getUniqueId().toString()));
			p.sendMessage("§6KDR: §c" + kd(SGManager.getKills(p.getUniqueId().toString()), SGManager.getDeaths(p.getUniqueId().toString())));
			p.sendMessage("§6Rank: §c" + getrank(p));
			p.sendMessage("§6Deathmatch: §c" + SGManager.getDeathmatch(p.getUniqueId().toString()));
			p.sendMessage("§6Wins: §c" + SGManager.getWins(p.getUniqueId().toString()));
			p.sendMessage("§8[]===[ §6SurvivalGames §8┃	§cStats §8]===[]");
		}
		
		if(args.length == 1) {
			String playername = args[0];
			
			try {
				if(SGManager.isInMySQL(UUIDFetcher.getUUIDOf(playername).toString())) {
					p.sendMessage("§8[]===[ §6SurvivalGames §8┃	§cStats §8]===[]");
					p.sendMessage("§6Spieler: §c" + playername);
					p.sendMessage("§6Kills: §c" + SGManager.getKills(UUIDFetcher.getUUIDOf(playername).toString()));
					p.sendMessage("§6KDR: §c" + kd(SGManager.getKills(UUIDFetcher.getUUIDOf(playername).toString()), SGManager.getDeaths(UUIDFetcher.getUUIDOf(playername).toString())));
					p.sendMessage("§6Rank: §c" + getrank(p));
					p.sendMessage("§6Deathmatch: §c" + SGManager.getDeathmatch(UUIDFetcher.getUUIDOf(playername).toString()));
					p.sendMessage("§6Wins: §c" + SGManager.getWins(UUIDFetcher.getUUIDOf(playername).toString()));
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
