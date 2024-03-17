package it.killernik.simplystaff.Commands.Basic.Teleport;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportPosCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.only-player"), null));
            return true;
        }

        if (!commandSender.hasPermission("ss.tppos")) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.no-permission"), null));
            return true;
        }

        if (args.length != 3) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.incorrect-syntax"), null));
            return true;
        }

        double x, y, z;

        try {
            x = Double.parseDouble(args[0]);
            y = Double.parseDouble(args[1]);
            z = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.invalid-coordinates"), null));
            return true;
        }

        Player player = (Player) commandSender;

        player.teleport(player.getWorld().getBlockAt((int) x, (int) y, (int) z).getLocation().add(0.5, 0, 0.5));

        commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.teleportpos.message")
                .replaceAll("%x%", String.valueOf(x))
                        .replaceAll("%y%", String.valueOf(y))
                        .replaceAll("%z%", String.valueOf(z))
                , player));

        StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.teleportpos.alert").replaceAll("%staff%", commandSender.getName()).replaceAll("%x%", String.valueOf(x))
                        .replaceAll("%y%", String.valueOf(y))
                        .replaceAll("%z%", String.valueOf(z))
                , player);

        return true;
    }
}
