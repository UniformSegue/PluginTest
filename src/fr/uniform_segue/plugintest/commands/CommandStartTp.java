package fr.uniform_segue.plugintest.commands;

import fr.uniform_segue.plugintest.GetBlockRadius;
import fr.uniform_segue.plugintest.StartTpBack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

import java.io.IOException;


public class CommandStartTp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

            if(args.length >=1) {

                StartTpBack tp = new StartTpBack();
                int radius = Integer.parseInt(args[0]);
                try {
                    tp.getBlockLocation(player, radius);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    tp.createTp(player);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else{
                player.sendMessage("Ecrire Rayon");

            }
        }
        return false;
    }
}
