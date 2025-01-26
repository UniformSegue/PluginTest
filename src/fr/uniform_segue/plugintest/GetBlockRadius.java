package fr.uniform_segue.plugintest;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import org.bukkit.block.Chest;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetBlockRadius {

    public void getBlockLocation(Player player, int radius) throws IOException {

        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\ChestLocation.yml"));



        List<Integer> location = new ArrayList<Integer>();

        int i = 1;



        World worl = player.getWorld();
        Location loc = worl.getSpawnLocation();
        World world = loc.getWorld();

        for(int zt = 1; zt - 1 < Integer.parseInt(c.get("chestFind").toString()); zt++){

            c.set("c"+zt, null);
            c.save(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\ChestLocation.yml"));

        }
        int chestFind = 0;
        for (int x = -radius; x < radius; x++) {
            for (int y = -radius; y < radius; y++) {
                for (int z = -radius; z < radius; z++) {
                    Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
                    if (block.getType() == Material.SPONGE) {



                        location.add(x);
                        location.add(y);
                        location.add(z);

                        c.set("c" + i, location.toArray() );

                        location.clear();


                        player.sendMessage("Sponge Find : "+ x +", "  + y + ", "+ z);
                        i++;
                        chestFind++;
                    }
                }
            }

        }

        c.set("chestFind", chestFind);
        c.save(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\ChestLocation.yml"));

    }

    public void createChest(Player player){



        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\Plugins\\spigot\\plugins\\PluginTest\\ChestLocation.yml"));


        int i = 1;
        String chestFindStr = c.get("chestFind").toString();

        int chestFind = Integer.parseInt(chestFindStr);
        int[] location = {0,0,0};




        for(int f=0; f < chestFind + 1 ; f++ ) {
            if (c.get("c" + i) == null) {
                player.sendMessage("§4No Sponge");
                player.sendMessage("§4Sponge Find : " + chestFindStr);
                break;
            } else {



                String coordonné = c.get("c" + i).toString();
                coordonné = coordonné.replace("[", "");
                coordonné = coordonné.replace("]", "");
                coordonné = coordonné.replace(",", "");


                String[] coordonnéeStrArray = coordonné.split(" ");
                double x = Integer.parseInt(coordonnéeStrArray[0]);
                double y = Integer.parseInt(coordonnéeStrArray[1]) + 4;
                double z = Integer.parseInt(coordonnéeStrArray[2]);


                c.get("c" + i).toString();
                Random r = new Random();

                Location spawnChest = new Location(Bukkit.getWorld("world"), x, y, z);
                spawnChest.getBlock().setType(Material.CHEST);

                Chest chest = (Chest) spawnChest.getBlock().getState();
                Inventory chestMenu = chest.getInventory();



                    ChooseItemRandom chooseItemRandom = new ChooseItemRandom();
                    ItemStack[] armures = chooseItemRandom.chooseItem();

                    chestMenu.setItem(r.nextInt(chestMenu.getSize()),armures[0]);
                    chestMenu.setItem(r.nextInt(chestMenu.getSize()),armures[1]);
                    chestMenu.setItem(r.nextInt(chestMenu.getSize()),armures[2]);
                    chestMenu.setItem(r.nextInt(chestMenu.getSize()),armures[3]);
                    chestMenu.setItem(r.nextInt(chestMenu.getSize()),armures[4]);



                i++;

            }

        }
        }

        public void restoreChest(Player player){

            YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\ChestLocation.yml"));


            int i = 1;
            String chestFindStr = c.get("chestFind").toString();

            int chestFind = Integer.parseInt(chestFindStr);
            int[] location = {0,0,0};

            for(int f=0; f < chestFind + 1 ; f++ ) {


                if (c.get("c" + i) == null) {

                    player.sendMessage("No Chest");
                    player.sendMessage("Chest Restore : " + chestFindStr);
                    break;
                } else {



                    String coordonné = c.get("c" + i).toString();
                    coordonné = coordonné.replace("[", "");
                    coordonné = coordonné.replace("]", "");
                    coordonné = coordonné.replace(",", "");


                    String[] coordonnéeStrArray = coordonné.split(" ");
                    double x = Integer.parseInt(coordonnéeStrArray[0]);
                    double y = Integer.parseInt(coordonnéeStrArray[1]) + 4;
                    double z = Integer.parseInt(coordonnéeStrArray[2]);


                    c.get("c" + i).toString();
                    Random r = new Random();

                    Location spawnChest = new Location(Bukkit.getWorld("world"), x, y, z);
                    spawnChest.getBlock().setType(Material.SPONGE);

                    i++;
        }

    }

    }

}

