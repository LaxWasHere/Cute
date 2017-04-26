package net.poweredbyscience.cute;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Lax on 4/16/2017.
 */
public class Dispenser {

    public static void dispenseCuteness(String url, CommandSender p) {
        for (String s : Cute.instance.getConfig().getStringList("format")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace("%link%", url)));
        }
    }
    
}
