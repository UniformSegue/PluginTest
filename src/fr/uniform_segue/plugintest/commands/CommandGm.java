package fr.uniform_segue.plugintest.commands;




import org.bukkit.Bukkit;
import org.bukkit.GameMode;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;




public class CommandGm implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

            if(args.length == 2) {

                Player player1 = Bukkit.getPlayerExact(args[1]);
                if(player1 != null) {
                    int i = Integer.parseInt(args[0]);
                    if (i == 1) {

                        player1.setGameMode(GameMode.CREATIVE);

                    }
                    if (i == 3) {

                        player1.setGameMode(GameMode.SPECTATOR);

                    }
                    if (i == 0) {

                        player1.setGameMode(GameMode.SURVIVAL);

                    }
                    if (i == 2) {

                        player1.setGameMode(GameMode.ADVENTURE);

                    }
                }else{

                    player.sendMessage("le joueur n'est pas connecter");
                }
            }else if(args.length == 1){



                int i = Integer.parseInt(args[0]);
                if (i == 1) {

                    player.setGameMode(GameMode.CREATIVE);

                }
            if (i == 3) {

                player.setGameMode(GameMode.SPECTATOR);

            }
            if (i == 0) {

                player.setGameMode(GameMode.SURVIVAL);

            }
            if (i == 2) {

                player.setGameMode(GameMode.ADVENTURE);

            }

        }else{
                player.sendMessage("Veuillez rentrer un gamemode");
            }

        }
        return false;
    }
}
