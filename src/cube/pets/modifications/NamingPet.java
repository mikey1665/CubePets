package cube.pets.modifications;

import cube.pets.api.Pet;
import cube.pets.utils.Strings;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class NamingPet implements Listener{

    public static ArrayList<String> rename = new ArrayList<>();

    public static void renamePet(Player p) {
        if(Pet.hasPet(p)) {
            rename.add(p.getName());
            p.sendMessage(Strings.renamepet);
        } else {
            p.sendMessage(Strings.nopet);
        }
    }

    @EventHandler
    public static void renamer(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if(Pet.hasPet(p)) {
            if(rename.contains(p.getName())) {
                if(e.getMessage().length() < 10) {
                    Entity ent = ((Entity) Pet.pet.get(p.getUniqueId()));
                    ent.setCustomName(ChatColor.GREEN.toString() + ChatColor.BOLD + e.getMessage());
                    e.setCancelled(true);
                    p.sendMessage(Strings.renamesuccessful + e.getMessage());
                    rename.remove(p.getName());
                } else {
                    p.sendMessage(Strings.under10);
                }
            }
        }
    }
}
