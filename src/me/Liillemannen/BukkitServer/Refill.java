package me.Liillemannen.BukkitServer;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Refill implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("refill") || label.equalsIgnoreCase("ref")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("fak off bish");
                return true;
            }
            Player player = (Player) sender;
            if (!player.hasPermission("refill.use")) {
                player.sendMessage(ChatColor.RED + "You cannot use this command!");
                return true;
            }
            if (args.length == 0) {
                player.setFoodLevel((int) 20.0);
                player.sendMessage(ChatColor.GREEN + "Your stomach has been refilled!");
                return true;
            }
            player.sendMessage(ChatColor.RED + "Usage: /refill");
            return true;
        }
        return false;
    }
}

