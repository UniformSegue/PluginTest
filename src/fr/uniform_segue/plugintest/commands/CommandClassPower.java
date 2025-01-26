package fr.uniform_segue.plugintest.commands;


import fr.uniform_segue.plugintest.commands.classpower.CreateClassUI;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;


public class CommandClassPower implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

            CreateClassUI createClassUI = new CreateClassUI();

            createClassUI.CreateUi(player);


        }
        return false;
    }
}
