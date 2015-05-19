package de.SurvivalGames.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 19.05.2015
 * Time: 16:45:20
 */

public class MySQLRanging {
	
	static HashMap<Integer, String> rang = new HashMap<Integer, String>();
	
	public static int topplayer1x;
	public static int topplayer1y;
	public static int topplayer1z;
	public static int topplayer2x;
	public static int topplayer2y;
	public static int topplayer2z;
	public static int topplayer3x;
	public static int topplayer3y;
	public static int topplayer3z;
	public static int topplayer4x;
	public static int topplayer4y;
	public static int topplayer4z;
	public static int topplayer5x;
	public static int topplayer5y;
	public static int topplayer5z;
	
	public static void set() {
	
		ResultSet rs = MySQL.getResult("SELECT playername FROM `SurvivalGames` ORDER BY kills DESC LIMIT 5");
		
		int in = 0;
		
		try {
			while(rs.next()) {
				in++;
				rang.put(in, rs.getString("playername"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Location loc1 = new Location(Bukkit.getWorld("world"), topplayer1x, topplayer1y, topplayer1z);
		Location loc2 = new Location(Bukkit.getWorld("world"), topplayer2x, topplayer2y, topplayer2z);
		Location loc3 = new Location(Bukkit.getWorld("world"), topplayer3x, topplayer3y, topplayer3z);
		Location loc4 = new Location(Bukkit.getWorld("world"), topplayer4x, topplayer4y, topplayer4z);
		Location loc5 = new Location(Bukkit.getWorld("world"), topplayer5x, topplayer5y, topplayer5z);
		
		List<Location> LOC = new ArrayList<Location>();
		LOC.add(loc1);
		LOC.add(loc2);
		LOC.add(loc3);
		LOC.add(loc4);
		LOC.add(loc5);
		
		for(int i = 0; i < LOC.size(); i++) {
			int id = i+1;
			
			LOC.get(i).getBlock().setType(Material.SKULL);
			Skull s = (Skull) LOC.get(i).getBlock().getState();
			s.setSkullType(SkullType.PLAYER);
			s.setOwner(rang.get(id));
			s.update();
			
			Location newloc = new Location(LOC.get(i).getWorld(), LOC.get(i).getX(), LOC.get(i).getY() -1, LOC.get(i).getZ());
			
			if(newloc.getBlock().getState() instanceof Sign) {
				BlockState b = newloc.getBlock().getState();
				Sign S = (Sign) b;
				
				try {
					S.setLine(0, "Platz #" + id);
					S.setLine(1, rang.get(id));
					S.setLine(2, SGManager.getKills(rang.get(id)) + " Kills");
					S.setLine(3, SGManager.getPoints(rang.get(id)) + " Punkte");
					S.update();
				} catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
