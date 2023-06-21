package org.example.games;

import org.example.players.Player;

import java.util.Scanner;

public class Game {
    private Scanner input=new Scanner(System.in);
    public void start(){
        System.out.println("Macera başladı !");
        System.out.print("Oyuncu Adı: ");
        String playerName=input.nextLine();
        Player player=new Player(playerName);
        System.out.println("Sayın " + player.getName() + " adaya hoşgeldiniz !");
        System.out.println("Bu puslu ve karanlık adada yaşanan olaylar tümüyle gerçektir !");
        player.selectCharacter();
        player.selectLoc();
    }
}
