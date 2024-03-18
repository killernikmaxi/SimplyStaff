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
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.no-permission"), null));
            return true;
        }

        if (args.length == 0) {

            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.specify-player"), null));
            return true;

        } else if (args.length == 2) {

            String pname = args[1];
            Player player = Bukkit.getPlayer(pname);
            String commandtoexecute = args[0];

            if (player == null) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.non-existent-player"), null));
                return true;

            } else {

                commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Advanced.sudo.message"), player));

                if (commandSender instanceof Player) {
                    StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Advanced.sudo.alert").replaceAll("%staff%", commandSender.getName()).replaceAll("%command%", commandtoexecute), player);
                } else {
                    StaffAlert.alert(SimplyStaff.getInstance().getConfig().getString("COMMANDS.Advanced.sudo.alert").replaceAll("%staff%", "&4&lConsole").replaceAll("%command%", commandtoexecute), player);
                }

                player.performCommand(commandtoexecute);

                return true;
            }

        } else {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.incorrect-syntax"), null));
            return true;
        }
    }
}
