package it.killernik.simplystaff.Manager;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class FreezeManager {

    private final Set<Player> frozen = new HashSet<>();

    public boolean isFrozen(Player p) {
        return frozen.contains(p);
    }

    public void addFreeze(Player p) {
        frozen.add(p);
        MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("Commands.freeze.freeze-player-message"), p);
    }

    public void removeFreeze(Player p) {
        frozen.remove(p);
    }

}
