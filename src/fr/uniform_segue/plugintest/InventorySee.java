package fr.uniform_segue.plugintest;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Objects;
import java.util.UUID;

public class InventorySee {
    private final UUID holder;
    private final ItemStack[] storageContents;


    public InventorySee(Player player) {
        this(player.getInventory());
    }

    public InventorySee(PlayerInventory inventory) {

        this.holder = Objects.requireNonNull(inventory.getHolder(), "Cannot save a playerless inventory").getUniqueId();
        this.storageContents = inventory.getStorageContents();


//
    }

    public void restore(String playername, Player player) {

        Player holder = player.getPlayer();

        Inventory inv = Bukkit.createInventory(null, 45, "§4Inventory See");


        Player playerv = Bukkit.getPlayerExact(playername);
        inv.setStorageContents(storageContents);

        ItemStack head = playerv.getInventory().getHelmet();
        System.out.println(head);
        ItemStack Breastplate = playerv.getInventory().getChestplate();
        ItemStack legging = playerv.getInventory().getLeggings();
        ItemStack boots = playerv.getInventory().getBoots();
        ItemStack extra = playerv.getInventory().getItemInOffHand();

        inv.setItem(36, head);
        inv.setItem(37, Breastplate);
        inv.setItem(38, legging);
        inv.setItem(39, boots);
        inv.setItem(40,new ItemStack(Material.RED_STAINED_GLASS_PANE, 1));
        inv.setItem(41, extra);
        inv.setItem(42,new ItemStack(Material.RED_STAINED_GLASS_PANE, 1));
        inv.setItem(43,new ItemStack(Material.RED_STAINED_GLASS_PANE, 1));
        inv.setItem(44,new ItemStack(Material.RED_STAINED_GLASS_PANE, 1));

        holder.openInventory(inv);



    }
}
