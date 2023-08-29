package woktutorial.woktutorial;

/* to run the server, go on mc, multiplayer, click 'Direct Connection'
and it'll put u in the server */

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import woktutorial.woktutorial.commands.Fly;
import woktutorial.woktutorial.handlers.TorchHandler;

public final class WOKTutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Hello world");

        // fly command
        getCommand("fly").setExecutor(new Fly());

        // instance
        new TorchHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Shutting down");
    }
}
