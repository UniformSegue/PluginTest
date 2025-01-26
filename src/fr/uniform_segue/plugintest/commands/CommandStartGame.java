package fr.uniform_segue.plugintest.commands;

import fr.uniform_segue.plugintest.GetBlockRadius;
import fr.uniform_segue.plugintest.Main;
import fr.uniform_segue.plugintest.StartTpBack;
import fr.uniform_segue.plugintest.TimerTask;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.IOException;


public class CommandStartGame implements CommandExecutor {

    private Main maim;
    public CommandStartGame(Main main) {
        this.maim = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

            if(args.length >= 1){

                Bukkit.broadcastMessage("§4Lancement de la game");

                GetBlockRadius getBlockRadius = new GetBlockRadius();
                int radius = Integer.parseInt(args[0]);
                try {
                    getBlockRadius.getBlockLocation(player, radius);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                getBlockRadius.createChest(player);

                StartTpBack tp = new StartTpBack();
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

                TimerTask timer = new TimerTask();
                timer.runTaskTimer(maim,0,20 );
        }else{
            player.sendMessage("Ecrire Rayon");

        }


        }
        return false;
    }
}
