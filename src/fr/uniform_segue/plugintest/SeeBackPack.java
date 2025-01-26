package fr.uniform_segue.plugintest;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeeBackPack {




    public void Save(Player playerSpec, Inventory inventory,Player player) throws IOException {




        YamlConfiguration c = new YamlConfiguration();
        c.set("backpackcontent", inventory.getStorageContents());

        c.save(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest", playerSpec.getName()+"_bp.yml"));




    }

    public void Load(Player playerSpec, Inventory inventory, Player player) throws IOException{


        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest", playerSpec.getName() + "_bp.yml"));

        if(c.get("backpackcontent") != null){

            if(playerSpec != null) {


                ItemStack[] content = ((List<ItemStack>) c.get("backpackcontent")).toArray(new ItemStack[0]);
                inventory.setContents(content);

            }else{

                player.sendMessage("§4Le joueur ne possede pas de backpack");

            }
        }else {

            player.sendMessage("§4Le joueur ne possede pas de backpack");

        }
    }

}
