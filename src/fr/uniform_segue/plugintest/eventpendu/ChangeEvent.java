package fr.uniform_segue.plugintest.eventpendu;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;

public class ChangeEvent {

    public void EventSave(String lance, String mot) throws IOException {

        YamlConfiguration c = new YamlConfiguration();

        c.set("event.start", lance);
        c.set("event.mot", mot);
        String[] actualWord = new String[mot.length()];
        for(int i=0; i<mot.length(); i++) {

            actualWord[i] = "-";
        }

        String actualWordString = "";
        for(int f=0; f<actualWord.length; f++) {

           actualWordString = actualWordString + actualWord[f];

        }

        System.out.println(actualWordString);
        c.set("event.actualWord", actualWordString);

        c.save("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\Event.yml");



    }
}
