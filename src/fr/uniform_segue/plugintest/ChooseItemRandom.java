package fr.uniform_segue.plugintest;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;


import java.util.Random;

public class ChooseItemRandom {
    Random r = new Random();
    public ItemStack[] chooseItem(){



        int f = r.nextInt(16);

        ItemStack armure1 = null;
        if(f == 0){

            armure1 = getItem(Material.LEATHER_HELMET);

        }else if ( f == 1){

            armure1 = getItem(Material.LEATHER_CHESTPLATE);

        }else if ( f == 2){

            armure1 = getItem(Material.LEATHER_LEGGINGS);

        }else if ( f == 3){

            armure1 = getItem(Material.LEATHER_BOOTS);

        }else if ( f == 4){

            armure1 = getItem(Material.IRON_HELMET);

        }else if ( f == 5){

            armure1 = getItem(Material.IRON_CHESTPLATE);

        }else if ( f == 6){

            armure1 = getItem(Material.IRON_LEGGINGS);

        }else if ( f == 7){

            armure1 = getItem(Material.IRON_BOOTS);

        }else if ( f == 8){

            armure1 = getItem(Material.GOLDEN_HELMET);

        }else if ( f == 9){

            armure1 = getItem(Material.GOLDEN_CHESTPLATE);

        }else if ( f == 10){

            armure1 = getItem(Material.GOLDEN_LEGGINGS);

        }else if ( f == 11){

            armure1 = getItem(Material.GOLDEN_BOOTS);

        }else if ( f == 12){

            armure1 = getItem(Material.CHAINMAIL_HELMET);

        }else if ( f == 13){

            armure1 = getItem(Material.CHAINMAIL_CHESTPLATE);

        }else if ( f == 14){

            armure1 = getItem(Material.CHAINMAIL_LEGGINGS);

        }else if ( f == 15){

            armure1 = getItem(Material.CHAINMAIL_BOOTS);

        }else if ( f == 16){

            armure1 = getItem(Material.DRAGON_HEAD);

        }

        int f1 = r.nextInt(16);

        ItemStack armure11 = null;
        if(f1 == 0){

            armure11 = getItem(Material.LEATHER_HELMET);

        }else if ( f1 == 1){

            armure11 = getItem(Material.LEATHER_CHESTPLATE);

        }else if ( f1 == 2){

            armure11 = getItem(Material.LEATHER_LEGGINGS);

        }else if ( f1 == 3){

            armure11 = getItem(Material.LEATHER_BOOTS);

        }else if ( f1 == 4){

            armure11 = getItem(Material.IRON_HELMET);

        }else if ( f1 == 5){

            armure11 = getItem(Material.IRON_CHESTPLATE);

        }else if ( f1 == 6){

            armure11 = getItem(Material.IRON_LEGGINGS);

        }else if ( f1 == 7){

            armure11 = getItem(Material.IRON_BOOTS);

        }else if ( f1 == 8){

            armure11 = getItem(Material.GOLDEN_HELMET);

        }else if ( f1 == 9){

            armure11 = getItem(Material.GOLDEN_CHESTPLATE);

        }else if ( f1 == 10){

            armure11 = getItem(Material.GOLDEN_LEGGINGS);

        }else if ( f1 == 11){

            armure11 = getItem(Material.GOLDEN_BOOTS);

        }else if ( f1 == 12){

            armure11 = getItem(Material.CHAINMAIL_HELMET);

        }else if ( f1 == 13){

            armure11 = getItem(Material.CHAINMAIL_CHESTPLATE);

        }else if ( f1 == 14){

            armure11 = getItem(Material.CHAINMAIL_LEGGINGS);

        }else if ( f1 == 15){

            armure11 = getItem(Material.CHAINMAIL_BOOTS);

        }else if ( f1 == 16){

            armure11 = getItem(Material.DRAGON_HEAD);

        }


        int a = r.nextInt(6);

        ItemStack arme = null;
        if(a == 0){

            arme = getItem(Material.IRON_SWORD);


        }else if(a == 6){

            arme = getItem(Material.WOODEN_AXE);
        }else if(a ==1){

            arme = getItem(Material.WOODEN_SWORD);

        }else if(a == 2){

            arme = getItem(Material.STONE_SWORD);
        }else if(a == 3){

            arme = getItem(Material.BOW);
        }else if(a == 4){

            arme = getItem(Material.FISHING_ROD);
        }else if(a == 5){

            arme = getItem(Material.IRON_PICKAXE);
        }

        int u = r.nextInt(14);
        ItemStack utilitaire = null;

        if ( u == 0){

            utilitaire = getItemUti(Material.STICK);


        }else if( u == 1){

            utilitaire = getItemUti(Material.IRON_INGOT);

        }else if( u == 2){

            utilitaire = getItemUti(Material.STRING);

        }else if( u == 3){

            utilitaire = getItemUti(Material.FLINT);

        }else if( u == 4){

            utilitaire = getItemUti(Material.FEATHER);

        }else if( u == 5){

            utilitaire = getItemUti(Material.ARROW);

        }else if( u == 6){

            utilitaire = getItemUti(Material.COOKED_BEEF);

        }else if( u == 7){

            utilitaire = getItemUti(Material.GOLDEN_APPLE);

        }else if( u == 8){

            Potion splash = new Potion(PotionType.INSTANT_HEAL, 1);
            splash.setSplash(true);
            utilitaire = splash.toItemStack(1);


        }else if( u == 9){

            Potion splash = new Potion(PotionType.SPEED, 1);
            utilitaire = splash.toItemStack(1);

        }else if( u == 10){

            Potion splash = new Potion(PotionType.REGEN, 2);
            utilitaire = splash.toItemStack(1);

        }else if( u == 11){

            Potion splash = new Potion(PotionType.INSTANT_HEAL, 1);
            utilitaire = splash.toItemStack(1);

        }else if( u == 12){

            utilitaire = getItemUti(Material.SPYGLASS);

        }else if( u == 13){

            utilitaire = getItemUti(Material.FLINT_AND_STEEL);

        }else if( u == 14){

            utilitaire = getItemUti(Material.EXPERIENCE_BOTTLE);

        }

        int u1 = r.nextInt(14);
        ItemStack utilitaire1 = null;

        if ( u1 == 0){

            utilitaire1 = getItemUti(Material.STICK);


        }else if( u1 == 1){

            utilitaire1 = getItemUti(Material.IRON_INGOT);

        }else if( u1 == 2){

            utilitaire1 = getItemUti(Material.STRING);

        }else if( u1 == 3){

            utilitaire1 = getItemUti(Material.FLINT);

        }else if( u1 == 4){

            utilitaire1 = getItemUti(Material.FEATHER);

        }else if( u1 == 5){

            utilitaire1 = getItemUti(Material.ARROW);

        }else if( u1 == 6){

            utilitaire1 = getItemUti(Material.COOKED_BEEF);

        }else if( u1 == 7){

            utilitaire1 = getItemUti(Material.GOLDEN_APPLE);

        }else if( u1 == 8){

            Potion splash = new Potion(PotionType.INSTANT_HEAL, 1);
            splash.setSplash(true);
            utilitaire1 = splash.toItemStack(1);


        }else if( u1 == 9){

            Potion splash = new Potion(PotionType.SPEED, 1);
            utilitaire1 = splash.toItemStack(1);

        }else if( u1 == 10){

            Potion splash = new Potion(PotionType.REGEN, 2);
            utilitaire1 = splash.toItemStack(1);

        }else if( u1 == 11){

            Potion splash = new Potion(PotionType.INSTANT_HEAL, 1);
            utilitaire1 = splash.toItemStack(1);

        }else if( u1 == 12){

            utilitaire1 = getItemUti(Material.SPYGLASS);

        }else if( u1 == 13){

            utilitaire1 = getItemUti(Material.FLINT_AND_STEEL);

        }else if( u1 == 14){

            utilitaire1 = getItemUti(Material.EXPERIENCE_BOTTLE);

        }


        ItemStack[] itemsInChests = {armure1,armure11, arme, utilitaire,utilitaire1};

        return itemsInChests;
    }

    public org.bukkit.inventory.ItemStack getItem(Material material){

        ItemStack it = new ItemStack(material, 1);
        ItemMeta itm = it.getItemMeta();
        itm.setUnbreakable(true);
        it.setItemMeta(itm);
        return it;

    }

    public org.bukkit.inventory.ItemStack getItemUti(Material material){

        ItemStack it = new ItemStack(material,r.nextInt(3)+1 );
        ItemMeta itm = it.getItemMeta();
        itm.setUnbreakable(true);
        it.setItemMeta(itm);
        return it;

    }

}
