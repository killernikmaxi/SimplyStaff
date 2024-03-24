package it.killernik.simplystaff.Commands.Basic;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class FlyCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length == 0) {

            if (!commandSender.hasPermission("ss.fly")) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
                return true;
            }

            if (commandSender instanceof Player) {

                if (((Player) commandSender).getAllowFlight()) {

                    StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.fly.alert-disabled").replaceAll("%staff%", commandSender.getName()), (Player) commandSender);
                    commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.fly.disabled"), ((Player) commandSender)));

                    ((Player) commandSender).setAllowFlight(false);
                    return true;

                }

                StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.fly.alert-enabled").replaceAll("%staff%", commandSender.getName()), (Player) commandSender);
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.fly.enabled"), ((Player) commandSender)));

                ((Player) commandSender).setAllowFlight(true);
                return true;

            } else {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.specify-player"), null));
                return true;
            }

        } else if (args.length == 1) {

            if (!commandSender.hasPermission("ss.fly.other")) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
                return true;
            }

            String pname = args[0];
            Player player = Bukkit.getPlayer(pname);

            if (player == null) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.non-existent-player"), null));
                return true;
            } else {

                if (player.getAllowFlight()) {

                    if (commandSender instanceof Player) {
                        StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.fly.alert-disabled").replaceAll("%staff%", commandSender.getName()), player);
                    } else {
                        StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.fly.alert-disabled").replaceAll("%staff%", "Console"), player);
                    }

                    commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.fly.disabled"), (player)));
                    player.setAllowFlight(false);
                    return true;

                }

                if (commandSender instanceof Player) {
                    StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.fly.alert-enabled").replaceAll("%staff%", commandSender.getName()), player);
                } else {
                    StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.fly.alert-enabled").replaceAll("%staff%", "Console"), player);
                }

                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.fly.enabled"), player));
                player.setAllowFlight(true);

                return true;
            }

        } else {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.incorrect-syntax"), null));
            return true;
        }
    }
}
