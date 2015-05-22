package cube.pets.modifications;

import java.util.ArrayList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import cube.pets.api.Pet;
import cube.pets.managers.ModificationManager;
import cube.pets.utils.Strings;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class MountPet implements Listener{

    public static ArrayList<String> unmount = new ArrayList<>();

    public static void mountPet(Player p) {
        if(Pet.hasPet(p)) {
            Entity ent = ((Entity) Pet.pet.get(p.getUniqueId()));
            p.setPassenger(ent);
            unmount.add(p.getName());
            p.sendMessage(Strings.dismount);
        } else {
            p.sendMessage(Strings.nopet);
        }
    }

    @EventHandler
    public void unmountPet(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK){
            if(e.getPlayer().isSneaking()) {
                if(unmount.contains(e.getPlayer().getName())) {
                    e.getPlayer().sendMessage(Strings.dismounted);
                    Entity ent = ((Entity) Pet.pet.get(e.getPlayer().getUniqueId()));
                    ent.eject();
                    e.getPlayer().eject();
                    unmount.remove(e.getPlayer().getName());
                }
            }
        }
    }

    @EventHandler
    public void mountPet(PlayerInteractEntityEvent e) {
            if (e.getPlayer().isSneaking()) {
                if(ModificationManager.hasUnlockedAddon(e.getPlayer(), "mountpet")) {
                    if(Pet.hasPet(e.getPlayer())) {
                        Entity ent = ((Entity) Pet.pet.get(e.getPlayer().getUniqueId()));
                        e.getPlayer().setPassenger(ent);
                        unmount.add(e.getPlayer().getName());
                        e.getPlayer().sendMessage(Strings.dismount);
                    }
                } else {
                    e.getPlayer().sendMessage(Strings.mountinglocked);
            }
        }
    }

    //Handling memory leaks
    @EventHandler
    public void removePlayer(PlayerQuitEvent e) {
        if(unmount.contains(e.getPlayer().getName())) {
            unmount.remove(e.getPlayer().getName());
        }
    }
}
