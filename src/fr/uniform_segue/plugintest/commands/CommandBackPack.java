package fr.uniform_segue.plugintest.commands;


import fr.uniform_segue.plugintest.BackPack;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.IOException;


public class CommandBackPack implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

            BackPack backPack = new BackPack();

            Inventory inventory = Bukkit.createInventory(null, 27, "§2Backpack");



            try {
                backPack.Load(player, inventory);

            } catch (IOException e) {
                e.printStackTrace();
            }

            player.updateInventory();
            player.openInventory(inventory);


        }
        return false;
    }
}
