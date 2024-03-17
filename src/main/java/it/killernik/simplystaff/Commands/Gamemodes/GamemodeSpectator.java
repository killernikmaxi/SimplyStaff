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
            sender.sendMessage(SimplyStaff.getInstance().getConfig().getString("ERROR.only-player"));
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("ss.gmsp")) {
            player.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.no-permission"), player));
            return true;
        }

        if (player.getGameMode() == GameMode.SPECTATOR) {
            player.sendMessage(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Gamemodes.error"));
            return true;
        }

        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Gamemodes.spectator.message"), player));
        StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Gamemodes.spectator.alert"), player);

        return true;
    }
}