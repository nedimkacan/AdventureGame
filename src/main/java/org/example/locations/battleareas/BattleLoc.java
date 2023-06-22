package org.example.locations.battleareas;

import org.example.locations.Location;
import org.example.obstacles.Obstacle;
import org.example.players.Player;

import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String avard;
    private int maxObstacleCount;
    public BattleLoc(Player player, String name, int id, Obstacle obstacle, String avard, int maxObstacleCount) {
        super(player, name, id);
        this.obstacle=obstacle;
        this.avard=avard;
        this.maxObstacleCount=maxObstacleCount;
    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Şuanda: " + this.getName() + " arenasındasınız !");
        System.out.println("Burada: " + obsNumber + " adet " + this.getObstacle().getName() + " bulunuyor !");
        System.out.println("Dikkatli ol ve bir karar ver !");
        System.out.println("Id: 1 Seçenek: Savaş");
        System.out.println("0 Geri Dön");
        int selectCase=input.nextInt();
        switch (selectCase){
            case 1:
                System.out.println("");
                break;
            case 0:
                System.out.println("");
        }
        return true;
    }
    public int randomObstacleNumber(){
        Random random=new Random();
        return random.nextInt(this.getMaxObstacleCount())+1;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAvard() {
        return avard;
    }

    public void setAvard(String avard) {
        this.avard = avard;
    }

    public int getMaxObstacleCount() {
        return maxObstacleCount;
    }

    public void setMaxObstacleCount(int maxObstacleCount) {
        this.maxObstacleCount = maxObstacleCount;
    }
}
