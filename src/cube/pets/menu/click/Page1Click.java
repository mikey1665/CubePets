package cube.pets.menu.click;

import com.sun.org.apache.xpath.internal.operations.Mod;
import cube.pets.api.Pet;
import cube.pets.api.SpawnPet;
import cube.pets.menu.Modifications;
import cube.pets.purchases.Purchases;
import cube.pets.purchases.pets.*;
import cube.pets.utils.Strings;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class Page1Click implements Listener{

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        try {
            if (event.getInventory().getName().equalsIgnoreCase(Strings.page1)) {
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

                if (item.equals("pig")) {
                    new PurchasePig().showInv(p);
                    return;
                }
                if (item.equals("pig pet")) {
                    SpawnPet.spawnPet(p, EntityType.PIG, "pig");
                    return;
                }
                if (item.equals("cow")) {
                    new PurchaseCow().showInv(p);
                    return;
                }
                if (item.equals("cow pet")) {
                    SpawnPet.spawnPet(p, EntityType.COW, "cow");
                    return;
                }
                if (item.equals("sheep")) {
                    new PurchaseSheep().showInv(p);
                    return;
                }
                if (item.equals("sheep pet")) {
                    SpawnPet.spawnPet(p, EntityType.SHEEP, "sheep");
                    return;
                }
                if (item.equals("chicken")) {
                    new PurchaseChicken().showInv(p);
                    return;
                }
                if (item.equals("chicken pet")) {
                    SpawnPet.spawnPet(p, EntityType.CHICKEN, "chicken");
                    return;
                }
                if (item.equals("wolf")) {
                    new PurchaseWolf().showInv(p);
                    return;
                }
                if (item.equals("wolf pet")) {
                    SpawnPet.spawnPet(p, EntityType.WOLF, "wolf");
                    return;
                }
                if (item.equals("mooshroom")) {
                    new MooshroomCow().showInv(p);
                    return;
                }
                if (item.equals("mooshroom pet")) {
                    SpawnPet.spawnPet(p, EntityType.MUSHROOM_COW, "mooshroom");
                    return;
                }
                if (item.equals("pet modifier")) {
                    p.openInventory(Modifications.cosmenu(p));
                    return;
                }
                if (item.equals("remove pet")) {
                    Pet.removePet(p);
                    p.sendMessage(Strings.petremoved);
                    return;
                }
            }
        } catch (Exception localException) {
        }
    }
}
