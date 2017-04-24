package net.poweredbyscience.cute;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;


public class Cute extends JavaPlugin implements Listener {

    public HashMap<String,String> commands = new HashMap<>();

    public static Cute instance;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        loadConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("cute").setExecutor(new CuteCuteCommand(this));
    }

    public void loadConfig() {
        for(String s : getConfig().getConfigurationSection("CustomCommands").getKeys(false)) {
            commands.put(s, getConfig().getString("CustomCommands."+s+".query")+":"+getConfig().getString("CustomCommands."+s+".permission"));
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent ev) { //sue me
        String command = ev.getMessage().replace("/","");
        if (commands.containsKey(command) && ev.getPlayer().hasPermission(commands.get(command).split(":")[1])) {
            Dispenser.dispenseCuteness(AnimalRescue.getCuteShit(String.join("+", commands.get(command).split(":")[0])), ev.getPlayer());
            ev.setCancelled(true);
        }
    }


    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            System.out.println(AnimalRescue.getCuteShit("cute"));
        }
    }
}
