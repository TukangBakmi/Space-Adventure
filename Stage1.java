import greenfoot.*;

public class Stage1 extends World
{
    //variabel untuk scrolling background
    public static GreenfootImage background;
    public static int backgroundX = 0;
    public static int leftScreenPosition = 0;
    public static int rightScreenPosition = 1024;
    //membuat objects bergerak
    public static int objectSpeed;
    //stage sekarang
    public static int stage = 1;
    public static boolean onStage;
    
    public Stage1()
    {
        super(1024,576, 1, false);
        background = new GreenfootImage("backgroundStageA.png");
        this.getBackground().drawImage(background, 0, 0);
        prepare();
    }
    
    public void act()
    {
        this.drawBackground();
        startBGM();
        if(HeroMechanics.isDead == true)
        {
            stopBGM();
        }
    }
    //Menambahkan object
    private void prepare()
    {
        addSawBlade();
        //mandatory
        Entrance.deployHero = false;
        addObject(new Entrance(), 64, 452);
        addObject(new DoorSwitch(), 2272, 160);
        addObject(new ExitDoor(), 4032, 452);
        addGround();
        addCoin();
        //attribut awal
        HeroMechanics.burn = false;
        HeroMechanics.poison = false;
        HeroMechanics.confuse = false;
        HeroMechanics.onRage = false;
        HeroMechanics.addRageEffect = false;
        HeroMechanics.onShield = false;
        HeroMechanics.addShieldEffect = false;
        
        HeroMechanics.usingMelee = true;
        HeroMechanics.usingRanged = false;
        HeroMechanics.displayBatteryIcon = false;
        
        HeroMechanics.healthPoints = 200;
        HeroMechanics.maxHealthPoints = 200;
        HeroMechanics.batteryInt = 10;
        HeroMechanics.maxBattery = 10;
        HeroMechanics.laserDamage = 10;
        HeroMechanics.saberDamage = 10;
        HeroMechanics.faceRight = true;
        HeroMechanics.faceLeft = false;
        DoorSwitch.redSwitch = true;
        stage = 1;
        onStage = true;
        HeroDead.onGameOver = false;
        
        ScoreIcon.myScore = 0;
        CoinIcon.myCoins = 0;
        Item.potion = 5;
        Item.hiPotion = 1;
        Item.antidote = 2;
        Item.rage = 1;
        Item.battery = 3;
        Item.shield = 2;
        Item.interferon = 0;
        Item.crystal = 0;
        Item.levelHp = 1;
        Item.levelLaser = 1;
        Item.levelSaber = 1;
        Item.levelBattery = 1;
        
        ChestCoin.chestCoinOpened = false;
        ChestHealth.chestHealthOpened = false;
        //reset posisi background
        objectSpeed = 0;
        backgroundX = 0;
        leftScreenPosition = 0;
        rightScreenPosition = 1024;
        Inventory.isOpened = false;
        HeroMechanics.isDead = false;
        //optional
        addOtherObjects();
        addAcid();
        addSpikes();
        addSlime();
        //mandatory
        Stage.changeImage = true;
        addObject(new Stage(), 512, 160);
    }
    
    private void addGround()
    {
        //row 9
        for(int i = 32; i<=800; i+=64)
            addObject(new Ground1(), i,544);
        for(int i = 864; i<=1120; i+=64)
            addObject(new Ground2(), i,544);
        for(int i = 1376; i<=1568; i+=64)
            addObject(new Ground2(), i,544);
        for(int i = 1632; i<=2400; i+=64)
            addObject(new Ground1(), i,544);
        for(int i = 2464; i<=3552; i+=64)
            addObject(new Ground2(), i,544);
        for(int i = 3616; i<=4064; i+=64)
            addObject(new Ground1(), i,544);
        //row8
        for(int i = 864; i<=1120; i+=64)
            addObject(new Ground2(), i,480);
        for(int i = 1376; i<=1568; i+=64)
            addObject(new Ground2(), i,480);
        for(int i = 2464; i<=2656; i+=64)
            addObject(new TilesFake(), i,480);
        for(int i = 3424; i<=3552; i+=64)
            addObject(new Ground2(), i,480);
        //row7
        for(int i = 864; i<=1120; i+=64)
            addObject(new TilesFake(), i,416);
        for(int i = 1376; i<=1568; i+=64)
            addObject(new TilesFake(), i,416);
        for(int i = 2464; i<=2656; i+=64)
            addObject(new Ground1(), i,416);
        addObject(new Ground3(), 2912,400);
        addObject(new Ground3(), 3168,400);
        for(int i = 3424; i<=3552; i+=64)
            addObject(new Ground1(), i,416);
        //row 6
        for(int i = 32; i<=480; i+=64)
            addObject(new Ground3(), i,336);
        for(int i = 864; i<=1120; i+=64)
            addObject(new Ground1(), i,352);
        for(int i = 1376; i<=1568; i+=64)
            addObject(new Ground1(), i,352);
        //row 5
        for(int i = 1696; i<=2336; i+=64)
            addObject(new Ground4(), i,272);
        //row 4
        for(int i = 1696; i<=2336; i+=64)
            addObject(new Ground1(), i,224);
    }
    
