package it.killernik.simplystaff.Commands;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getStringList("Help").toString(), null));

        } else {

            if (args[0].equalsIgnoreCase("reload")) {
                SimplyStaff.getInstance().reloadConfig();
                sender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("Other.config-reloaded"), null));
            }
        }

        return false;
    }
}
