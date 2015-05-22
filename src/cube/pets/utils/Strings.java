package cube.pets.utils;

import org.bukkit.ChatColor;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class Strings {

    public static String prefix = ChatColor.GOLD.toString() + ChatColor.BOLD + "Cube" + ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Pets " + ChatColor.GRAY.toString() + ChatColor.BOLD + " >> ";

    //Menus
    public static String page1 = ChatColor.AQUA + "Page 1";
    public static String page2 = prefix + ChatColor.AQUA + "Page 2";
    public static String modmenu = ChatColor.GREEN + "Pet Modifications";
    public static String equiplore = ChatColor.GREEN.toString() + ChatColor.BOLD + "-" + ChatColor.RESET.toString() + ChatColor.LIGHT_PURPLE.toString() + "Click to equip" + ChatColor.RESET.toString() + ChatColor.GREEN.toString() + ChatColor.BOLD + "-";


    //Pet Modifications
    public static String dismount = prefix + ChatColor.AQUA + "Shift & Punch your pet to dismount!";
    public static String dismounted = prefix + ChatColor.AQUA + "You have dismounted your pet!";
    public static String renamepet = prefix + ChatColor.AQUA + "Please enter the name of your new pet! Under 10 letters.";
    public static String renamesuccessful = prefix + ChatColor.AQUA + "Your pet have been successfully renamed to ";
    public static String petremoved = prefix + ChatColor.AQUA + "Current pet had been disabled!";

    //Misc
    public static String nopet = prefix + ChatColor.RED + "YOU DO NOT HAVE A PET EQUIPPED!";
    public static String mountinglocked = prefix + ChatColor.RED + "You don't have the pet mounting feature unlocked!";
    public static String under10 = prefix + ChatColor.RED + "Please specify your pets name under 10 characters!";


}
