package fr.uniform_segue.plugintest.commands;



import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class CommandItemCustomGive implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

            if(args.length >= 1){




               ItemStack it = new ItemStack(Material.AIR, 1);
               ItemMeta itm = it.getItemMeta();
               itm.setDisplayName(args[1]);
               it.setItemMeta(itm);






            }else{
                player.sendMessage("§4itemcustom <item> <name> <description_ligne1> <description_ligne2> ...");
            }

        }
        return false;
    }
}
