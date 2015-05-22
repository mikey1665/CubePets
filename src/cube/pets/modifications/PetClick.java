package cube.pets.modifications;

import cube.pets.api.Pet;
import cube.pets.managers.ModificationManager;
import cube.pets.utils.Strings;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class PetClick implements Listener{

    @EventHandler
    public void mountPet(PlayerInteractEntityEvent e) {
            switch (Pet.getPet(e.getPlayer()).getType()){
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
                
        }
    }
}
