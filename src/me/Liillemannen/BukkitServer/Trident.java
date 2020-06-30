package me.Liillemannen.BukkitServer;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Trident implements CommandExecutor, Listener {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("trident") || label.equalsIgnoreCase("tr")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("No u");
                return true;
            }
            Player player = (Player) sender;
            if (player.getInventory().firstEmpty() == -1) {
                Location loc = player.getLocation();
                World world = player.getWorld();

                world.dropItemNaturally(loc, getItem());
                player.sendMessage(ChatColor.GOLD + "epix trident on ground");
                return true;
            }
            player.getInventory().addItem(getItem());
            player.sendMessage(ChatColor.GOLD + "epix trident");
            return true;

        }
        return false;
    }

    public ItemStack getItem() {

        ItemStack item = new ItemStack(Material.TRIDENT);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Ancient Trident");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Right Click) &a&oSpawn Minions"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Left Click) &a&oShoot Explosives"));
        meta.setLore(lore);

        meta.addEnchant(Enchantment.LOYALTY, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    @EventHandler()
    public void onClick(PlayerInteractEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.TRIDENT))
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                Player player = (Player) e.getPlayer();
                if (e.getAction() == Action.RIGHT_CLICK_AIR) {
                    
                }

                if (e.getAction() == Action.LEFT_CLICK_AIR) {
                    player.launchProjectile(Fireball.class);
                }
            }
    }

}
