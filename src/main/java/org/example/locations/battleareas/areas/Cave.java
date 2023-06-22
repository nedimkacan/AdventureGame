package org.example.locations.battleareas.areas;

import org.example.locations.battleareas.BattleLoc;
import org.example.obstacles.Obstacle;
import org.example.obstacles.obstaclekind.Zombie;
import org.example.players.Player;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Mağara -> Dikkatli ol zombi çıkabilir !", 3, new Zombie(), "Food", 3);
    }
}
