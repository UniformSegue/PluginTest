package fr.uniform_segue.plugintest.commands;


import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;


public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

            Location spawn = new Location(player.getWorld(),0.45,2.1,0.45);
            TextComponent msg = new TextComponent("§c[§eTeleport Spawn§c]");

            player.spigot().sendMessage(msg);

            player.teleport(spawn);

        }
        return false;
    }
}
