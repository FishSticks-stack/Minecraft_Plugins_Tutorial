package woktutorial.woktutorial.handlers;

// what happens when a torch is placed

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import woktutorial.woktutorial.WOKTutorial;

public class TorchHandler implements Listener
{
    public TorchHandler(WOKTutorial plugin)
    {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    /** events have priority
     * lowest
     * low
     * normal - default, if none is specified
     * high
     * highest - happens last, is the final say
     * -----
     * monitor - happens after everything else and u cannot change anything at that point
     */

    // change torch into diamond block
    @EventHandler(priority = EventPriority.LOW)
    public void onTorchPlace_Low(BlockPlaceEvent event)
    {
        /* same as Block block, we just didnt make it here
        if we place a torch it'll place a diamond block instead
        */
        if(event.getBlock().getType() == Material.TORCH)
        {
            // canceling events
            event.setCancelled(true);
//            event.getBlock().setType(Material.DIAMOND_BLOCK);
//            Bukkit.getLogger().info("A Diamond Block was placed instead of a Torch");

        }
    }

    /* this never runs with the above (), bc the torch isnt a torch anymore, its a diamond block now.
       example of priority.
       we can name whatever we want on the class, but the parameter must be very specific */
    @EventHandler(ignoreCancelled = true)
    public void onTorchPlace_Normal(BlockPlaceEvent event)
    {
        // this () will run every time a block is placed
//        Block block = event.getBlock();
//
//        // if the type of block isnt a torch. Matieral contains all mc items
//        if(block.getType() != Material.TORCH)
//        {
//            return;
//        }

        // displays text when torch is placed
        Bukkit.getLogger().info("A block was placed");
    }
}
