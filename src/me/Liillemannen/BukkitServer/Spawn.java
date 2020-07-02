package me.Liillemannen.BukkitServer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    Main main;

    public Spawn(Main _main) {
        main = _main;
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("spawn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("no spawn for consolel ol");
                return true;
            }
            Player player = (Player) sender;
            if (main.pluginConfig.config.get("spawn") != null) {
                player.teleport(new Location(
                        Bukkit.getWorld(main.pluginConfig.config.getString("spawn.world")),
                        main.pluginConfig.config.getInt("spawn.x"),
                        main.pluginConfig.config.getInt("spawn.y"),
                        main.pluginConfig.config.getInt("spawn.z"),
                        (float) main.pluginConfig.config.getDouble("spawn.yaw"),
                        (float) main.pluginConfig.config.getDouble("spawn.pitch")
                ));
            }
        } else if (label.equalsIgnoreCase("setspawn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("bad console");
                return true;
            }

            main.pluginConfig.setSpawn((Player) sender);
        }
        return false;
    }
}

