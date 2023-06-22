package org.example.locations.battleareas.areas;

import org.example.locations.battleareas.BattleLoc;
import org.example.obstacles.Obstacle;
import org.example.obstacles.obstaclekind.Bear;
import org.example.obstacles.obstaclekind.Vampire;
import org.example.players.Player;

public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, "Orman -> Dikkatli ol vampir çıkabilir !", 4, new Vampire(), "Odun", 3);
    }
}