    private void addCoin()
    {
        for(int i = 224; i<=800; i+=64)
            addObject(new Coin(), i,480);
        for(int i = 32; i<=160; i+=64)
            addObject(new Coin(), i,288);
        for(int i = 32; i<=160; i+=64)
            addObject(new Coin(), i,224);
        for(int i = 32; i<=160; i+=64)
            addObject(new Coin(), i,160);
        for(int i = 32; i<=160; i+=64)
            addObject(new Coin(), i,96);
        for(int i = 928; i<=1120; i+=64)
            addObject(new Coin(), i,288);
        addObject(new Coin(), 1184,224);
        addObject(new Coin(), 1248,160);
        addObject(new Coin(), 1312,224);
        for(int i = 1376; i<=1568; i+=64)
            addObject(new Coin(), i,288);
        for(int i = 1760; i<=2336; i+=64)
            addObject(new Coin(), i,480);
        addObject(new Coin(), 2656,352);
        addObject(new Coin(), 2720,288);
        addObject(new Coin(), 2784,224);
        addObject(new Coin(), 2848,288);
        addObject(new Coin(), 2912,352);
        addObject(new Coin(), 2976,288);
        addObject(new Coin(), 3040,224);
        addObject(new Coin(), 3104,288);
        addObject(new Coin(), 3168,352);
        addObject(new Coin(), 3232,288);
        addObject(new Coin(), 3296,224);
        addObject(new Coin(), 3360,288);
        addObject(new Coin(), 3424,352);
        addObject(new Coin(), 3552,352);
        addObject(new Coin(), 3616,288);
        addObject(new Coin(), 3680,224);
        addObject(new Coin(), 3744,288);
        addObject(new Coin(), 3808,352);
        addObject(new Coin(), 3872,416);
        addObject(new Coin(), 3936,480);
    }
    
    private void addAcid()
    {
        //row 9
        for(int i = 1184; i<=1312; i+=64)
            addObject(new Acid3(), i,544);
        //row8
        for(int i = 1184; i<=1312; i+=64)
            addObject(new Acid2(), i,480);
        //row7
        for(int i = 1184; i<=1312; i+=64)
            addObject(new Acid1(), i,426);
        //acid bubble
        addObject(new Bubble1(),1172,396);
        addObject(new Bubble2(),1204,400);
        addObject(new Bubble3(),1182,397);
        addObject(new Bubble4(),1165,399);
        addObject(new Bubble5(),1177,402);
        addObject(new Bubble6(),1194,398);
        //acid bubble
        addObject(new Bubble1(),1236,396);
        addObject(new Bubble2(),1268,400);
        addObject(new Bubble3(),1246,397);
        addObject(new Bubble4(),1229,399);
        addObject(new Bubble5(),1241,402);
        addObject(new Bubble6(),1258,398);
        //acid bubble
        addObject(new Bubble1(),1300,396);
        addObject(new Bubble2(),1332,400);
        addObject(new Bubble3(),1310,397);
        addObject(new Bubble4(),1293,399);
        addObject(new Bubble5(),1305,402);
        addObject(new Bubble6(),1322,398);
    }
    
    private void addSawBlade()
    {
        addObject(new SawBlade(), 832,512);
    }
    
    private void addSpikes()
    {
        addObject(new SpikeTrap(), 288,288);
        addObject(new SpikeTrap(), 2208,160);
        addObject(new SpikeTrap(), 3744,480);
        for(int i = 2720; i<=3360; i+=64)
            addObject(new Spike2(), i,480);
    }
    
    private void addSlime()
    {
        addObject(new Slime(), 2144,160);
        addObject(new Slime(), 2080,160);
        addObject(new Slime(), 2016,160);
        addObject(new Slime(), 1952,160);
        addObject(new EdgeGround(), 1664,190);
        addObject(new EdgeGround(), 2280,190);
    }
    
    private void addOtherObjects()
    {
        addObject(new ExplodeBarrel(), 482,274);
        addObject(new ChestCoin(), 384,296);
        addObject(new ChestHealth(), 1824,128);
    }
    //menggeser background
    public static void scrollBackgroundX(int changeX)
    {
        backgroundX = backgroundX - changeX;
    }
    //menggambar background yang telah digeser
    public void drawBackground()
    {
        this.getBackground().drawImage(background, backgroundX, 0);
    }
    //memulai musik
    public static void startBGM()
    {
        BackGroundMusic.stage1.setVolume(40);
        BackGroundMusic.stage1.play();
    }
    //memberhentikan musik
    public static void stopBGM()
    {
        BackGroundMusic.stage1.stop();
    }
}