package org.example.locations.safeareas.shop;

import org.example.locations.safeareas.NormalLoc;
import org.example.locations.safeareas.shop.armours.Armour;
import org.example.locations.safeareas.shop.weapons.Weapon;
import org.example.players.Player;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza",2);
    }

    @Override
    public boolean onLocation() {
        boolean showMenu=true;
        while (showMenu){
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
                    buyWeapon();
                    break;
                case 2:
                    System.out.println("Id: 2\tZırhlar");
                    printArmor();
                    buyArmour();
                    break;
                case 3:
                    System.out.println("Tekrar bekleriz !");
                    showMenu=false;
                    break;
            }
            System.out.println("=========================================================================");
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("============================   Silahlar   ============================");
        for (Weapon weapon: Weapon.weapons()) {
            System.out.println("Id: "+weapon.getId()+"\tİsim: "+weapon.getName()+"\tHasar Miktarı: "+weapon.getDamage()+"\tFiyat: "+weapon.getPrice());
        }
        System.out.println("O Çıkış Yap");
    }
    public void buyWeapon(){
        System.out.print("Satın almak istediğiniz silahın id değerini yazın:");
        int selectCase=input.nextInt();
        while (selectCase<0||selectCase>Weapon.weapons().length){
            System.out.println("Geçersiz değer girdiniz !");
            selectCase=input.nextInt();
        }
        if (selectCase != 0) {
            System.out.println("============================   Seçiminiz   ============================");
            Weapon weaponSelectedItem=Weapon.getWeaponObjById(selectCase);
            if (weaponSelectedItem!=null){
                if (weaponSelectedItem.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Bakiye yeterli değil !");
                }else {
                    System.out.println("Satın alma işlemi başarılı bir şekilde gerçekleşti !");
                    int balance=this.getPlayer().getMoney()-weaponSelectedItem.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Güncel Bakiye: " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    System.out.println("Id: "+this.getPlayer().getInventory().getWeapon().getId()+
                            "\tİsim: "+this.getPlayer().getInventory().getWeapon().getName()+
                            "\tHasar Miktarı: "+this.getPlayer().getInventory().getWeapon().getDamage()+
                            "\tFiyat: "+this.getPlayer().getInventory().getWeapon().getPrice());
                    this.getPlayer().getInventory().setWeapon(weaponSelectedItem);
                    System.out.println("Şimdiki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    System.out.println("Id: "+this.getPlayer().getInventory().getWeapon().getId()+
                            "\tİsim: "+this.getPlayer().getInventory().getWeapon().getName()+
                            "\tHasar Miktarı: "+this.getPlayer().getInventory().getWeapon().getDamage()+
                            "\tFiyat: "+this.getPlayer().getInventory().getWeapon().getPrice());
                }
            }
        }
    }
    public void printArmor(){
        System.out.println("============================   Zırhlar   ============================");
        for (Armour armour: Armour.armours()) {
            System.out.println("Id: "+armour.getId()+"\tİsim: "+armour.getName()+"\tKoruma Gücü: "+armour.getBlock()+"\tFiyat: "+armour.getPrice());
        }
    }
    public void buyArmour(){
        System.out.print("Satın almak istediğiniz zırhın id değerini yazın:");
        int selectCase=input.nextInt();
        while (selectCase<1||selectCase>Armour.armours().length){
            System.out.println("Geçersiz değer girdiniz !");
            selectCase=input.nextInt();
        }
        if (selectCase != 0) {
            System.out.println("============================   Seçiminiz   ============================");
            Armour armourSelectedItem=Armour.getArmourObjById(selectCase);
            if (armourSelectedItem!=null){
                if (armourSelectedItem.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Bakiye yeterli değil !");
                }else {
                    System.out.println("Satın alma işlemi başarılı bir şekilde gerçekleşti !");
                    int balance=this.getPlayer().getMoney()-armourSelectedItem.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Güncel Bakiye: " + this.getPlayer().getMoney());
                    System.out.println("Önceki Zırhınız: " + this.getPlayer().getInventory().getArmour().getName());
                    System.out.println("Id: "+this.getPlayer().getInventory().getArmour().getId()+
                            "\tİsim: "+this.getPlayer().getInventory().getArmour().getName()+
                            "\tKoruma Gücü: "+this.getPlayer().getInventory().getArmour().getBlock()+
                            "\tFiyat: "+this.getPlayer().getInventory().getArmour().getPrice());
                    this.getPlayer().getInventory().setArmour(armourSelectedItem);
                    System.out.println("Şimdiki Zırhınız: " + this.getPlayer().getInventory().getArmour().getName());
                    System.out.println("Id: "+this.getPlayer().getInventory().getArmour().getId()+
                            "\tİsim: "+this.getPlayer().getInventory().getArmour().getName()+
                            "\tKoruma Gücü: "+this.getPlayer().getInventory().getArmour().getBlock()+
                            "\tFiyat: "+this.getPlayer().getInventory().getArmour().getPrice());
                }
            }
        }
    }
}
