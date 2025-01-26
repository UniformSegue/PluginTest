package fr.uniform_segue.plugintest.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class testCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

            if(args.length >= 1){



                if(args.length >= 1){

                    StringBuilder bc = new StringBuilder();



                    for(String part : args ){

                        bc.append(part + " ");
                    }
                    Bukkit.broadcastMessage("§c[" + player.getName() + "] §e" + bc.toString().replace("&","§"));
                }







        }else {
            player.sendMessage("§c/"+ label );}


        }else{
            if(args.length >= 1){


                TextComponent msg = new TextComponent("§c[OP] " + args[0]);
                msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§6[OP]").create()));

                sender.spigot().sendMessage(msg);
            }

        else {
            sender.sendMessage("§c/"+ label );


        }
        }
        return false;
    }
}
