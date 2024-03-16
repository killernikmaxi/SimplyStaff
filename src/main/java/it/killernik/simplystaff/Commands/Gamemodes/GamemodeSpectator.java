package it.killernik.simplystaff.Commands.Gamemodes;


import it.killernik.simplystaff.SimplyStaff;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class GamemodeSpectator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Errore");
            return true;
        }

        Player player = (Player) sender;

        if (player.getGameMode() == GameMode.SPECTATOR) {
            player.sendMessage(SimplyStaff.getInstance().getConfig().getString("Error.only-player"));
            return true;
        }

        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage(SimplyStaff.getInstance().getConfig().getString("Gamemodes.spectator"));

        return false;
    }
}