import greenfoot.*;

public class Entrance extends Objects
{
    private GreenfootImage[] images = new GreenfootImage[30];
    private int pause=2, num=0;
    public static boolean deployHero = false;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=0; i<images.length; i++){
            images[i] = new GreenfootImage("door"+i+".png");
        }
        setImage(images[0]);
    }
    
    public void act()
    {
        moveObjects();
        animation();
        if(deployHero == false)
        {
            //sound
            BackGroundMusic.doorOpened.setVolume(80);
            BackGroundMusic.doorOpened.play();
        }
    }
    //set animation
    public void animation()
    {
        if(num < images.length){
            if(pause==0){
                pause=2;
            }
            if(pause==1){
                setImage(images[num]);
                num++;
                if(num == images.length)
                {
                    num = 29;
                    if(deployHero ==  false)
                    {
                        //menambahkan hero
                        HeroMechanics hero = new HeroMechanics();
                        getWorld().addObject(hero, getX(), getY());
                        if(HeroMechanics.usingRanged)
                            hero.setImage("heroRanged.png");
                        else if(HeroMechanics.usingMelee)
                            hero.setImage("heroMelee.png");
                        deployHero = true;
                        //menambahkan label hp
                        HpLabel hpLabel = new HpLabel("Hp: " + HeroMechanics.healthPoints + "/" + HeroMechanics.maxHealthPoints);
                        getWorld().addObject(hpLabel,96+hpLabel.getImage().getWidth()/2, 5+hpLabel.getImage().getHeight()/2);
                        getWorld().addObject(new HpIcon(hpLabel), 136,69);
                        //menambahkan label status
                        StatusLabel statLabel = new StatusLabel("Status: " + StatusIcon.status);
                        getWorld().addObject(statLabel,146+statLabel.getImage().getWidth()/2, 15+statLabel.getImage().getHeight()/2);
                        getWorld().addObject(new StatusIcon(statLabel), 146,15);
                        //menambahkan weapon
                        getWorld().addObject(new Melee(), 50, 120);
                        getWorld().addObject(new Ranged(), 130, 120);
                        //menambahkan label score
                        ScoreLabel scoreLabel = new ScoreLabel("" + ScoreIcon.myScore);
                        getWorld().addObject(scoreLabel,500+scoreLabel.getImage().getWidth()/2, 5+scoreLabel.getImage().getHeight()/2);
                        getWorld().addObject(new ScoreIcon(scoreLabel), 500,5);
                        //menambahkan label coin
                        Label label = new Label("" + CoinIcon.myCoins);
                        getWorld().addObject(label,950-label.getImage().getWidth()/2, 15+label.getImage().getHeight()/2);
                        getWorld().addObject(new CoinIcon(label), 987,37);
                        //menambahkan gambar profil
                        getWorld().addObject(new Profile(), 50, 50);
                        //menambahkan inventory
                        addInventory();
                    }
                }
            }
            if(pause>0){
                pause--;
            }
        }
    }
    
    private void addInventory()
    {
        getWorld().addObject(new Inventory(), 512, 560);
        getWorld().addObject(new InventoryItem(), 512, 635);
        //potion
        PotionAmt potionLabel = new PotionAmt("Amt:\n  " + Item.potion);
        getWorld().addObject(potionLabel, 232,635);
        getWorld().addObject(new Potion(potionLabel), 232, 635);
        //hiPotion
        HiPotionAmt hiPotionLabel = new HiPotionAmt("Amt:\n  " + Item.hiPotion);
        getWorld().addObject(hiPotionLabel, 312,635);
        getWorld().addObject(new HiPotion(hiPotionLabel), 312, 635);
        //antidote
        AntidoteAmt antidoteLabel = new AntidoteAmt("Amt:\n  " + Item.antidote);
        getWorld().addObject(antidoteLabel, 392,635);
        getWorld().addObject(new Antidote(antidoteLabel), 392, 635);
        //rage
        RageAmt rageLabel = new RageAmt("Amt:\n  " + Item.rage);
        getWorld().addObject(rageLabel, 472,635);
        getWorld().addObject(new Rage(rageLabel), 472, 635);
        //battery
        BatteryItemAmt batteryLabel = new BatteryItemAmt("Amt:\n  " + Item.battery);
        getWorld().addObject(batteryLabel, 552,635);
        getWorld().addObject(new BatteryItem(batteryLabel), 552, 635);
        //shield
        ShieldItemAmt shieldLabel = new ShieldItemAmt("Amt:\n  " + Item.antidote);
        getWorld().addObject(shieldLabel, 632,635);
        getWorld().addObject(new ShieldItem(shieldLabel), 632, 635);
        //interferon
        InterferonAmt interferonLabel = new InterferonAmt("Amt:\n  " + Item.interferon);
        getWorld().addObject(interferonLabel, 712,635);
        getWorld().addObject(new Interferon(interferonLabel), 712, 635);
        //crystal
        CrystalAmt crystalLabel = new CrystalAmt("Amt:\n  " + Item.crystal);
        getWorld().addObject(crystalLabel, 792,635);
        getWorld().addObject(new Crystal(crystalLabel), 792, 635);
    }
}