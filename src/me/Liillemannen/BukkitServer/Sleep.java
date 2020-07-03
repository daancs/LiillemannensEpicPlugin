package me.Liillemannen.BukkitServer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Sleep implements CommandExecutor, Listener {


    Main main;

    public Sleep(Main _main) {
        main = _main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("sleep")) {
            if (args.length == 1) {
                try {
                    int i = Integer.parseInt(args[0]);
                    main.pluginConfig.setPercentage(i, (Player) sender);
                    return true;
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Something went wrong.");
                    sender.sendMessage(ChatColor.RED + "Usage: /sleep <integer>");
                }

            } else if (args.length == 0) {
                sender.sendMessage(ChatColor.GREEN + "Sleep percentage: " + main.pluginConfig.config.getInt("percentage"));
            }
        }
        return false;
    }


    List<String> playersSleeping = new ArrayList<String>();
    int sleepPercentage;
    int configPercentage;

    @EventHandler()
    public void onSleep(PlayerBedEnterEvent event) {
        if (!(event.getPlayer().getWorld().getTime() > 13000)) {
            event.getPlayer().sendMessage(ChatColor.RED + "You cannot sleep at day.");
            return;
        }
        playersSleeping.add(event.getPlayer().getName());
        System.out.println(playersSleeping);
        Collection playersOnline = main.getServer().getOnlinePlayers();
        sleepPercentage = (int) (((float) playersSleeping.size() / (float) playersOnline.size()) * 100);
        System.out.println(sleepPercentage);
        configPercentage = main.pluginConfig.config.getInt("percentage");

        if (sleepPercentage >= configPercentage) {
            event.getPlayer().getWorld().setTime(0);
            Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Wakey wakey, rise and shine! Good morning everyone!");
        } else {
            Bukkit.broadcastMessage(ChatColor.GOLD + "Player " + event.getPlayer().getName() + " is sleeping. [" + playersSleeping.size() + "/" + playersOnline.size() + "] " + ChatColor.BOLD + configPercentage + "% is needed to make it morning.");
        }
    }

    @EventHandler()
    public void onBedLeave(PlayerBedLeaveEvent event) {
        if (event.getPlayer().getWorld().getTime() < 13000) {
            return;
        }
        playersSleeping.remove(event.getPlayer().getName());
        System.out.println("Players sleeping: " + playersSleeping);
        Collection playersOnline = main.getServer().getOnlinePlayers();
        Bukkit.broadcastMessage(ChatColor.GOLD + "Player " + event.getPlayer().getName() + " just exited the bed. [" + playersSleeping.size() + "/" + playersOnline.size() + "]");
    }
}
