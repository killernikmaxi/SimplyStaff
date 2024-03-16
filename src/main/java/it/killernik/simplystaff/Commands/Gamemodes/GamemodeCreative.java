package it.killernik.simplystaff.Commands.Gamemodes;


import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class GamemodeCreative implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Errore");
            return true;
        }

        Player player = (Player) sender;

        if (player.getGameMode() == GameMode.CREATIVE) {
            player.sendMessage("Errore");
            return true;
        }

        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage("Done!");

        return false;
    }
}