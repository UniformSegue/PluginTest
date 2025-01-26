package fr.uniform_segue.plugintest;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminOpenUi {

    public void OpenUiValide(Player player){

        Inventory inv = Bukkit.createInventory(null, 9,"Valide Admin Leave");

        inv.setItem(2, getItem(Material.LIME_STAINED_GLASS_PANE,"§2Yes"));
        inv.setItem(6, getItem(Material.RED_STAINED_GLASS_PANE,"§4oNo"));
        player.openInventory(inv);
        Vanish vanish = new Vanish();
        vanish.vanishModeDesactive(player);

    }

    public ItemStack getItem(Material material, String customname ){

        ItemStack it = new ItemStack(material, 1);
        ItemMeta itm = it.getItemMeta();
        itm.setDisplayName(customname);
        it.setItemMeta(itm);
        return it;

    }
}
