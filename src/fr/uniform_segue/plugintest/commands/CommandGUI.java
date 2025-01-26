package fr.uniform_segue.plugintest.commands;


import fr.uniform_segue.plugintest.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandGUI implements CommandExecutor {

    private Main maim;
    public CommandGUI(Main main) {
        this.maim = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {


            Inventory inv = null;


            if(args.length == 1 ) {

                inv = Bukkit.createInventory(null, 9,args[0]);


            }else{

                inv = Bukkit.createInventory(null, 9,player.getDisplayName());

            }








            ItemStack eye = new ItemStack(Material.ENDER_EYE);
            ItemMeta itme = eye.getItemMeta();
            itme.setDisplayName("§c[§eSpectator§c]");
            eye.setItemMeta(itme);

            ItemStack iron_sword = new ItemStack(Material.IRON_SWORD);
            ItemMeta itmi = iron_sword.getItemMeta();
            itmi.setDisplayName("§c[§eSurvival§c]");
            iron_sword.setItemMeta(itmi);

            ItemStack map = new ItemStack(Material.MAP);
            ItemMeta itmm = map.getItemMeta();
            itmm.setDisplayName("§c[§eAdventure§c]");
            map.setItemMeta(itmm);

            ItemStack grass = new ItemStack(Material.GRASS_BLOCK);
            ItemMeta itmg = grass.getItemMeta();
            itmg.setDisplayName("§c[§eCreative§c]");
            grass.setItemMeta(itmg);

            ItemStack rg = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta itmr = rg.getItemMeta();
            itmr.setDisplayName("§c§kmmmmm");
            rg.setItemMeta(itmr);



            inv.setItem(0,rg);
            inv.setItem(1,grass);
            inv.setItem(2,rg);
            inv.setItem(3,iron_sword);
            inv.setItem(4,rg);
            inv.setItem(5,map);
            inv.setItem(6,rg);
            inv.setItem(7,eye);
            inv.setItem(8,rg);


            player.openInventory(inv);

        }


        return false;
    }


}

