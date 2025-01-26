package fr.uniform_segue.plugintest.commands;




import fr.uniform_segue.plugintest.eventpendu.EventPendsStart;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;


public class CommandPenduEvent implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\Plugins\\spigot\\plugins\\PluginTest\\Event.yml"));
        File file = new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\Event.yml");
        if (sender instanceof Player) {

            if (args.length >= 1) {

                EventPendsStart eventPenduStart = new EventPendsStart();

                try {
                    eventPenduStart.StartEvent(args, player);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } else {


                if (c.get("event.start").equals("false")) {
                    player.sendMessage("§cPendu : Aucune partie en cours !");
                    player.sendMessage("/pendu start, mot, lettre, l");
                } else {
                    player.sendMessage("§cPendu : " + c.get("event.actualWord"));

                }
            }


            }
            return false;
        }
    }
