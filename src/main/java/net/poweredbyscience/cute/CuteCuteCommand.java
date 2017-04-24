package net.poweredbyscience.cute;

import net.poweredbyscience.cute.AnimalRescue;
import net.poweredbyscience.cute.Cute;
import net.poweredbyscience.cute.Dispenser;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Lax on 4/16/2017.
 */
public class CuteCuteCommand implements CommandExecutor {
    public CuteCuteCommand(Cute cute) {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("cute.search")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Usage: &c/cute query"));
            }
            if (args.length >= 1) {
                Dispenser.dispenseCuteness(AnimalRescue.getCuteShit(String.join("+", args)), sender);
            }
        }
        return false;
    }

}
