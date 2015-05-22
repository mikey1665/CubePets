package cube.pets.menu.click;

import cube.pets.api.Pet;
import cube.pets.api.SpawnPet;
import cube.pets.managers.ModificationManager;
import cube.pets.menu.Modifications;
import cube.pets.menu.Page1;
import cube.pets.modifications.MountPet;
import cube.pets.modifications.NamingPet;
import cube.pets.purchases.pets.*;
import cube.pets.utils.Strings;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.rmi.Naming;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class ModificationsClick implements Listener{

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        try {
            if (event.getInventory().getName().equalsIgnoreCase(Strings.modmenu)) {
                event.setCancelled(true);
                ItemStack stack = event.getCurrentItem();
                if (stack == null) {
                    stack = event.getCursor();
                }
                if (stack == null) {
                    System.out.println("Item is null");
                    return;
                }
                if (!event.getCurrentItem().hasItemMeta()) {
                    return;
                }

                String item = ChatColor.stripColor(stack.getItemMeta().getDisplayName()).toLowerCase();

                if (item.equals("pet hat")) {
                    MountPet.mountPet(p);
                    ModificationManager.unlockAddon(p, "mountpet");
                    p.closeInventory();
                    return;
                }
                if (item.equals("re-name pet")) {
                    NamingPet.renamePet(p);
                    p.closeInventory();
                    return;
                }
                if (item.equals("go back")) {
                    p.openInventory(Page1.cosmenu(p));
                    return;
                }
            }
        } catch (Exception localException) {
        }
    }
}
