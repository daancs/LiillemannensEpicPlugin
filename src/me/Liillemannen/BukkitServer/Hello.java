package me.Liillemannen.BukkitServer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hello implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("hello")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("hello.use")) {
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Welcome to the server!");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1H&2a&3v&4e &5F&6u&7n&8!"));
                    return true;
                } else {
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "You do not have permission!");
                    return true;
                }

            } else {
                sender.sendMessage("Hey Console!");
                return true;
            }
        }
        return false;
    }
}
