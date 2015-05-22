package cube.pets.commands;

import cube.pets.menu.Modifications;
import cube.pets.menu.Page1;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class PetMenu implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();
            p.openInventory(Page1.cosmenu(p));
        } else {
            System.out.println(ChatColor.RED + "You're not a player?");
        }
        return false;
    }
}
