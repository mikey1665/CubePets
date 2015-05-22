package cube.pets.api;

import cube.pets.managers.PetManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class SpawnPet {

    public static void spawnPet(Player p, EntityType entity, String pet) {
        if (PetManager.hasUnlockedPet(p, pet)) {
            Pet.removePet(p);
            Entity ent = p.getWorld().spawnEntity(p.getLocation(), entity);
            ent.setCustomName(ChatColor.AQUA.toString() + ChatColor.BOLD + p.getPlayer().getName().toString() + "'s " + pet + " pet!");
            ent.setCustomNameVisible(true);
            Pet.pet.put(p.getUniqueId(), ent);
            Pet.PetFollow(p, ent, 0.3D);
        }
    }
}
