package org.example.locations.safeareas.shop;

import org.example.locations.safeareas.NormalLoc;
import org.example.locations.safeareas.shop.weapons.Weapon;
import org.example.players.Player;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza",2);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Seçilen Bölge: " + this.getName());
        System.out.println("Mağazaya Hoşgeldiniz !\nSilah ve Zırh satın alabilirsiniz !");
        System.out.println("Id: 1\tSilahlar");
        System.out.println("Id: 2\tZırhlar");
        System.out.println("Id: 3\tÇıkış Yap");
        int selectCase=input.nextInt();
        System.out.println("============================   Seçiminiz   ============================");
        while (selectCase<1 || selectCase>3){
            System.out.println("Geçersiz değer girdiniz lütfen tekrar seçiniz !");
            selectCase=input.nextInt();

        }
        switch (selectCase){
            case 1:
                System.out.println("Id: 1\tSilahlar");
                printWeapon();
                selectWeapon();
                break;
            case 2:
                System.out.println("Id: 2\tZırhlar");
                printArmor();
            case 3:
                System.out.println("Tekrar bekleriz !");
                return true;
        }
        System.out.println("=========================================================================");
        return true;
    }
    public void printWeapon(){
        System.out.println("============================   Silahlar   ============================");
        for (Weapon weapon: Weapon.weapons()) {
            System.out.println("Id: "+weapon.getId()+"\tİsim: "+weapon.getName()+"\tHasar Miktarı: "+weapon.getDamage()+"\tFiyat: "+weapon.getPrice());
        }
    }
    public void selectWeapon(){
        System.out.print("Satın almak istediğiniz silahın id değerini yazın:");
        int selectCase=input.nextInt();
        while (selectCase<1||selectCase>Weapon.weapons().length){
            System.out.println("Geçersiz değer girdiniz !");
            selectCase=input.nextInt();
        }
        System.out.println("============================   Seçiminiz   ============================");
        Weapon weaponSelectedItem=Weapon.getWeaponObjById(selectCase);
        if (weaponSelectedItem!=null){
            if (weaponSelectedItem.getPrice()>this.getPlayer().getMoney()){
                System.out.println("Bakiye yeterli değil !");
            }else {
                System.out.println("Satın alma işlemi başarılı bir şekilde gerçekleşti !");
                System.out.println("Id: "+Weapon.weapons()[0].getId()+"\tİsim: "+Weapon.weapons()[0].getName()+"\tHasar Miktarı: "+Weapon.weapons()[0].getDamage()+"\tFiyat: "+Weapon.weapons()[0].getPrice());
                int balance=this.getPlayer().getMoney()-weaponSelectedItem.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Güncel Bakiye: " + this.getPlayer().getMoney());
                System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(weaponSelectedItem);
                System.out.println("Şimdiki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
    }
    public void printArmor(){
        System.out.println("============================   Zırhlar   ============================");
        System.out.println("Id: 1\tMakineli");
    }
}
