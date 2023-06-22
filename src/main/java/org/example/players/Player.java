package org.example.players;

import org.example.characters.Character;
import org.example.characters.chars.Archer;
import org.example.characters.chars.Knight;
import org.example.characters.chars.Samurai;
import org.example.inventories.Inventory;
import org.example.locations.Location;
import org.example.locations.battleareas.areas.Cave;
import org.example.locations.battleareas.areas.Forest;
import org.example.locations.battleareas.areas.River;
import org.example.locations.safeareas.NormalLoc;
import org.example.locations.safeareas.areas.SafeHouse;
import org.example.locations.safeareas.shop.ToolStore;

import java.util.Scanner;

public class Player {
    private final Scanner input=new Scanner(System.in);
    private String name;
    private int health;
    private int damage;
    private int money;
    private String characterName;
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    public void selectCharacter(){
        System.out.println("============================   Karakterler   ============================");
        Character[] characters={
                new Samurai(),
                new Archer(),
                new Knight()
        };
        for (Character gameChar:characters) {
            System.out.println("Id: "+gameChar.getId()+"\tKarakter: "+gameChar.getName()+"\tHasar: "+gameChar.getDamage()+"\tSağlık: "+gameChar.getHealth()+"\tPara: "+gameChar.getMoney());
        }
        System.out.println("=========================================================================");
        System.out.print("Lütfen Id değerine göre bir karakter seçin: ");
        int selectCharId=input.nextInt();
        System.out.println("============================   Seçilen Karakter   ============================");
        switch (selectCharId){
            case 1:
                this.initPlayer(new Samurai());
                System.out.println("Karakter: "+this.getName()+"\tHasar: "+this.getDamage()+"\tSağlık: "+this.getHealth()+"\tPara: "+this.getMoney());
                break;
            case 2:
                this.initPlayer(new Archer());
                System.out.println("Karakter: "+this.getName()+"\tHasar: "+this.getDamage()+"\tSağlık: "+this.getHealth()+"\tPara: "+this.getMoney());
                break;
            case 3:
                this.initPlayer(new Knight());
                System.out.println("Karakter: "+this.getName()+"\tHasar: "+this.getDamage()+"\tSağlık: "+this.getHealth()+"\tPara: "+this.getMoney());
                break;
            default:
                this.initPlayer(new Samurai());
                System.out.println("Karakter seçilmediği veya hatalı id değeri girildiği için varsayılan karakter alındı !");
                System.out.println("Karakter: "+this.getName()+"\tHasar: "+this.getDamage()+"\tSağlık: "+this.getHealth()+"\tPara: "+this.getMoney());
                break;
        }
        System.out.println("=========================================================================");
    }
    public void selectLoc(){
        while (true){
            printInfo();
            Location location=null;
            Location[] locations={
                    new SafeHouse(this),
                    new ToolStore(this),
                    new Cave(this),
                    new Forest(this),
                    new River(this)
            };
            System.out.println("============================   Bölgeler   ============================");
            for (Location loc:locations) {
                System.out.println("Id: " + loc.getId() + "\tBölge Adı: " + loc.getName());
            }
            System.out.println("0 Çıkış Yap");
            System.out.println("=========================================================================");
            System.out.print("Lütfen Id değerine göre bir bölge seçin: ");
            int selectLoc=input.nextInt();
            System.out.println("============================   Seçilen Bölge   ============================");
            switch (selectLoc){
                case 0:
                    location=null;
                    break;
                case 1:
                    location=new SafeHouse(this);
                    break;
                case 2:
                    location=new ToolStore(this);
                    break;
                case 3:
                    location=new Cave(this);
                    break;
                case 4:
                    location=new Forest(this);
                    break;
                case 5:
                    location=new River(this);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge id'değeri giriniz !");
            }
            if (location == null) {
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin !");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over Öldünüz !");
            }
        }
    }
    public void initPlayer(Character character){
        this.setName(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
    }
    public void printInfo(){
        System.out.println(
                        "Silahınız: " + this.getInventory().getWeapon().getName() +
                        "\tZırhınız: " + this.getInventory().getArmour().getName() +
                        "\tBloklama: " + this.getInventory().getArmour().getBlock() +
                        "\tHasarınız: " + this.getDamage() +
                        "\tSağlığınız: " + this.getHealth() +
                        "\tBakiyeniz: " + this.getMoney()
        );
    }
}
