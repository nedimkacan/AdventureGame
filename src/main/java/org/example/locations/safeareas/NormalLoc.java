package org.example.locations.safeareas;

import org.example.locations.Location;
import org.example.players.Player;

public class NormalLoc extends Location {


    public NormalLoc(Player player, String name, int id) {
        super(player, name, id);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
