package cube.pets;

import cube.pets.api.Pet;
import cube.pets.commands.PetMenu;
import cube.pets.managers.ModificationManager;
import cube.pets.managers.PetManager;
import cube.pets.menu.Modifications;
import cube.pets.menu.Page1;
import cube.pets.menu.click.ModificationsClick;
import cube.pets.menu.click.Page1Click;
import cube.pets.modifications.MountPet;
import cube.pets.modifications.NamingPet;
import cube.pets.modifications.PetClick;
import cube.pets.purchases.Purchases;
import cube.pets.purchases.pets.PurchasePig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class Core extends JavaPlugin{


    public static Core instance;

    @Override
    public void onEnable() {
        instance = this;
        PetManager.initialize();
        ModificationManager.initialize();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Page1(), this);
        pm.registerEvents(new Page1Click(), this);
        pm.registerEvents(new MountPet(), this);
        pm.registerEvents(new NamingPet(), this);
        pm.registerEvents(new PetClick(), this);
        pm.registerEvents(new ModificationsClick(), this);
        pm.registerEvents(new Modifications(), this);

        getCommand("petmenu").setExecutor(new PetMenu());

        this.getLogger().info("[Pets] Has been enabled!");
    }

    @Override
    public void onDisable() {

        this.getLogger().info("[Pets] Has been disabled!");
        saveFile();
        for(Player p: Bukkit.getServer().getOnlinePlayers()) {
            if(Pet.hasPet(p)) {
                Pet.removePet(p);
            }
        }
    }

    public static Core getInstance() {
        return instance;
    }

    public void saveFile() {
        this.saveConfig();
    }
}
