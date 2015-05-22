package cube.pets.managers;

import org.bukkit.OfflinePlayer;

import cube.pets.Core;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class PetManager {

    private static Core plugin;

    public static void initialize(){
        PetManager.plugin = Core.getInstance();
    }

    public static boolean hasUnlockedPet(OfflinePlayer p, String pet) {
        return plugin.getConfig().getBoolean(p.getPlayer().getUniqueId() + "." + pet);
    }

    public static void unlockPet(OfflinePlayer p, String pet) {
        plugin.getConfig().set(p.getPlayer().getUniqueId() + "." + pet, true);
        plugin.saveConfig();
    }
}
