package fr.uniform_segue.plugintest.commands;


import fr.uniform_segue.plugintest.SeeBackPack;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.IOException;


public class CommandSeeBackPack implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {


            if(args.length >= 1){

                if(Bukkit.getPlayerExact(args[0]) != null){
                SeeBackPack seebackPack = new SeeBackPack();

                Inventory inventory = Bukkit.createInventory(null, 27, "§2Backpack de §4"+ args[0]);


                try {
                    seebackPack.Load(Bukkit.getPlayerExact(args[0]), inventory, player);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                player.updateInventory();
                player.openInventory(inventory);


            }else{

                    player.sendMessage("§4Le joueur ne possede pas de backpack");

                }

            }else{

                player.sendMessage("§4/seebackpack NomDuJoueur");

            }

        }
        return false;
    }
}
