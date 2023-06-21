package org.example.inventories;

import org.example.locations.safeareas.shop.armours.Armour;
import org.example.locations.safeareas.shop.weapons.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armour armour;

    public Inventory() {
        this.weapon = new Weapon(-1,"Yumruk",0,0);
        this.armour=new Armour(-1,"Paçavra",0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }
}
