package org.example.locations.battleareas.areas;

import org.example.locations.battleareas.BattleLoc;
import org.example.obstacles.Obstacle;
import org.example.obstacles.obstaclekind.Bear;
import org.example.obstacles.obstaclekind.Zombie;
import org.example.players.Player;

public class River extends BattleLoc {
    public River(Player player) {
        super(player, "Nehir -> Dikkatli ol ayı çıkabilir !", 5, new Bear(), "Su", 2);
    }
}
