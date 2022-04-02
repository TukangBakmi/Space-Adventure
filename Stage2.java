import greenfoot.*;

public class Stage2 extends World
{
    public Stage2()
    {
        super(1024,576, 1, false);
        Stage1.background = new GreenfootImage("backgroundStageA.png");
        this.getBackground().drawImage(Stage1.background, 0, 0);
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
        //optional
        addSpikes();
        //mandatory
        Entrance.deployHero = false;
        addObject(new Entrance(), 64, 452);
        addObject(new DoorSwitch(), 1056, 96);
        addObject(new ExitDoor(), 3904, 324);
        addGround();
        addCoin();
        //mereset beberapa mekanisme
        Stage1.stage = 2;
        Stage1.onStage = true;
        HeroDead.onGameOver = false;
        HeroMechanics.displayBatteryIcon = false;
        DoorSwitch.redSwitch = true;
        //reset posisi background
        Stage1.objectSpeed = 0;
        Stage1.backgroundX = 0;
        Stage1.leftScreenPosition = 0;
        Stage1.rightScreenPosition = 1024;
        Inventory.isOpened = false;
        HeroMechanics.isDead = false;
        HeroMechanics.faceRight = true;
        HeroMechanics.faceLeft = false;
        //optional
        addEnemy();
        addAcid();
        addOtherObjects();
        //mandatory
        Stage.changeImage = true;
        addObject(new Stage(), 512, 160);
    }
    
    private void addGround()
    {
        //row 9
        for(int i = 32; i<=160; i+=64)
            addObject(new Ground1(), i,544);
        addObject(new Ground2(), 224,544);
        addObject(new Ground2(), 288,544);
        for(int i = 352; i<=2464; i+=64)
            addObject(new Ground1(), i,544);
        for(int i = 2528; i<=2784; i+=64)
            addObject(new Ground2(), i,544);
        for(int i = 3808; i<=4064; i+=64)
            addObject(new Ground2(), i,544);
        //row8
        addObject(new Ground2(), 224,480);
        addObject(new Ground2(), 288,480);
        for(int i = 2528; i<=2784; i+=64)
            addObject(new TilesFake(), i,480);
        for(int i = 3808; i<=4064; i+=64)
            addObject(new Ground2(), i,480);
        //row7
        addObject(new TilesFake(), 224,416);
        addObject(new TilesFake(), 288,416);
        for(int i = 2528; i<=2784; i+=64)
            addObject(new Ground1(), i,416);
        addObject(new Ground3(), 3040,400);
        addObject(new Ground3(), 3296,400);
        addObject(new Ground3(), 3552,400);
        for(int i = 3808; i<=4064; i+=64)
            addObject(new Ground1(), i,416);
        //row6
        addObject(new Ground1(), 224,352);
        addObject(new Ground1(), 288,352);
        addObject(new Ground2(), 352,352);
        addObject(new Ground2(), 416,352);
        //row5
        addObject(new TilesFake(), 352,288);
        addObject(new TilesFake(), 416,288);
        //row4
        addObject(new Ground2(), 352,224);
        addObject(new Ground2(), 416,224);
        addObject(new Ground2(), 2400,224);
        addObject(new Ground1(), 2464,224);
        //row3
        for(int i = 32; i<=160; i+=64)
            addObject(new Ground1(), i,160);
        for(int i = 352; i<=800; i+=64)
            addObject(new Ground1(), i,160);
        addObject(new Ground2(), 992,160);
        for(int i = 1056; i<=2400; i+=64)
            addObject(new Ground1(), i,160);
        //row2
        addObject(new Ground1(), 992,96);
    }
    
    private void addCoin()
    {
        for(int i = 352; i<=800; i+=64)
            addObject(new Coin(), i,96);
        for(int i = 480; i<=864; i+=64)
            addObject(new Coin(), i,480);
        for(int i = 1056; i<=2272; i+=64)
            addObject(new Coin(), i,480);
        for(int i = 1248; i<=2336; i+=64)
            addObject(new Coin(), i,96);
        addObject(new Coin(), 2784,352);
        addObject(new Coin(), 2848,288);
        addObject(new Coin(), 2912,224);
        addObject(new Coin(), 2976,288);
        addObject(new Coin(), 3040,352);
        addObject(new Coin(), 3104,288);
        addObject(new Coin(), 3168,224);
        addObject(new Coin(), 3232,288);
        addObject(new Coin(), 3296,352);
        addObject(new Coin(), 3360,288);
        addObject(new Coin(), 3424,224);
        addObject(new Coin(), 3488,288);
        addObject(new Coin(), 3552,352);
        addObject(new Coin(), 4064,352);
    }
    
    private void addAcid()
    {
        //row 9
        for(int i = 2848; i<=3744; i+=64)
            addObject(new Acid2(), i,544);
        //row8
        for(int i = 2848; i<=3744; i+=64)
            addObject(new Acid1(), i,490);
        //acid bubble
        for(int i = 2836; i<=3732; i+=64)
            addObject(new Bubble1(), i,460);
        for(int i = 2868; i<=3764; i+=64)
            addObject(new Bubble2(), i,464);
        for(int i = 2846; i<=3742; i+=64)
            addObject(new Bubble3(), i,461);
        for(int i = 2829; i<=3725; i+=64)
            addObject(new Bubble4(), i,463);
        for(int i = 2841; i<=3737; i+=64)
            addObject(new Bubble5(), i,466);
        for(int i = 2858; i<=3754; i+=64)
            addObject(new Bubble6(), i,462);
    }
    
    private void addSpikes()
    {
        addObject(new SpikeTrap(), 128,96);
        addObject(new SpikeTrap(), 928,480);
        addObject(new SpikeTrap(), 1216,96);
        addObject(new SpikeTrap(), 4000,352);
    }
    
    private void addEnemy()
    {
        addObject(new Robot(), 2400,475);
        addObject(new Ufo(), 2400,300);
        addObject(new Robot(), 1800,90);
        addObject(new Ufo(), 800,300);
        addObject(new EdgeGround(), 2492,288);
        addObject(new EdgeGround(), 453,288);
    }
    
    private void addOtherObjects()
    {
        addObject(new ChestCoin(), 64,104);
        addObject(new ChestHealth(), 374,488);
        addObject(new PoisonBarrel(), 448,466);
    }
    //menggeser background
    public static void scrollBackgroundX(int changeX)
    {
        Stage1.backgroundX = Stage1.backgroundX - changeX;
    }
    //menggambar background yang telah digeser
    public void drawBackground()
    {
        this.getBackground().drawImage(Stage1.background, Stage1.backgroundX, 0);
    }
    //memulai musik dengan loop
    public void startBGM()
    {
        BackGroundMusic.stage1.setVolume(40);
        BackGroundMusic.stage1.play();
    }
    //memberhentikan musik
    public void stopBGM()
    {
        BackGroundMusic.stage1.stop();
    }
}