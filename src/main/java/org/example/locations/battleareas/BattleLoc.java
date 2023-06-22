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
        System.out.println("<S> Savaş");
        System.out.println("0 Geri Dön");
        String selectCase=input.nextLine().toUpperCase();
        if (selectCase.equals("S")&&this.combat(obsNumber)){
            System.out.println("Tüm düşmanları yendiniz !\nAlan artık güvenli !");
            return true;
        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz !");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){
        for (int i = 1; i < obsNumber ; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            this.playerStats();
            this.obstacleStats(i);
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.println("<V> Vur\t<K> Kaç");
                String selectCase=input.nextLine().toUpperCase();
                if (selectCase.equals("V")){
                    System.out.println("Siz vurdunuz !");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth()>0){
                        System.out.println("");
                        System.out.println("Düşman vurdu !");
                        int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmour().getBlock();
                        if (obstacleDamage<0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz !");
                System.out.println(this.getObstacle().getAward() + " ganimet kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel Bakiye: " + this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
        return true;
    }

    public void playerStats(){
        System.out.println("=============================== Oyuncu Değerleri =============================== ");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmour().getName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmour().getBlock());
        System.out.println("Bakiye: " + this.getPlayer().getMoney());
    }
    public void obstacleStats(int i){
        System.out.println("=============================== Düşman Değerleri =============================== ");
        System.out.println(i + " . düşman değerleri !");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Öldürme Ödülü: " + this.getObstacle().getAward());
    }

    public void afterHit(){
        System.out.println("=============================== Canlı Değerler =============================== ");
        System.out.println("Sağlığınız: " + this.getPlayer().getHealth());
        System.out.println("Düşman Sağlığı: " + this.getObstacle().getHealth());
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
