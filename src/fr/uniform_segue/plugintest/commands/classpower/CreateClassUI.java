package fr.uniform_segue.plugintest.commands.classpower;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateClassUI {

    public void CreateUi(Player player){

        Inventory inventory = Bukkit.createInventory(null, 9, "§cClass");

        ItemStack class1 = new ItemStack(Material.APPLE);
        ItemMeta class1itm = class1.getItemMeta();
        class1itm.setDisplayName("§cHeal");
        class1.setItemMeta(class1itm);

        inventory.setItem(0,class1);

        player.openInventory(inventory);
    }

    public ItemStack getItem(Material material, String customname ){

        ItemStack it = new ItemStack(material, 1);
        ItemMeta itm = it.getItemMeta();
        itm.setDisplayName(customname);
        it.setItemMeta(itm);
        return it;

    }
}
