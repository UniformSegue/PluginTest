package fr.uniform_segue.plugintest.commands;

import fr.uniform_segue.plugintest.InventoryBackup;



import fr.uniform_segue.plugintest.Main;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemStack;

import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;


public class CommandAdmin implements CommandExecutor {

    private Main maim;

    public CommandAdmin(Main main) {
        this.maim = main;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (sender instanceof Player) {


            InventoryBackup inventoryBackup = new InventoryBackup();

            if(player.getInventory().getItem(0) != null) {
                if(player.getInventory().getItem(0).getItemMeta().getDisplayName().equalsIgnoreCase("§4Leave Mode Admin")) {


                }else{
                    try {
                        inventoryBackup.save(player);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.getInventory().clear();

                    player.getInventory().setItem(0, getItem(Material.PAPER, "§4Leave Mode Admin"));
                    player.getInventory().setItem(1, getItem(Material.FEATHER, "§aVanish"));
                    player.getInventory().setItem(2, getItem(Material.GRASS_BLOCK, "§2Gamemode"));
                    player.getInventory().setItem(8, getItem(Material.STICK, "§3Info Player"));

                    player.sendMessage("Save");
                }
            }else{

                    try {
                        inventoryBackup.save(player);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.getInventory().clear();

                    player.getInventory().setItem(0, getItem(Material.PAPER, "§4Leave Mode Admin"));
                    player.getInventory().setItem(1, getItem(Material.FEATHER, "§aVanish"));
                    player.getInventory().setItem(2, getItem(Material.GRASS_BLOCK, "§2Gamemode"));
                    player.getInventory().setItem(8, getItem(Material.STICK, "§3Info Player"));

                    player.sendMessage("Save");

            }
        }
        return false;

    }
    public ItemStack getItem(Material material, String customname ){

        ItemStack it = new ItemStack(material, 1);
        ItemMeta itm = it.getItemMeta();
        itm.setDisplayName(customname);
        it.setItemMeta(itm);
        return it;

    }

}
