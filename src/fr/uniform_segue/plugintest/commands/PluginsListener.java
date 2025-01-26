package fr.uniform_segue.plugintest.commands;


import fr.uniform_segue.plugintest.*;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;


public class PluginsListener implements Listener {

    private Main maim;
    public PluginsListener(Main main) {

        this.maim = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
        player.getInventory().clear();


        ItemStack customsword = new ItemStack(Material.COMPASS, 1);
        ItemMeta customM = customsword.getItemMeta();
        customM.setDisplayName("§cCompass");
        customsword.setItemMeta(customM);


        player.getInventory().setItem(8, customsword);

        ItemStack customwool = new ItemStack(Material.RED_WOOL, 8);
        player.getInventory().setHelmet(customwool);


        player.updateInventory();

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) throws IOException{

        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();
        if(it == null) return;
        if(it.getType() == Material.COMPASS && it.getItemMeta().getDisplayName().equalsIgnoreCase("§cCompass")){

            Inventory inv = Bukkit.createInventory(null, 54,"§7Mon Menu");
            ItemStack chest = new ItemStack(Material.CHEST);

            inv.setItem(11,chest);

            player.openInventory(inv);


        }
        if(it.getType() == Material.PAPER && it.getItemMeta().getDisplayName().equalsIgnoreCase("§4Leave Mode Admin")){

            AdminOpenUi adminOpenUi = new AdminOpenUi();
            adminOpenUi.OpenUiValide(player);

        }
        if(it.getType() == Material.FEATHER && it.getItemMeta().getDisplayName().equalsIgnoreCase("§aVanish")){
              if(player.isInvisible()) {

                 Vanish vanish = new Vanish();
                 vanish.vanishModeDesactive(player);

              }else {

                  Vanish vanish = new Vanish();
                  vanish.vanishModeActive(player);
              }

        }
        if(it.getType() == Material.GRASS_BLOCK && it.getItemMeta().getDisplayName().equalsIgnoreCase("§2Gamemode")){

            event.setCancelled(true);
            player.chat("/gmui");

        }


    }

    @EventHandler
    public void onClick(InventoryClickEvent event) throws IOException {

        Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();


        if(current == null) return;
        if(event.getView().getTitle().equalsIgnoreCase("§7Mon Menu")) {


            event.setCancelled(true);

            if (current.getType() == Material.CHEST) {
                player.closeInventory();
                player.setGameMode(GameMode.SPECTATOR);

            }

        }

        if(inv.getSize()==9){
            event.setCancelled(true);

            if(current.getType() == Material.ENDER_EYE){

                Bukkit.getPlayerExact(event.getView().getTitle()).setGameMode(GameMode.SPECTATOR);

            }
            if(current.getType() == Material.GRASS_BLOCK){

                Bukkit.getPlayerExact(event.getView().getTitle()).setGameMode(GameMode.CREATIVE);

            }
            if(current.getType() == Material.IRON_SWORD){

                Bukkit.getPlayerExact(event.getView().getTitle()).setGameMode(GameMode.SURVIVAL);

            }
            if(current.getType() == Material.MAP){

                Bukkit.getPlayerExact(event.getView().getTitle()).setGameMode(GameMode.ADVENTURE);

            }
        }
        if(event.getView().getTitle().equalsIgnoreCase("Valide Admin Leave")){

            event.setCancelled(true);

            if(current.getType()==Material.LIME_STAINED_GLASS_PANE){

                player.getInventory().clear();
                InventoryBackup inventoryBackup = new InventoryBackup();
                inventoryBackup.restore(player);
                player.closeInventory();

            }
            if(current.getType()==Material.RED_STAINED_GLASS_PANE){

                player.closeInventory();

            }

        }
        if(inv.getSize()==18){


            event.setCancelled(true);

            if(current.getType()== Material.ANVIL && current.getItemMeta().getDisplayName().equalsIgnoreCase("§cKick")){


            Bukkit.getPlayerExact(event.getView().getTitle()).kickPlayer("§4You're kicked by Operator");



            }
            if(current.getType()== Material.ANVIL && current.getItemMeta().getDisplayName().equalsIgnoreCase("§4Ban Definitf")){


                player.chat("/ban "+ event.getView().getTitle() + " §4Ban Definitif");



            }
            if(current.getType()== Material.BARRIER){

                Bukkit.getPlayerExact(event.getView().getTitle()).getInventory().clear();

            }
            if(current.getType()== Material.FEATHER){

                player.chat("/effect clear "+    event.getView().getTitle());

            }
            if (current.getType() == Material.APPLE){

                Bukkit.getPlayerExact(event.getView().getTitle()).addPotionEffect(new PotionEffect(PotionEffectType.HEAL,1,200));
                Bukkit.getPlayerExact(event.getView().getTitle()).addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,1,200));


            }
            if(current.getType() == Material.GRASS_BLOCK){

                player.chat("/gmui "+ event.getView().getTitle());
            }
            if(current.getType() == Material.ENDER_EYE){

                PlayerInventory inventory = Bukkit.getPlayerExact(event.getView().getTitle()).getInventory();

                InventorySee inventorySee = new InventorySee(inventory);

                inventorySee.restore(Bukkit.getPlayerExact(event.getView().getTitle()).getDisplayName(),player);

            }


        }
        if(event.getView().getTitle().equalsIgnoreCase("§4Inventory See")){

            event.setCancelled(true);


        }




    }

    public ItemStack getItem(Material material,String customname ){

        ItemStack it = new ItemStack(material, 1);
        ItemMeta itm = it.getItemMeta();
        itm.setDisplayName(customname);
        it.setItemMeta(itm);
        return it;

    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        ItemStack it = event.getPlayer().getInventory().getItemInMainHand();


       if (event.getRightClicked().getType().toString().equalsIgnoreCase("player") && it.getType() == Material.STICK && it.getItemMeta().getDisplayName().equalsIgnoreCase("§3Info Player")){


           player.chat("/info "+ event.getRightClicked().getName());

       }
        if (event.getRightClicked().getType().toString().equalsIgnoreCase("player") && it.getType() == Material.GRASS_BLOCK && it.getItemMeta().getDisplayName().equalsIgnoreCase("§2Gamemode")){


            player.chat("/gmui "+ event.getRightClicked().getName());

        }

    }
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) throws IOException {

        if(event.getView().getTitle().equalsIgnoreCase("§2Backpack")){

            Player player = (Player) event.getPlayer();
            BackPack backPack = new BackPack();
            backPack.Save(player, event.getInventory());



        }
        if(event.getView().getTitle().contains("§2Backpack de §4")){

            Player player = (Player) event.getPlayer();
            SeeBackPack seebackPack = new SeeBackPack();
            seebackPack.Save(Bukkit.getPlayerExact(event.getView().getTitle().replace("§2Backpack de §4", "")), event.getInventory(), player);



        }

    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){

        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("C:\\Users\\maxou\\Desktop\\MC\\Plugins\\spigot\\plugins\\PluginTest\\TpLocation.yml"));


        if(c.get("gameStart") != null){
        if(c.get("gameStart").toString().equalsIgnoreCase("true")) {
            Player p = event.getPlayer();
            if (event.getPlayer().getName().equals(p.getName())) {
                Location to = event.getTo();
                Location from = event.getFrom();
                double fromX = from.getX();
                double fromZ = from.getZ();

                double toX = to.getX();
                double toZ = to.getZ();

                if (fromX != toX || fromZ != toZ) {
                    event.setTo(event.getFrom());
                    return;
                }
            }
        }else{
            return;
        }}else{

            return;

        }
    }

}
