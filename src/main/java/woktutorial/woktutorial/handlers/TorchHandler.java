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
     * highest
     * -----
     * monitor
     */

    // change torch into diamond block
    @EventHandler(priority = EventPriority.LOW)
    public void onTorchPlace_Low(BlockPlaceEvent event)
    {
        
    }


    // we can name whatever we want on the class, but the parameter must be very specific
    @EventHandler
    public void onTorchPlace_Normal(BlockPlaceEvent event)
    {
        // this () will run every time a block is placed
        Block block = event.getBlock();

        // if the type of block isnt a torch. Matieral contains all mc items
        if(block.getType() != Material.TORCH)
        {
            return;
        }

        // displays text when torch is placed
        Bukkit.getLogger().info("A torch was placed");
    }
}
