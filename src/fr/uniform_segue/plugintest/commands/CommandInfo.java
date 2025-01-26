package fr.uniform_segue.plugintest.commands;


import fr.uniform_segue.plugintest.Main;

import org.bukkit.Bukkit;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public class CommandInfo implements CommandExecutor {

    private Main maim;

    public CommandInfo(Main main) {
        this.maim = main;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {
            if (args.length >= 1) {


            if (args[0] == null) {

                player.sendMessage("Mettre un pseudo valide ! ");
            }

            if (Bukkit.getPlayerExact(args[0]) != null) {
                if (Bukkit.getPlayerExact(args[0]).isOnline()) {


                    Inventory inv = Bukkit.createInventory(null, 18, args[0]);


                    inv.setItem(1, getItem(Material.ANVIL, "§4Ban Definitf"));

                    inv.setItem(0, getItem(Material.ANVIL, "§cKick"));

                    inv.setItem(9, getItem(Material.APPLE, "§cHeal"));

                    inv.setItem(10, getItem(Material.FEATHER, "§bClear All Effects"));

                    inv.setItem(7, getItem(Material.BARRIER, "§6Clear"));

                    inv.setItem(8, getItem(Material.ENDER_EYE, "§6See Inventory"));

                    ItemStack playertotem = new ItemStack(Material.TOTEM_OF_UNDYING);
                    ItemMeta itmplayer = playertotem.getItemMeta();
                    itmplayer.setDisplayName("§6" + args[0]);
                    itmplayer.setLore(Arrays.asList("Health : " + (int) Bukkit.getPlayerExact(args[0]).getHealth() + " Hearth", "Food Level : " + Bukkit.getPlayerExact(args[0]).getFoodLevel(), "Exp : " + Bukkit.getPlayerExact(args[0]).getLevel(), "Ip : " + player.getAddress().getAddress().toString()));
                    playertotem.setItemMeta(itmplayer);
                    inv.setItem(4, playertotem);


                    ItemStack crea = new ItemStack(Material.GRASS_BLOCK);
                    ItemMeta itc = crea.getItemMeta();
                    itc.setDisplayName("§2Gamemode");
                    itc.setLore(Arrays.asList("Clique pour changer le mode"));
                    crea.setItemMeta(itc);
                    inv.setItem(13, crea);


                    player.openInventory(inv);


                }
            } else {
                player.sendMessage("Player Offline");
            }


        }else{
                player.sendMessage("§cEcrire Pseudo Valide");

            }

        }
        return false;
    }

    public ItemStack getItem(Material material,String customname ){

        ItemStack it = new ItemStack(material, 1);
        ItemMeta itm = it.getItemMeta();
        itm.setDisplayName(customname);
        it.setItemMeta(itm);
        return it;

    }
}
