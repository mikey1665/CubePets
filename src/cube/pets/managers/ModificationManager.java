package cube.pets.managers;

import cube.pets.Core;
import org.bukkit.OfflinePlayer;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class ModificationManager {

    private static Core plugin;

    public static void initialize(){
        ModificationManager.plugin = Core.getInstance();
    }

    public static boolean hasUnlockedAddon(OfflinePlayer p, String addon) {
        return plugin.getConfig().getBoolean(p.getPlayer().getUniqueId() + "." + addon);
    }

    public static void unlockAddon(OfflinePlayer p, String addon) {
        plugin.getConfig().set(p.getPlayer().getUniqueId() + "." + addon, true);
        plugin.saveConfig();
    }
}
