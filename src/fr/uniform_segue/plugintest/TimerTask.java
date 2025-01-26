package fr.uniform_segue.plugintest;

import org.bukkit.Bukkit;

import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

public class TimerTask  extends BukkitRunnable {

    private int timer = 10;


    @Override
    public void run(){

        Bukkit.broadcastMessage("§4Lancement dans : "+ timer +"s");
        if(timer==0){

            Bukkit.broadcastMessage("§4Go !");
            YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\TpLocation.yml"));
            c.set("gameStart", "false");
            try {
                c.save("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\TpLocation.yml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(Player p : Bukkit.getOnlinePlayers()){

             p.setGameMode(GameMode.ADVENTURE);
             p.setHealth(20d);
             p.setSaturation(20f);

            }
            cancel();


        }

        timer--;

    }
}
