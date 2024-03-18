package it.killernik.simplystaff.Commands.Gamemodes;


import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeSpectator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.only-player"), null));
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("ss.gmsp")) {
            player.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), player));
            return true;
        }

        if (player.getGameMode() == GameMode.SPECTATOR) {
            player.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Gamemodes.error"), player));
            return true;
        }

        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Gamemodes.spectator.message"), player));
        StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Gamemodes.spectator.alert"), player);

        return true;
    }
}