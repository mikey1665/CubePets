package cube.pets.modifications;

import cube.pets.api.Pet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class PetClick implements Listener{

    @EventHandler
     public void mountPet(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            switch (Pet.getPet(e.getPlayer()).getType()) {
                case BAT:
                    e.getPlayer().sendMessage("Pet is a bat");
                    break;
                case COW:
                    e.getPlayer().sendMessage("Pet is a cow");
                    break;
                case PIG:
                    e.getPlayer().sendMessage("Pet is a pig");
                    break;
                case SHEEP:
                    e.getPlayer().sendMessage("Pet is a sheep");
                    break;
                case CHICKEN:
                    e.getPlayer().sendMessage("Pet is a chicken");
                    break;
                default:
                    e.getPlayer().sendMessage("Player doesn't have a known pet.");
                    break;
            }
        }
    }
}
