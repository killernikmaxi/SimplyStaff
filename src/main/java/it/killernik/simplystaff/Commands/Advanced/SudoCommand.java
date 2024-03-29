package it.killernik.simplystaff.Commands.Advanced;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SudoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!commandSender.hasPermission("ss.sudo")) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
            return true;
        }

        if (args.length == 0) {

            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.specify-player"), null));
            return true;

        } else if (args.length == 2) {

            String pname = args[0];
            Player player = Bukkit.getPlayer(pname);
            String commandtoexecute = args[1];

            if (player == null) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.non-existent-player"), null));
                return true;

            } else {

                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Advanced.sudo.message").replaceAll("%command%", commandtoexecute), player));

                if (commandSender instanceof Player) {
                    StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Advanced.sudo.alert").replaceAll("%staff%", commandSender.getName()).replaceAll("%command%", commandtoexecute), player);
                } else {
                    StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Advanced.sudo.alert").replaceAll("%staff%", "Console").replaceAll("%command%", commandtoexecute), player);
                }

                player.performCommand(commandtoexecute);

                return true;
            }

        } else {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.incorrect-syntax"), null));
            return true;
        }
    }
}
