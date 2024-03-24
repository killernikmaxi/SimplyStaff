package it.killernik.simplystaff.Commands.Basic;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!commandSender.hasPermission("ss.freeze")) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
            return true;
        }

        if (args.length == 0) {

            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.specify-player"), null));
            return true;

        } else if (args.length == 1) {

            String pname = args[0];
            Player player = Bukkit.getPlayer(pname);

            if (player == null) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.non-existent-player"), null));
                return true;
            } else {

                if (!SimplyStaff.INSTANCE.isFrozen(player)) {
                    commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.freeze.freeze-message"), player));

                    if (commandSender instanceof Player) {
                        StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.freeze.freeze-alert").replaceAll("%staff%", commandSender.getName()), player);
                    } else {
                        StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.freeze.freeze-alert").replaceAll("%staff%", "&4&lConsole"), player);
                    }

                    SimplyStaff.INSTANCE.addFreeze(player);
                    player.sendTitle(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.freeze.freeze-player-title.title"), player), MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.freeze.freeze-player-title.subtitle"), player));

                    return true;
                }

                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.freeze.unfreeze-message"), player));

                if (commandSender instanceof Player) {
                    StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.freeze.unfreeze-alert").replaceAll("%staff%", commandSender.getName()), player);
                } else {
                    StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.freeze.unfreeze-alert").replaceAll("%staff%", "Console"), player);
                }

                SimplyStaff.INSTANCE.removeFreeze(player);
                player.sendTitle(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.freeze.unfreeze-player-title.title"), player), MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.freeze.freeze-player-title.subtitle"), player));

                return true;
            }

        } else {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.incorrect-syntax"), null));
            return true;
        }
    }
}
