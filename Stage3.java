import greenfoot.*;

public class Stage3 extends World
{
    public Stage3()
    {
        super(1024,576, 1, false);
        Stage1.background = new GreenfootImage("backgroundStageB.png");
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
        addSawBlade();
        //mandatory
        Entrance.deployHero = false;
        addObject(new Entrance(), 64, 324);
        addObject(new DoorSwitch(), 1760, 192);
        addObject(new ExitDoor(), 4032, 68);
        addGround();
        addCoin();
        //mereset beberapa mekanisme
        Stage1.stage = 3;
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
        for(int i = 32; i<=224; i+=64)
            addObject(new Ground2(), i,544);
        for(int i = 288; i<=3360; i+=64)
            addObject(new Ground1(), i,544);
        addObject(new Ground1(), 4000,544);
        addObject(new Ground1(), 4064,544);
        //row 8
        for(int i = 32; i<=224; i+=64)
            addObject(new TilesFake(), i,480);
        addObject(new Ground1(), 3552,480);
        addObject(new Ground3(), 3808,496);
        //row 7
        for(int i = 32; i<=160; i+=64)
            addObject(new Ground1(), i,416);
        addObject(new Ground2(), 224,416);
        //row 6
        addObject(new Ground2(), 224,352);
        addObject(new Ground1(), 3680,352);
        //row 5
        addObject(new Ground2(), 224,288);
        //row 4
        addObject(new TilesFake(), 224,224);
        for(int i = 1760; i<=3296; i+=64)
            addObject(new Ground3(), i,240);
        addObject(new Ground1(), 1696,224);
        //row3
        for(int i = 224; i<=1440; i+=64)
            addObject(new Ground3(), i,176);
        for(int i = 3808; i<=4064; i+=64)
            addObject(new Ground1(), i,160);
        addObject(new Ground3(), 3552,144);
    }
    
    private void addCoin()
    {
        for(int i = 416; i<=1056; i+=64)
            addObject(new Coin(), i,128);
        for(int i = 672; i<=3104; i+=64)
            addObject(new Coin(), i,480);
        for(int i = 2016; i<=2976; i+=64)
            addObject(new Coin(), i,160);
        addObject(new Coin(), 4000,416);
        addObject(new Coin(), 4064,416);
        addObject(new Coin(), 4000,352);
        addObject(new Coin(), 4064,352);
        addObject(new Coin(), 4000,288);
        addObject(new Coin(), 4064,288);
        addObject(new Coin(), 4000,224);
        addObject(new Coin(), 4064,224);
    }
    
    private void addAcid()
    {
        
    }
    
    private void addSawBlade()
    {
        addObject(new SawBlade(), 416,512);
        addObject(new SawBlade(), 544,192);
    }
    
    private void addSpikes()
    {
        addObject(new SpikeTrap(), 1376,128);
        addObject(new SpikeTrapUp(), 1376,224);
        addObject(new SpikeTrapUp(), 1696,288);
        addObject(new SpikeTrap(), 3232,192);
    }
    
    private void addEnemy()
    {
        addObject(new Shooter1(), 608,450);
        addObject(new Shooter1(), 1248,162);
        addObject(new Ufo(), 2000,64);
        addObject(new EdgeGround(), 1730,64);
        addObject(new EdgeGround(), 3320,64);
        addObject(new Robot(), 3000,400);
    }
    
    private void addOtherObjects()
    {
        addObject(new ChestCoin(), 322,488);
        addObject(new ChestHealth(), 4032,488);
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