package fr.uniform_segue.plugintest;

import com.mysql.fabric.xmlrpc.base.Array;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BackPack {




    public void Save(Player player, Inventory inventory) throws IOException {




        YamlConfiguration c = new YamlConfiguration();
        c.set("backpackcontent", inventory.getStorageContents());

        c.save(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest", player.getName()+"_bp.yml"));




    }

    public void Load(Player player, Inventory inventory) throws IOException{


        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest", player.getName() + "_bp.yml"));

        if(c.get("backpackcontent") != null){



        ItemStack[] content = ((List<ItemStack>) c.get("backpackcontent")).toArray(new ItemStack[0]);
        inventory.setContents(content);


        }else {



            YamlConfiguration cl = new YamlConfiguration();
            List list = new ArrayList();
            cl.set("backpackcontent", list);
            cl.save(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest", player.getName() + "_bp.yml"));

        }
    }

}
