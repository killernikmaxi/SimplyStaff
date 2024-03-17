package it.killernik.simplystaff.Commands.Basic;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!commandSender.hasPermission("ss.kill")) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.no-permission"), null));
            return true;
        }

        if (args.length == 0) {

            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.specify-playyer"), null));
            return true;

        } else if (args.length == 1) {

            String pname = args[0];
            Player player = Bukkit.getPlayer(pname);

            if (player == null) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.non-existent-player"), null));
                return true;
            } else {

                commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("COMMANDS.kill.message"), player));
                player.setHealth(0);

                return true;
            }

        } else {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.incorrect-syntax"), null));
            return true;
        }
    }
}
