package fr.uniform_segue.plugintest;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StartTpBack {

    public void getBlockLocation(Player player, int radius) throws IOException {

        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\TpLocation.yml"));



        List<Integer> location = new ArrayList<Integer>();

        int i = 1;

        World worl = player.getWorld();
        Location loc = worl.getSpawnLocation();
        World world = loc.getWorld();

        if(c.get("TpFind") != null){
        for(int zt = 1; zt - 1 < Integer.parseInt(c.get("TpFind").toString()); zt++){

            c.set("tp"+zt, null);
            c.save(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\TpLocation.yml"));


        }}
        int chestFind = 0;
        for (int x = -radius; x < radius; x++) {
            for (int y = -radius; y < radius; y++) {
                for (int z = -radius; z < radius; z++) {
                    Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
                    if (block.getType() == Material.GOLD_BLOCK) {

                        location.add(x);
                        location.add(y);
                        location.add(z);
                        c.set("tp" + i, location.toArray() );
                        location.clear();

                        player.sendMessage("Gold Find : "+ x +", "  + y + ", "+ z);
                        i++;
                        chestFind++;
                    }
                }
            }

        }

        c.set("TpFind", chestFind);
        c.save(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\TpLocation.yml"));

    }

    public void createTp(Player player) throws IOException {

        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\TpLocation.yml"));

        int i = 1;
        String TpFindStr = c.get("TpFind").toString();

        int TpFind = Integer.parseInt(TpFindStr);
        int[] location = {0,0,0};

        for(Player p : Bukkit.getOnlinePlayers()){
            if (c.get("tp" + i) == null) {
                player.sendMessage("§4No Gold");

                break;
            } else {

                String coordonné = c.get("tp" + i).toString();
                coordonné = coordonné.replace("[", "");
                coordonné = coordonné.replace("]", "");
                coordonné = coordonné.replace(",", "");

                String[] coordonnéeStrArray = coordonné.split(" ");
                double x = Integer.parseInt(coordonnéeStrArray[0]);
                double y = Integer.parseInt(coordonnéeStrArray[1]) + 4;
                double z = Integer.parseInt(coordonnéeStrArray[2]);

                c.get("tp" + i).toString();

                int tp1 = 1;
                Location goldActuallTp = new Location(player.getWorld(),x+0.5,y + 2,z+0.5);
                p.teleport(goldActuallTp);



                i++;

            }
        }

        c.set("gameStart", "true");
        c.save(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\TpLocation.yml"));

    }

}
