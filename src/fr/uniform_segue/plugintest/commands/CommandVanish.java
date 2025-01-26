package fr.uniform_segue.plugintest.commands;



import fr.uniform_segue.plugintest.Vanish;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;


public class CommandVanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

          Vanish vanish = new Vanish();

          if(player.isInvisible()){
              vanish.vanishModeDesactive(player);
          }else{
              vanish.vanishModeActive(player);
          }

        }
        return false;
    }
}
