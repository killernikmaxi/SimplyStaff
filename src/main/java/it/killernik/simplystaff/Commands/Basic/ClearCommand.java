package it.killernik.simplystaff.Commands.Basic;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!commandSender.hasPermission("ss.clear")) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
            return true;
        }

        if (args.length == 0) {

            if (!(commandSender instanceof Player)) {

                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.specify-player"), null));
                return true;

            } else {

                ((Player) commandSender).getInventory().clear();
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.clear.message"), (Player) commandSender));
                StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.clear.alert").replaceAll("%staff%", commandSender.getName()), (Player) commandSender);

            }

        } else if (args.length == 1) {

            if (!commandSender.hasPermission("ss.clear.other")) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
                return true;
            }

            String pname = args[0];
            Player player = Bukkit.getPlayer(pname);

            if (player == null) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.non-existent-world"), null));
                return true;
            }

            player.getInventory().clear();

            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.clear.message"), null));
            if (commandSender instanceof Player) {
                StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.clear.alert").replaceAll("%staff%", commandSender.getName()), player);
            } else {
                StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.clear.alert").replaceAll("%staff%", "&4&lConsole"), player);
            }


        } else {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.incorrect-syntax"), null));
        }


        return true;
    }
}