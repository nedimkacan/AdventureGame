package org.example.players;

import org.example.characters.Character;
import org.example.characters.chars.Archer;
import org.example.characters.chars.Knight;
import org.example.characters.chars.Samurai;

import java.util.Scanner;

public class Player {
    private final Scanner input=new Scanner(System.in);
    private String name;
    private int health;
    private int damage;
    private int money;
    private String characterName;

    public Player(String name){
        this.name=name;
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
        return damage;
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
                System.out.println("Karakter seçilmedi");
                break;
        }
        System.out.println("=========================================================================");
    }
    public void initPlayer(Character character){
        this.setName(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
    }
}
