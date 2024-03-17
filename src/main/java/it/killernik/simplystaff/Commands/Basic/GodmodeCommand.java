package it.killernik.simplystaff.Commands.Basic;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodmodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length == 0) {

            if (!commandSender.hasPermission("ss.godmode")) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.no-permission"), null));
                return true;
            }

            if (commandSender instanceof Player) {

                if (((Player) commandSender).isInvulnerable()) {

                    StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.godmode.alert-removed").replaceAll("%staff%", commandSender.getName()), (Player) commandSender);
                    commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.godmode.removed"), ((Player) commandSender)));

                    ((Player) commandSender).setInvulnerable(false);
                    return true;

                }

                StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.godmode.alert-setted").replaceAll("%staff%", commandSender.getName()), (Player) commandSender);
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.godmode.setted"), ((Player) commandSender)));

                ((Player) commandSender).setInvulnerable(true);
                return true;

            } else {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.specify-player"), null));
                return true;
            }

        } else if (args.length == 1) {

            if (!commandSender.hasPermission("ss.godmode.other")) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.no-permission"), null));
                return true;
            }

            String pname = args[0];
            Player player = Bukkit.getPlayer(pname);

            if (player == null) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.non-existent-player"), null));
                return true;
            } else {

                if ((player).isInvulnerable()) {

                    if (commandSender instanceof Player) {
                        StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.godmode.alert-removed").replaceAll("%staff%", commandSender.getName()), player);
                    } else {
                        StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.godmode.alert-removed").replaceAll("%staff%", "&4&lConsole"), player);
                    }

                    commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.godmode.removed"), (player)));
                    (player).setInvulnerable(false);
                    return true;

                }

                if (commandSender instanceof Player) {
                    StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.godmode.alert-setted").replaceAll("%staff%", commandSender.getName()), player);
                } else {
                    StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.godmode.alert-setted").replaceAll("%staff%", "&4&lConsole"), player);
                }

                commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Basic.godmode.setted"), (player)));
                (player).setInvulnerable(true);

                return true;
            }

        } else {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.incorrect-syntax"), null));
            return true;
        }
    }
}
