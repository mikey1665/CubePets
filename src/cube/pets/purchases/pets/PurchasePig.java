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
public class PurchasePig extends Purchases {

    public PurchasePig() {
        super(Material.PORK, 2000, 1005, Core.instance, "Pet pig", ChatColor.AQUA + "Test", ChatColor.GOLD + "Test");
    }

    @Override
    public void onConfirmClick(Player p) {
        PetManager.unlockPet(p, "pig");
        p.sendMessage("Pig purchased");
    }

    public void showInv(Player p) {
        p.openInventory(getInv());
    }

}
