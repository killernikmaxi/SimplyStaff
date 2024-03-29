package it.killernik.simplystaff.Commands.Basic;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length == 0) {

            if (!commandSender.hasPermission("ss.heal")) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
                return true;
            }

            if (commandSender instanceof Player) {

                StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.heal.alert").replaceAll("%staff%", commandSender.getName()), (Player) commandSender);
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.heal.message"), ((Player) commandSender)));

                ((Player) commandSender).setHealth(((Player) commandSender).getMaxHealth());
                ((Player) commandSender).setFoodLevel(20);
                return true;

            } else {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.specify-player"), null));
                return true;
            }

        } else if (args.length == 1) {

            if (!commandSender.hasPermission("ss.heal.other")) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
                return true;
            }

            String pname = args[0];
            Player player = Bukkit.getPlayer(pname);

            if (player == null) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.non-existent-player"), null));
                return true;
            } else {

                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.heal.message"), player));

                if (commandSender instanceof Player) {
                    StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.heal.alert").replaceAll("%staff%", commandSender.getName()), player);
                } else {
                    StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.heal.alert").replaceAll("%staff%", "Console"), player);
                }

                player.setHealth(player.getMaxHealth());
                player.setFoodLevel(20);

                return true;
            }

        } else {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.incorrect-syntax"), null));
            return true;
        }
    }
}
