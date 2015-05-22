package cube.pets.purchases;

import cube.pets.utils.Strings;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public abstract class Purchases implements Listener {

    public abstract void onConfirmClick(Player p);

    private JavaPlugin plugin;
    private Material itemMaterial;
    private int gemPrice;
    private int inventoryStackSize;
    private Inventory inv;
    private String inventoryName = "            Confirmation";
    public ItemStack ok, cancel, price, item;
    private String itemName;
    private String[] itemLore;

    public Purchases(Material itemMaterial, int gemPrice, int inventoryStackSize, JavaPlugin plugin, String itemName, String... itemLore) {
        this.setItemMaterial(itemMaterial);
        this.setGemPrice(gemPrice);
        this.setInventoryStackSize(inventoryStackSize);
        this.setPlugin(plugin);
        this.setItemName(itemName);
        this.setItemLore(itemLore);
        createInventory();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void createInventory() {
        this.inv = plugin.getServer().createInventory(null, 54, inventoryName);
        this.inv.setMaxStackSize(inventoryStackSize);
        ok = createItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "OK");
        cancel = createItem(Material.REDSTONE_BLOCK, ChatColor.RED + "CANCEL");
        price = createItem(Material.DIAMOND, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems");
        item = createItem(getItemMaterial(), ChatColor.GREEN + "" + ChatColor.BOLD + getItemName());
        buildInvSquare();
    }

    private ItemStack createItem(Material mat, String name) {
        ItemStack i = new ItemStack(mat, 1);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(name);
        if (name.equalsIgnoreCase(ChatColor.GREEN + "" + ChatColor.BOLD + "Gems"))
            im.setLore(Arrays.asList(ChatColor.GRAY + "" + gemPrice + " Gems will be deducted from your account balance."));
        if (name.equalsIgnoreCase(ChatColor.GREEN + "" + ChatColor.BOLD + getItemName()))
            im.setLore(Arrays.asList(getItemLore()));
        i.setItemMeta(im);
        return i;
    }

    public void buildInvSquare() {
        inv.setItem(4, price);
        inv.setItem(22, item);
        int ok = 27;
        for (int i = 0; i <9; i++) {
            if (i == 3) ok = 36;
            if (i == 6) ok = 45;
            inv.setItem(ok++, this.ok);
        }
        int no = 33;
        for (int i = 0; i < 9; i++) {
            if (i == 3) no = 42;
            if (i == 6) no = 51;
            inv.setItem(no++, this.cancel);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().getMaxStackSize() == getInventoryStackSize()) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (!e.getInventory().getName().equalsIgnoreCase(getInventoryName()))
                return;
            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
                e.setCancelled(true);
                return;
            }
            if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("ok")) {
                e.setCancelled(true);
                p.closeInventory();
                onConfirmClick(p);
                return;

            }
            if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("cancel")) {
                e.setCancelled(true);
                p.closeInventory();
                return;
            }
        }
    }

    public String getLowGemMsg() {
        return Strings.prefix + ChatColor.GRAY + "You do not have enough" + ChatColor.GREEN + " Gems"     + ChatColor.GRAY + ".";
    }

    public Material getItemMaterial() {
        return itemMaterial;
    }

    public void setItemMaterial(Material itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    public int getGemPrice() {
        return gemPrice;
    }

    public void setGemPrice(int gemPrice) {
        this.gemPrice = gemPrice;
    }

    public int getInventoryStackSize() {
        return inventoryStackSize;
    }

    public void setInventoryStackSize(int inventoryStackSize) {
        this.inventoryStackSize = inventoryStackSize;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public void setPlugin(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public String[] getItemLore() {
        return itemLore;
    }

    public void setItemLore(String[] itemLore) {
        this.itemLore = itemLore;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Inventory getInv() {
        return inv;
    }

}