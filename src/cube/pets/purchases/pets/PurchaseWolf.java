package cube.pets.purchases.pets;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import cube.pets.Core;
import cube.pets.managers.PetManager;
import cube.pets.purchases.Purchases;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class PurchaseWolf extends Purchases {

    public PurchaseWolf() {
        super(Material.BONE, 2000, 1005, Core.instance, "Pet Wolf", ChatColor.AQUA + "Test", ChatColor.GOLD + "Test");
    }

    @Override
    public void onConfirmClick(Player p) {
        PetManager.unlockPet(p, "wolf");
        p.sendMessage("Wolf purchased");
    }

    public void showInv(Player p) {
        p.openInventory(getInv());
    }

}