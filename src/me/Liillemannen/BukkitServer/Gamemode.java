package me.Liillemannen.BukkitServer;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("gm")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("fak off bish");
                return true;
            }

            Player player = (Player) sender;
            if (!player.hasPermission("gamemode.use")) {
                player.sendMessage(ChatColor.RED + "You cannot use this command!");
                return true;
            }
            if (Integer.parseInt(args[0]) == 0) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6You are now in &a&lSURVIVAL &6Mode"));
                return true;
            }
            if (Integer.parseInt(args[0]) == 1) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6You are now in &a&lCREATIVE &6Mode"));
                return true;
            }
            if (Integer.parseInt(args[0]) == 2) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6You are now in &a&lADVENTURE &6Mode"));
                return true;
            }
            if (Integer.parseInt(args[0]) == 3) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6You are now in &a&lSPECTATOR &6Mode"));
                return true;
            }
            player.sendMessage(ChatColor.RED + "Usage /gm <integer>");
            return true;
        }
        return false;
    }


}


