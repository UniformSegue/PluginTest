package fr.uniform_segue.plugintest;


import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


import java.io.File;
import java.io.IOException;

import java.util.List;


public class InventoryBackup {



    public void save(Player p) throws IOException {

        YamlConfiguration c = new YamlConfiguration();
        c.set("inventory.armor", p.getInventory().getArmorContents());
        c.set("inventory.content", p.getInventory().getContents());

        c.save(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\", p.getName()+".yml"));
    }
    @SuppressWarnings("unchecked")
    public void restore(Player p) throws IOException {

        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\Plugins\\spigot\\plugins\\PluginTest", p.getName()+".yml"));
        ItemStack[] content = ((List<ItemStack>) c.get("inventory.armor")).toArray(new ItemStack[0]);
        p.getInventory().setArmorContents(content);
        content = ((List<ItemStack>) c.get("inventory.content")).toArray(new ItemStack[0]);
        p.getInventory().setContents(content);
    }
}