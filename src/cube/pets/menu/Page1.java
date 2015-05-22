package cube.pets.menu;

import cube.pets.managers.PetManager;
import cube.pets.utils.ItemTools;
import cube.pets.utils.Strings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class Page1 implements Listener{

    public static ItemStack createItem(Material material, int amount,
                                       short shrt, String displayname, String lore) {
        ItemStack item = new ItemStack(material, amount, shrt);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayname);
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(lore);
        meta.setLore(Lore);
        item.setItemMeta(meta);
        return item;
    }

    public static Inventory cosmenu(Player p) {
        Inventory cosmenu = Bukkit.createInventory(null, 9 * 6, Strings.page1);

        List<DyeColor> discoColours = Arrays.asList(DyeColor.RED, DyeColor.ORANGE, DyeColor.YELLOW, DyeColor.GREEN, DyeColor.BLUE, DyeColor.LIGHT_BLUE, DyeColor.PINK, DyeColor.MAGENTA, DyeColor.LIME, DyeColor.CYAN, DyeColor.PURPLE, DyeColor.BLACK, DyeColor.WHITE);
        Random r = new Random();
        DyeColor dyeColor = discoColours.get(r.nextInt(discoColours.size()));

        for (int i = 0; i < cosmenu.getSize(); i++) {
            ItemStack stainedglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, dyeColor.getData());
            ItemMeta glassmeta = stainedglass.getItemMeta();
            glassmeta.setDisplayName(" ");
            stainedglass.setItemMeta(glassmeta);
            cosmenu.setItem(i, stainedglass);
        }

        cosmenu.setItem(3, ItemTools.setName(new ItemStack(Material.ARMOR_STAND), ChatColor.GREEN + "" + ChatColor.BOLD + "Pet Modifier",
                new String[]{
                        "",
                        ChatColor.WHITE + "Click to modify your pet!",
                        ""}));

        cosmenu.setItem(4, ItemTools.setName(new ItemStack(Material.BOOK), ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Go Back",
                new String[]{
                        "",
                        ChatColor.WHITE + "Click to go back.",
                        ""}));

        cosmenu.setItem(5, ItemTools.setName(new ItemStack(Material.ARROW), ChatColor.RED + "" + ChatColor.BOLD + "Page 2",
                new String[]{
                        "",
                        ChatColor.WHITE + "Click to go to page 2",
                        ""}));

        cosmenu.setItem(49, ItemTools.setName(new ItemStack(Material.BONE), ChatColor.DARK_RED + "" + ChatColor.BOLD + "Remove Pet",
                new String[]{
                        "",
                        ChatColor.WHITE + "Click to remove your pet.",
                        ""}));

        // Friendly Animals
        if (PetManager.hasUnlockedPet(p, "cow")) {
            ItemStack pet = new ItemStack(Material.MONSTER_EGG, 1, (short) 92);
            ItemMeta petmeta = pet.getItemMeta();
            petmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Cow Pet");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Cow Unlocked!");
            lore.add(Strings.equiplore);
            petmeta.setLore(lore);
            pet.setItemMeta(petmeta);
            cosmenu.setItem(20, pet);
        } else {
            ItemStack notunlocked = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta lockedmeta = notunlocked.getItemMeta();
            lockedmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Cow");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Grants access to use the Cow pet.");
            lore.add(" ");
            lore.add(ChatColor.BLUE.toString() + "Rank Required: " + ChatColor.GRAY.toString() + ChatColor.BOLD + "None");
            lore.add(" ");
            lore.add(ChatColor.AQUA.toString() + "Costs: " + ChatColor.GREEN.toString() + ChatColor.BOLD + "180 Gems");
            lockedmeta.setLore(lore);
            notunlocked.setItemMeta(lockedmeta);
            cosmenu.setItem(20, notunlocked);
        }

        if (PetManager.hasUnlockedPet(p, "pig")) {
            ItemStack pet = new ItemStack(Material.MONSTER_EGG, 1, (short) 90);
            ItemMeta petmeta = pet.getItemMeta();
            petmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Pig Pet");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Pig Unlocked!");
            lore.add(Strings.equiplore);
            petmeta.setLore(lore);
            pet.setItemMeta(petmeta);
            cosmenu.setItem(21, pet);
        } else {
            ItemStack notunlocked = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta lockedmeta = notunlocked.getItemMeta();
            lockedmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Pig");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Grants access to use the Pig pet.");
            lore.add(" ");
            lore.add(ChatColor.BLUE.toString() + "Rank Required: " + ChatColor.GRAY.toString() + ChatColor.BOLD + "None");
            lore.add(" ");
            lore.add(ChatColor.AQUA.toString() + "Costs: " + ChatColor.GREEN.toString() + ChatColor.BOLD + "180 Gems");
            lockedmeta.setLore(lore);
            notunlocked.setItemMeta(lockedmeta);
            cosmenu.setItem(21, notunlocked);
        }

        if (PetManager.hasUnlockedPet(p, "sheep")) {
            ItemStack pet = new ItemStack(Material.MONSTER_EGG, 1, (short) 91);
            ItemMeta petmeta = pet.getItemMeta();
            petmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Sheep Pet");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Sheep Unlocked!");
            lore.add(Strings.equiplore);
            petmeta.setLore(lore);
            pet.setItemMeta(petmeta);
            cosmenu.setItem(22, pet);
        } else {
            ItemStack notunlocked = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta lockedmeta = notunlocked.getItemMeta();
            lockedmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Sheep");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Grants access to use the Sheep pet.");
            lore.add(" ");
            lore.add(ChatColor.BLUE.toString() + "Rank Required: " + ChatColor.GRAY.toString() + ChatColor.BOLD + "None");
            lore.add(" ");
            lore.add(ChatColor.AQUA.toString() + "Costs: " + ChatColor.GREEN.toString() + ChatColor.BOLD + "180 Gems");
            lockedmeta.setLore(lore);
            notunlocked.setItemMeta(lockedmeta);
            cosmenu.setItem(22, notunlocked);
        }

        if (PetManager.hasUnlockedPet(p, "chicken")) {
            ItemStack pet = new ItemStack(Material.MONSTER_EGG, 1, (short) 93);
            ItemMeta petmeta = pet.getItemMeta();
            petmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Chicken Pet");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Chicken Unlocked!");
            lore.add(Strings.equiplore);
            petmeta.setLore(lore);
            pet.setItemMeta(petmeta);
            cosmenu.setItem(23, pet);
        } else {
            ItemStack notunlocked = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta lockedmeta = notunlocked.getItemMeta();
            lockedmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Chicken");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Grants access to use the Chicken pet.");
            lore.add(" ");
            lore.add(ChatColor.BLUE.toString() + "Rank Required: " + ChatColor.GRAY.toString() + ChatColor.BOLD + "None");
            lore.add(" ");
            lore.add(ChatColor.AQUA.toString() + "Costs: " + ChatColor.GREEN.toString() + ChatColor.BOLD + "150 Gems");
            lockedmeta.setLore(lore);
            notunlocked.setItemMeta(lockedmeta);
            cosmenu.setItem(23, notunlocked);
        }

        if (PetManager.hasUnlockedPet(p, "wolf")) {
            ItemStack pet = new ItemStack(Material.MONSTER_EGG, 1, (short) 95);
            ItemMeta petmeta = pet.getItemMeta();
            petmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Wolf Pet");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Wolf Unlocked!");
            lore.add(Strings.equiplore);
            petmeta.setLore(lore);
            pet.setItemMeta(petmeta);
            cosmenu.setItem(24, pet);
        } else {
            ItemStack notunlocked = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta lockedmeta = notunlocked.getItemMeta();
            lockedmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Wolf");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Grants access to use the Wolf pet.");
            lore.add(" ");
            lore.add(ChatColor.BLUE.toString() + "Rank Required: " + ChatColor.GRAY.toString() + ChatColor.BOLD + "None");
            lore.add(" ");
            lore.add(ChatColor.AQUA.toString() + "Costs: " + ChatColor.GREEN.toString() + ChatColor.BOLD + "200 Gems");
            lockedmeta.setLore(lore);
            notunlocked.setItemMeta(lockedmeta);
            cosmenu.setItem(24, notunlocked);
        }

        if (PetManager.hasUnlockedPet(p, "mooshroom")) {
            ItemStack pet = new ItemStack(Material.MONSTER_EGG, 1, (short) 96);
            ItemMeta petmeta = pet.getItemMeta();
            petmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Mooshroom Pet");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Mooshroom Unlocked!");
            lore.add(Strings.equiplore);
            petmeta.setLore(lore);
            pet.setItemMeta(petmeta);
            cosmenu.setItem(29, pet);
        } else {
            ItemStack notunlocked = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta lockedmeta = notunlocked.getItemMeta();
            lockedmeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Mooshroom");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.YELLOW + "Grants access to use the Mooshroom pet.");
            lore.add(" ");
            lore.add(ChatColor.BLUE.toString() + "Rank Required: " + ChatColor.GRAY.toString() + ChatColor.BOLD + "None");
            lore.add(" ");
            lore.add(ChatColor.AQUA.toString() + "Costs: " + ChatColor.GREEN.toString() + ChatColor.BOLD + "180 Gems");
            lockedmeta.setLore(lore);
            notunlocked.setItemMeta(lockedmeta);
            cosmenu.setItem(29, notunlocked);
        }
        return cosmenu;
    }
}
