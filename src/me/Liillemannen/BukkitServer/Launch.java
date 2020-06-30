package me.Liillemannen.BukkitServer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Launch implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("launch") || label.equalsIgnoreCase("lch")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("launch.use")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "ZOOOOOOOM!");
                        player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
                        return true;
                    }
                    if (isNum(args[0])) {
                        player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "ZOOOOOOOM!");
                        player.setVelocity(player.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2));
                    } else {
                        player.sendMessage(ChatColor.RED + "Usage: /launch <number-value>");
                    }
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You do not have permission!");
                    return true;
                }
            } else {
                sender.sendMessage("*console goes flying*");
                return true;
            }
        }

        return false;
    }

    public boolean isNum(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
