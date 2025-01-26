package fr.uniform_segue.plugintest.commands;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class CommandHat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

                ItemStack helmet = player.getInventory().getHelmet();
                player.getInventory().setHelmet(player.getItemInHand());
                player.getInventory().getItemInHand().setAmount(-1);
                player.getInventory().setItemInMainHand(helmet);


        }
        return false;
    }
}
