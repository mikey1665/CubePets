package cube.pets.api;

import cube.pets.Core;
import net.minecraft.server.v1_8_R2.AttributeInstance;
import net.minecraft.server.v1_8_R2.EntityInsentient;
import net.minecraft.server.v1_8_R2.GenericAttributes;
import net.minecraft.server.v1_8_R2.PathEntity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftEntity;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class Pet{

    public static HashMap<UUID, Entity> pet = new HashMap<UUID, Entity>();

    //Check for a pet
    public static boolean hasPet(Player p) {
        if (pet.containsKey(p.getUniqueId())) {
            return true;
        }
        return false;
    }

    //If the type equals
    public static boolean petIs(Player p, EntityType e) {
        if(hasPet(p)) {
            return ((Entity)pet.get(p.getUniqueId())).getType().equals(e);
        }
        return false;
    }

    //If pet is a baby
    public static boolean isBaby(Player p) {
        if (!hasPet(p)) return false;
        LivingEntity ent = (LivingEntity) pet.get(p.getUniqueId());
        if (ent instanceof Ageable == false) return false;
        return !((Ageable)ent).isAdult();
    }

    //Setting Age
    public static void setAge(Player p, String s) {
        if(hasPet(p)) {
            Entity ent = (Entity) pet.get(p.getUniqueId());
                if(ent instanceof  Ageable) {
                    if (s.equals("adult")) {
                        ((Ageable) ent).setAdult();
                    } else if (s.equals("baby")) {
                        ((Ageable) ent).setBaby();
                    }
                }
        }
    }

    //Getting the pet
    public static Entity getPet(Player p) {
        return pet.get(p.getUniqueId());
    }

    //Removing the pet
    public static void removePet(Player p) {
        if (hasPet(p)) {
            ((Entity) pet.get(p.getUniqueId())).remove();
            pet.remove(p.getUniqueId());
        }
    }

    //Pet Follow
    public static void PetFollow(final Player player , final Entity pet , final double speed){
        new BukkitRunnable(){
            public void run(){
                if ((!pet.isValid() || (!player.isOnline()))){
                    this.cancel();}
                net.minecraft.server.v1_8_R2.Entity pett = ((CraftEntity) pet).getHandle();
                ((EntityInsentient) pett).getNavigation().a(2);
                Object petf = ((CraftEntity) pet).getHandle();
                Location targetLocation = player.getLocation();
                PathEntity path;
                path = ((EntityInsentient) petf).getNavigation().a(targetLocation.getX() + 1, targetLocation.getY(), targetLocation.getZ() + 1);
                if (path != null) {
                    ((EntityInsentient) petf).getNavigation().a(path, 1.0D);
                    ((EntityInsentient) petf).getNavigation().a(2.0D);}
                int distance = (int) Bukkit.getPlayer(player.getName()).getLocation().distance(pet.getLocation());
                if (distance > 10 && !pet.isDead() && player.isOnGround()) {
                    pet.teleport(player.getLocation());}
                AttributeInstance attributes = ((EntityInsentient)((CraftEntity)pet).getHandle()).getAttributeInstance(GenericAttributes.d);
                attributes.setValue(speed);}}.runTaskTimer(Core.getInstance(), 0L, 20L);}
}
