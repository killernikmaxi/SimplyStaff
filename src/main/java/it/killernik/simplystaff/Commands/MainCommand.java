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

            if (!sender.hasPermission("ss.help")) {
                sender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.no-permission"), null));
                return true;
            }

            sender.sendMessage(MessageUtil.message("&b&lSimplyStaff &7- by killernik", null));
            sender.sendMessage(MessageUtil.message("&7&oAlias: /simplestaff & /ssk", null));
            sender.sendMessage("");
            sender.sendMessage(MessageUtil.message("&8» &a/ss reload", null));
            sender.sendMessage(MessageUtil.message("&8» &a/gm(c|s|sp|a) [player]", null));

        } else {

            if (args[0].equalsIgnoreCase("reload")) {

                if (!sender.hasPermission("ss.reload")) {
                    sender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("ERROR.no-permission"), null));
                    return true;
                }

                SimplyStaff.getInstance().reloadConfig();
                sender.sendMessage(MessageUtil.message(SimplyStaff.getInstance().getConfig().getString("OTHER.config-reloaded"), null));
            }
        }

        return true;
    }
}
