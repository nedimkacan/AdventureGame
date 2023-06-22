package org.example.locations.safeareas.areas;

import org.example.locations.safeareas.NormalLoc;
import org.example.players.Player;

public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev",1);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Seçilen Bölge: " + this.getName());
        System.out.println("Canınız Yenilendi !\nBurası sizin için güvenli bir ev burada düşman yok");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
