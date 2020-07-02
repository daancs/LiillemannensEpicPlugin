package me.Liillemannen.BukkitServer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("spawn")){
            if (!(sender instanceof Player)) {
                sender.sendMessage("no spawn for consolel ol");
                return true;
            }



        }
        return false;
    }
}

