package de.SurvivalGames.Listener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import de.SurvivalGames.main.SurvivalGames;

/**
 * Project: SurvivalGames
 * Created by FabiDark
 * Date: 22.05.2015
 * Time: 15:19:14
 */

public class LoginListener implements Listener {
	
	public static SurvivalGames plugin;
    
    @SuppressWarnings("static-access")
	public LoginListener(SurvivalGames plugin){
            this.plugin = plugin;
    }
   
   
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onLogin(PlayerLoginEvent event){
            Player player = (Player)event.getPlayer();
           
            if(player.hasPermission("system.vip")){
                    if(Bukkit.getOfflinePlayers().length >= Bukkit.getMaxPlayers()){
                            for(Player players : Bukkit.getOnlinePlayers()){
                                    if(!players.hasPermission("system.vip")){
//                                          players.kickPlayer("Du wurdest gekickt!");
                                    		joinServer(players, "lobby", plugin.prefix + "§cUm ein VIP oder Team-Mitglied platz zu machen wurdest du gekickt!");
                                            event.allow();
                                            return;
                                    }
                            }
                    event.disallow(Result.KICK_OTHER, "§cDiese Lobby ist voll mit VIP oder Team-Mitgliedern!");
                    }
            }else{
                    event.disallow(Result.KICK_FULL, "§cDiese Lobby ist voll! Kaufe dir Premium um das Spiel trotzdem beizutreten!");
            }
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
