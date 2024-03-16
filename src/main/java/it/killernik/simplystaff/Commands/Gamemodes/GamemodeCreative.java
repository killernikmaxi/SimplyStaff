package it.killernik.simplystaff.Commands.Gamemodes;


import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.GameMode;
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
            player.sendMessage(SimplyStaff.getInstance().getConfig().getString("Error.only-player"));
            return true;
        }

        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("Gamemodes.creative.message"), player));
        StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("Gamemodes.creative.alert"), player);

        return false;
    }
}