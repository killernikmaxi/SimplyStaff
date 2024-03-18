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
                sender.sendMessage(MessageUtil.message("&b&lSimplyStaff &8» &cSimplyStaff by killernik", null));
                return true;
            }

            sender.sendMessage(MessageUtil.message("&b&lSimplyStaff &7- by killernik", null));
            sender.sendMessage(MessageUtil.message("&7&oAlias: /simplestaff & /ss", null));
            sender.sendMessage("");
            sender.sendMessage(MessageUtil.message("&8» &a/ss reload", null));
            sender.sendMessage(MessageUtil.message("&8» &a/gm(c|s|sp|a) [player]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/day [world]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/night [world]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/kill [player]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/clear [player]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/heal [player]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/godmode [player]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/kill [player]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/fly [player]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/tp [player]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/tph [player]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/tppos [x] [y] [z]", null));
            sender.sendMessage(MessageUtil.message("&8» &a/serverinfo", null));

        } else {

            if (args[0].equalsIgnoreCase("reload")) {

                if (!sender.hasPermission("ss.reload")) {
                    sender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
                    return true;
                }

                SimplyStaff.INSTANCE.reloadConfig();
                sender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("OTHER.config-reloaded"), null));
            }
        }

        return true;
    }
}
