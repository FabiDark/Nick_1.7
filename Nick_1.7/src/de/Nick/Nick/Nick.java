package de.Nick.Nick;

import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;
import org.kitteh.tag.TagAPI;

import de.Nick.main.Main;
import de.Nick.util.NickManager;

public class Nick
  implements Listener, CommandExecutor
{

  public static void Nick(String name, Player p) {
    Main.getInstance().nick.get(name);
    Main.getInstance().nick.put(p.getName(), name);
    p.setPlayerListName("§a" + name);
    p.setDisplayName(name);
    TagAPI.refreshPlayer(p);
  }

public static void number(Player p) {
    Random r = new Random();
    int nickNumber = r.nextInt(30);

    if (nickNumber == 0) {
      String name = "DragonMaster02";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 1) {
      String name = "AnakinParker";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 2) {
      String name = "eruptor2012";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 3) {
      String name = "Skiller300";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 4) {
      String name = "Catcher108";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 5) {
      String name = "spedcrafter";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 6) {
      String name = "Fizzy_B";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 7) {
      String name = "Simi1412";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 8) {
      String name = "Akatoscho";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 9) {
      String name = "FexTool";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 10) {
      String name = "Apfelsaft200";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 11) {
      String name = "jomax01";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 12) {
      String name = "TimLet2004";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 13) {
      String name = "teogut";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 14) {
      String name = "LeigPlay";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 15) {
      String name = "levini123";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 16) {
      String name = "dolli2002";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 17) {
      String name = "PrinzVince";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 18) {
      String name = "RoomLP";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 19) {
      String name = "BloodDragonBoy";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 20) {
      String name = "Loewe9000";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 21) {
      String name = "ChrosbyHD";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 22) {
      String name = "DerEusebuis";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 23) {
      String name = "TomNickTom";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 24) {
      String name = "zilver2001";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 25) {
      String name = "VerzocktLP";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 26) {
      String name = "MrAppleLp";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 27) {
      String name = "Krebs777";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 28) {
      String name = "MrsPikach";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
    if (nickNumber == 29) {
      String name = "Starz___";
      NickManager.addtoMySQL(p.getUniqueId().toString(), p.getName(), name);
      Nick(name, p);
      p.sendMessage(Main.getInstance().prefix + "§3Dein Name ist nun: §6" + name);
    }
  }

  @EventHandler
  public void onNameTag(AsyncPlayerReceiveNameTagEvent e)
  {
    Player p = e.getNamedPlayer();
    if (Main.getInstance().nick.containsKey(p.getName()))
      e.setTag((String)Main.getInstance().nick.get(p.getName()));
  }

@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
	if(!(sender instanceof Player)) {
		sender.sendMessage("§cDu darfst diesen Befehl nur Ingame nutzen!");
		return true;
	}
	
	Player p = (Player)sender;
	
	if(args.length == 0) {
		if(p.hasPermission("system.youtuber")) {
			if(!NickManager.isInMySQL(p.getUniqueId().toString())) {
				number(p);
			} else {
				Main.getInstance().nick.remove(p.getName());
				Nick(NickManager.getName(p.getUniqueId().toString()), p);
				NickManager.deletefromMySQL(p.getUniqueId().toString());
				p.sendMessage(Main.getInstance().prefix + "§cDu hast deinen Nicknamen zurück gesetzt!");
			}
		} else {
			p.sendMessage(Main.getInstance().prefix + Main.getInstance().noperm);
		}
	} else if(args.length == 1) {
		if(args[0].equalsIgnoreCase("remove")) {
		} else {
			p.sendMessage(Main.getInstance().prefix + Main.getInstance().unknow);
		}
	} else {
		p.sendMessage(Main.getInstance().prefix + Main.getInstance().unknow);
	}
	
	return true;
}

public static void setNick(Player p) {
	
	if(!NickManager.isInMySQL(p.getUniqueId().toString())) {
		number(p);
	}
	
}

public static void removeNick(Player p) {
	
	if(NickManager.isInMySQL(p.getUniqueId().toString())) {
		if(Main.getInstance().nick.containsKey(p.getName())) {
			Main.getInstance().nick.remove(p.getName());
			Nick(NickManager.getName(p.getUniqueId().toString()), p);
			NickManager.deletefromMySQL(p.getUniqueId().toString());
			p.sendMessage(Main.getInstance().prefix + "§cDu hast deinen Nicknamen zurück gesetzt!");
		}
	}
	
}

}