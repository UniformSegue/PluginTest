package fr.uniform_segue.plugintest;

import fr.uniform_segue.plugintest.commands.*;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {


    @SuppressWarnings("deprecation")
    @Override
    public void onEnable() {



        super.onEnable();
        saveDefaultConfig();
        getCommand("test").setExecutor(new testCommand());
        getCommand("spawn").setExecutor(new CommandSpawn());
        getCommand("gm").setExecutor(new CommandGm());
        getCommand("gmui").setExecutor(new CommandGUI(this));
        getCommand("info").setExecutor(new CommandInfo(this));
        getCommand("admin").setExecutor(new CommandAdmin(this));
        getCommand("hat").setExecutor(new CommandHat());
        getCommand("color").setExecutor(new CommandColor());
        getCommand("pendu").setExecutor(new CommandPenduEvent());
        getCommand("vanish").setExecutor(new CommandVanish());
        getCommand("itemcustom").setExecutor(new CommandItemCustomGive());
        getCommand("backpack").setExecutor(new CommandBackPack());
        getCommand("seebackpack").setExecutor(new CommandSeeBackPack());
        getCommand("chest").setExecutor(new CommandCreateChestRandom(this));
        getCommand("restorechest").setExecutor(new CommandRestoreChest());
        getCommand("starttp").setExecutor(new CommandStartTp());
        getCommand("startgame").setExecutor(new CommandStartGame(this));
        getCommand("class").setExecutor(new CommandClassPower());



        getServer().getPluginManager().registerEvents(new PluginsListener(this), this);






    }
    @Override
    public void onDisable(){
        super.onDisable();
    }


}

