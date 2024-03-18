package it.killernik.simplystaff.Commands.Advanced;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!commandSender.hasPermission("ss.serverinfo")) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
            return true;
        }

        commandSender.sendMessage("");
        commandSender.sendMessage("§b§lSimplyStaff §7- §7Server Info");
        commandSender.sendMessage("");
        commandSender.sendMessage("§9 ▸ §7Server: §b" + SimplyStaff.INSTANCE.getConfig().getString("OTHER.server"));
        commandSender.sendMessage("§9 ▸ §7Version: §b" + Bukkit.getServer().getVersion());
        commandSender.sendMessage("§9 ▸ §7Online: §b" + Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers());
        commandSender.sendMessage("");

        return true;
    }
}