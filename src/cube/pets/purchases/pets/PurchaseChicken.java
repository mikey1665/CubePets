package cube.pets.purchases.pets;

import cube.pets.Core;
import cube.pets.managers.PetManager;
import cube.pets.purchases.Purchases;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class PurchaseChicken extends Purchases {

    public PurchaseChicken() {
        super(Material.RAW_CHICKEN, 2000, 1005, Core.instance, "Pet Chicken", ChatColor.AQUA + "Test", ChatColor.GOLD + "Test");
    }

    @Override
    public void onConfirmClick(Player p) {
        PetManager.unlockPet(p, "chicken");
        p.sendMessage("Chicken purchased");
    }

    public void showInv(Player p) {
        p.openInventory(getInv());
    }

}