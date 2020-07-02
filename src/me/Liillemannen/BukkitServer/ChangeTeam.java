package me.Liillemannen.BukkitServer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class ChangeTeam implements CommandExecutor, Listener {

    public Inventory inv;


    public ChangeTeam() {
        createInv();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("changeteam")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }

            Player player = (Player) sender;
            player.openInventory(inv);
            return true;

        }
        return false;
    }

    @EventHandler()
    public void onClick(InventoryClickEvent e) {
        if (e.getWhoClicked().getInventory().equals(inv)) {
            System.out.println("1");
            return;
        }
        if (e.getCurrentItem() == null) {
            System.out.println("2");
            return;
        }
        if (e.getCurrentItem().getItemMeta() == null) {
            System.out.println("3");
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) {
            System.out.println("4");
            return;
        }

        e.setCancelled(true);

        Player player = (Player) e.getWhoClicked();

        if (e.getSlot() == 0) {
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.BLUE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team!");
        }

        if (e.getSlot() == 1) {
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.RED);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team!");
        }

        if (e.getSlot() == 2) {
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.GREEN);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team!");
        }

        if (e.getSlot() == 3) {
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.YELLOW);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team!");
        }

        if (e.getSlot() == 4) {
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.ORANGE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team!");
        }

        if (e.getSlot() == 5) {
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.PURPLE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team!");
        }

        if (e.getSlot() == 6) {
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.AQUA);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team!");
        }

        if (e.getSlot() == 8) {
            player.closeInventory();
        }

        return;

    }

    public ItemStack[] changeColor(ItemStack[] armor, Color color) {
        for (int i = 0; i < armor.length; i++) {
            try {
                if (armor[i].getType() == Material.LEATHER_CHESTPLATE || armor[i].getType() == Material.LEATHER_LEGGINGS || armor[i].getType() == Material.LEATHER_HELMET || armor[i].getType() == Material.LEATHER_BOOTS) {
                    LeatherArmorMeta meta = (LeatherArmorMeta) armor[i].getItemMeta();
                    meta.setColor(color);
                    armor[i].setItemMeta(meta);
                }
            } catch (Exception e) {

            }

        }
        return armor;
    }

    public void createInv() {
        inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "" + ChatColor.BOLD +  "Select Team");

        ItemStack item = new ItemStack(Material.BLUE_CONCRETE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.BLUE + "BLUE TEAM");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Click to join team!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(0, item);

        // röd
        item.setType(Material.RED_CONCRETE);
        meta.setDisplayName(ChatColor.RED + "RED TEAM");
        item.setItemMeta(meta);
        inv.setItem(1, item);


        //green
        item.setType(Material.GREEN_CONCRETE);
        meta.setDisplayName(ChatColor.GREEN + "GREEN TEAM");
        item.setItemMeta(meta);
        inv.setItem(2, item);


        //yellow
        item.setType(Material.YELLOW_CONCRETE);
        meta.setDisplayName(ChatColor.YELLOW + "YELLOW TEAM");
        item.setItemMeta(meta);
        inv.setItem(3, item);


        //Orange
        item.setType(Material.ORANGE_CONCRETE);
        meta.setDisplayName(ChatColor.GOLD + "ORANGE TEAM");
        item.setItemMeta(meta);
        inv.setItem(4, item);

        //purple
        item.setType(Material.PURPLE_CONCRETE);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "PURPLE TEAM");
        item.setItemMeta(meta);
        inv.setItem(5, item);

        //Cyan
        item.setType(Material.CYAN_CONCRETE);
        meta.setDisplayName(ChatColor.BLUE + "BLUE TEAM");
        item.setItemMeta(meta);
        inv.setItem(6, item);

        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.RED + "CLOSE MENU");
        lore.clear();
        lore.add(ChatColor.GRAY + "Click here to close menu!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(8, item);

    }

}
