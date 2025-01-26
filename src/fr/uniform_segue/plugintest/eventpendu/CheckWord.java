package fr.uniform_segue.plugintest.eventpendu;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class CheckWord {

    public void CheckWord(String motCheck, Player player) throws IOException {

        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\Event.yml"));
        File file = new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\Event.yml");
        String actualWord;
        String motPendu = c.get("event.mot").toString();


        boolean lettreFind = false;
        for(int i=0; i<motPendu.length(); i++) {


                char char1 = motPendu.charAt(i);
                char char2 = motCheck.charAt(0);
                char charmaj1 = Character.toLowerCase(char1);
                char charmaj2 = Character.toLowerCase(char2);


            if(charmaj1 == charmaj2){

                actualWord = c.get("event.actualWord").toString();


                StringBuilder newWord = new StringBuilder(actualWord);


                newWord.setCharAt(i, charmaj2);



                c.set("event.actualWord", newWord.toString());
                c.save("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\Event.yml");



                lettreFind = true;
            }




            }
        if(lettreFind == false){

            player.sendMessage("§cPendu : " + motCheck + " n'est pas dans le mot !");

        }else {

            player.sendMessage("§cPendu : " + c.get("event.actualWord"));
        }








    }
}
