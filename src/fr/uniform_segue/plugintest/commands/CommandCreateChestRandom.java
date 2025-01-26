package fr.uniform_segue.plugintest.commands;


import fr.uniform_segue.plugintest.GetBlockRadius;
import fr.uniform_segue.plugintest.Main;


import fr.uniform_segue.plugintest.StartTpBack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.IOException;



public class CommandCreateChestRandom implements CommandExecutor {

    private Main maim;
    public CommandCreateChestRandom(Main main) {
        this.maim = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

            if(args.length >=1) {

                GetBlockRadius getBlockRadius = new GetBlockRadius();
                int radius = Integer.parseInt(args[0]);
                try {
                    getBlockRadius.getBlockLocation(player, radius);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                getBlockRadius.createChest(player);



            }else{
                player.sendMessage("Ecrire Rayon");

            }


        }
        return false;
    }
}
