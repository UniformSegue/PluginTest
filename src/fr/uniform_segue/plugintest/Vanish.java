package fr.uniform_segue.plugintest;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Vanish {

    public void vanishModeActive(Player player){

                player.setInvisible(true);
                player.setGameMode(GameMode.CREATIVE);


    }
    public void vanishModeDesactive(Player player){

        player.setInvisible(false);


    }
}
