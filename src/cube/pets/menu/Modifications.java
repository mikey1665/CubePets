package cube.pets.menu;

import cube.pets.managers.ModificationManager;
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
public class Modifications implements Listener{

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
        Inventory cosmenu = Bukkit.createInventory(null, 9 * 2, Strings.modmenu);

        List<DyeColor> discoColours = Arrays.asList(DyeColor.RED, DyeColor.ORANGE, DyeColor.YELLOW, DyeColor.GREEN, DyeColor.BLUE, DyeColor.LIGHT_BLUE, DyeColor.PINK, DyeColor.MAGENTA, DyeColor.LIME, DyeColor.CYAN, DyeColor.PURPLE, DyeColor.BLACK, DyeColor.WHITE);
        Random r = new Random();
        DyeColor dyeColor = discoColours.get(r.nextInt(discoColours.size()));

        for (int i = 0; i < cosmenu.getSize(); i++) {
            ItemStack stainedglass = new ItemStack(Material.STAINED_GLASS_PANE, 1 , dyeColor.getData());
            ItemMeta glassmeta = stainedglass.getItemMeta();
            glassmeta.setDisplayName(" ");
            stainedglass.setItemMeta(glassmeta);
            cosmenu.setItem(i, stainedglass);
        }

        cosmenu.setItem(4, ItemTools.setName(new ItemStack(Material.BOOK), ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Go Back",
                new String[] {
                        "",
                        ChatColor.WHITE + "Click to go back.",
                        "" }));

        cosmenu.setItem(9, ItemTools.setName(new ItemStack(Material.PUMPKIN), ChatColor.GREEN + "" + ChatColor.BOLD + "Pet Hat",
                new String[] {
                        "",
                        ChatColor.AQUA + "Want to look cool?",
                        ChatColor.RED + "Click to make your pet sit on you!",
                        "",
                        ChatColor.LIGHT_PURPLE.toString() + "This feature is: ",
                        ModificationManager.hasUnlockedAddon(p, "pethat") ? ChatColor.GREEN.toString() + ChatColor.BOLD + "Unlocked" : ChatColor.RED.toString() + ChatColor.BOLD + "Locked",
                        "",
                        ModificationManager.hasUnlockedAddon(p, "pethat") ? "" : ChatColor.AQUA.toString() + "Costs: " + ChatColor.GREEN.toString() + ChatColor.BOLD + "30 Gems",
                        "" }));

        cosmenu.setItem(10, ItemTools.setName(new ItemStack(Material.NAME_TAG), ChatColor.GREEN + "" + ChatColor.BOLD + "Re-Name Pet",
                new String[]{
                        "",
                        ChatColor.AQUA + "Love your pet so much?",
                        ChatColor.RED + "Click to rename your pet!",
                        "",
                        ChatColor.YELLOW + "Resets when you leave!",
                        "",
                        ChatColor.LIGHT_PURPLE.toString() + "This feature is: ",
                        ModificationManager.hasUnlockedAddon(p, "namepet") ? ChatColor.GREEN.toString() + ChatColor.BOLD + "Unlocked" : ChatColor.RED.toString() + ChatColor.BOLD + "Locked",
                        "",
                        ModificationManager.hasUnlockedAddon(p, "namepet") ? "" : ChatColor.AQUA.toString() + "Costs: " + ChatColor.GREEN.toString() + ChatColor.BOLD + "50 Gems",
                        ""}));
        return cosmenu;
    }
}
