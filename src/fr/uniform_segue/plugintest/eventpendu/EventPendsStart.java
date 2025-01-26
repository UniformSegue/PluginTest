package fr.uniform_segue.plugintest.eventpendu;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class EventPendsStart {

    YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\Event.yml"));
    File file = new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\Event.yml");

    public void StartEvent(String[] args, Player player) throws IOException {



        if(args[0].equalsIgnoreCase("start")){






            if(c.get("event.start").toString().equalsIgnoreCase("true")){


                player.sendMessage("§cPendu : Un event est deja lancer");


            }else if(c.get("event.start").toString().equalsIgnoreCase("false")) {

try{

                if (args != null) {
                    player.sendMessage("§cPendu Mot : " + args[1]);


                    ChangeEvent save = new ChangeEvent();
                    save.EventSave("true", args[1]);



                }




            }catch (Exception ex) {

    System.out.println("Catch For Protect Error Args Null");
    player.sendMessage("§cPendu : Veuillez ecrire un mot pour lancer un event pendu");
}
        }


        }else if(args[0].equalsIgnoreCase("lettre") || args[0].equalsIgnoreCase("l") ) {


            if(args[1].length() == 1) {


                CheckWord checkWord = new CheckWord();
                checkWord.CheckWord(args[1], player);

            }

        }else if (args[0].equalsIgnoreCase("stop") && player.hasPermission("op")){

            ChangeEvent save = new ChangeEvent();
            save.EventSave("false","null");
            player.sendMessage("Event Stop");





        }else if(args[0].equalsIgnoreCase("mot")){

            if(c.get("event.start").equals("true")){
                if(args[1].equalsIgnoreCase(c.get("event.mot").toString())){


                    Bukkit.broadcastMessage("§cPendu : " + player.getDisplayName() + " a gagner !!");
                    ChangeEvent save = new ChangeEvent();
                    save.EventSave("false", "null");
                }else{

                    player.sendMessage("§cPendu : Mauvais mot !");

                }

        }else{
                player.sendMessage("§cPendu : Aucune partie en cours !");
            }
        }else if(c.get("event.start").equals("false")){

            player.sendMessage("§cPendu : Aucun event est lancer !");

        }
        else
        {
            player.sendMessage("/pendu start, mot, lettre, l");
        }

    }
}
