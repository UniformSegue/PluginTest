package fr.uniform_segue.plugintest.commands;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;


public class CommandColor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {


            player.sendMessage("§c-----------------\n"+
                    "§4Dark Red\n" +
                    "(dark_red)\t§44\n" +
                    "§cRed\n" +
                    "(red)§cc\n" +
                    "§6Gold\n" +
                    "(gold)§66\n" +
                    "§eYellow\n" +
                    "(yellow)§ee\n" +
                    "§2Dark Green\n" +
                    "(dark_green)§22\n" +
                    "§aGreen\n" +
                    "(green)§aa\n" +
                    "§bAqua\n" +
                    "(aqua)§bb\n" +
                    "§3Dark Aqua\n" +
                    "(dark_aqua)§33\n" +
                    "§1Dark Blue\n" +
                    "(dark_blue)§11\n" +
                    "§9Blue\n" +
                    "(blue)§99\n" +
                    "§dLight Purple\n" +
                    "(light_purple)§dd\n" +
                    "§5Dark Purple\n" +
                    "(dark_purple)§55\n" +
                    "§fWhite\n" +
                    "(white)§ff\n" +
                    "§7Gray\n" +
                    "(gray)§77\n" +
                    "§8Dark Gray\n" +
                    "(dark_gray)§88\n" +
                    "§0Black\n" +
                    "(black)§00");
            player.sendMessage("Obfuscated : §kk§rk\n" +
                    "§rBold : §ll§rl\n" +
                    "§rStrikethrough : §mm§rm\n" +
                    "§rUnderline : §nn§rn\n" +
                    "§rItalic : §oo§ro\n" +
                    "§rReset the default color : §rr\n"+
                    "§c-------------");

        }
        return false;
    }
}
