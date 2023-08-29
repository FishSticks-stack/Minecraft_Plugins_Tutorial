package woktutorial.woktutorial.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor
{
    // sender is the player
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        // only players can run this command, not the terminal/console
        if (!(sender instanceof Player))
        {
            // if u try to run it from terminal
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        Player player = (Player) sender;

        // if player has the ABILITY to fly
        if (player.getAllowFlight())
        {
            // flying will turn off
            player.setAllowFlight(false);
            player.sendMessage("Flying disabled");
        }
        else
        {
            // flying will turn on
            player.setAllowFlight(true);
            player.sendMessage("Flying enabled");
        }
        return true;
    }
}
