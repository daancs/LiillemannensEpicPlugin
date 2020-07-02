package me.Liillemannen.BukkitServer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class PluginConfig {
    public FileConfiguration config;
    Main main;

    public PluginConfig(Main _main) {
        main = _main;
        config = main.getConfig();
    }

    public void setPercentage(int percentage, Player sender) {
        config.set("percentage", percentage);

        main.saveConfig();

        sender.sendMessage(ChatColor.GREEN + "Sleep percentage has been set!");
    }

    public void setSpawn(Player sender) {
        config.set("spawn.world", sender.getWorld().getName());
        config.set("spawn.x", sender.getLocation().getX());
        config.set("spawn.y", sender.getLocation().getY());
        config.set("spawn.z", sender.getLocation().getZ());
        config.set("spawn.pitch", sender.getLocation().getPitch());
        config.set("spawn.yaw", sender.getLocation().getYaw());

        main.saveConfig();

        sender.sendMessage(ChatColor.GREEN + "Spawn has been set.");
    }
}
