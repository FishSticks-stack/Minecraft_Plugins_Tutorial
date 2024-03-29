package woktutorial.woktutorial.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import woktutorial.woktutorial.WOKTutorial;

public class PlayerHandler implements Listener
{
    public PlayerHandler(WOKTutorial plugin)
    {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    // giving the player items EACH TIME they login
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();

        // item and the amount of that item we want to give the player
        ItemStack item = new ItemStack(Material.GRASS_BLOCK, 10);
        // access player inventory
        Inventory inv = player.getInventory();

        // item meta
        ItemMeta meta = item.getItemMeta();
        // rename an item
        meta.setDisplayName("Testing");
        // if u dont add this then none of the meta changes made will be applied to the item
        item.setItemMeta(meta);

        // add the item to the NEXT empty spot
        inv.addItem(item);
        // add item to a SPECIFIC spot in inv
        // [0..8] hot bar like array
        inv.setItem(8, item);
    }
}
