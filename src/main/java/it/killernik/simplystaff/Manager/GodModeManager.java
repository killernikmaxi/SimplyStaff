package it.killernik.simplystaff.Manager;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class GodModeManager {
    private final Set<Player> godmode = new HashSet<>();

    public boolean isInGodmode(Player p) {
        return godmode.contains(p);
    }

    public void addGodmode(Player p) {
        godmode.add(p);
    }

    public void removeGodmode(Player p) {
        godmode.remove(p);
    }

}
