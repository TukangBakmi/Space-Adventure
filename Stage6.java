import greenfoot.*;

public class Stage6 extends World
{
    public Stage6()
    {
        super(1024,576, 1, false);
        Stage1.background = new GreenfootImage("backgroundStageC.png");
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
        addSawBlade();
        addSpikes();
        //mandatory
        Entrance.deployHero = false;
        addObject(new Entrance(), 64, 452);
        addObject(new DoorSwitch(), 1760, 224);
        addObject(new ExitDoor(), 3584, 452);
        addGround();
        addCoin();
        //mereset beberapa mekanisme
        Stage1.stage = 6;
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
        addOtherObjects();
        //mandatory
        Stage.changeImage = true;
        addObject(new Stage(), 512, 160);
    }
    
    private void addGround()
    {
        //row9
        for(int i = 32; i<=416; i+=64)
            addObject(new Ground1(), i,544);
        for(int i = 1632; i<=3424; i+=64)
            addObject(new Ground1(), i,544);
        addObject(new Ground2(), 3488,544);
        for(int i = 3552; i<=4064; i+=64)
            addObject(new Ground1(), i,544);
        //row8
        for(int i = 1248; i<=1376; i+=64)
            addObject(new Ground1(), i,480);
        addObject(new Ground2(), 3488,480);
        //row7
        for(int i = 608; i<=736; i+=64)
            addObject(new Ground1(), i,416);
        addObject(new TilesFake(), 3488,416);
        //row6
        for(int i = 992; i<=1120; i+=64)
            addObject(new Ground1(), i,352);
        addObject(new Ground1(), 3488,352);
        //row5
        for(int i = 32; i<=416; i+=64)
            addObject(new Ground3(), i,272);
        addObject(new Ground2(), 1696,288);
        for(int i = 1760; i<=3232; i+=64)
            addObject(new Ground1(), i,288);
        //row4
        addObject(new Ground1(), 1696,224);
        addObject(new Ground2(), 4000,224);
        //row3
        for(int i = 3552; i<=4000; i+=64)
            addObject(new Ground1(), i,160);
        //row2
        //row1
    }
    
    private void addCoin()
    {
        for(int i = 224; i<=416; i+=64)
            addObject(new Coin(), i,480);
            
        for(int i = 160; i<=352; i+=64)
            addObject(new Coin(), i,224);
        for(int i = 160; i<=352; i+=64)
            addObject(new Coin(), i,160);
        for(int i = 160; i<=352; i+=64)
            addObject(new Coin(), i,96);
            
        for(int i = 1248; i<=1376; i+=64)
            addObject(new Coin(), i,416);
        for(int i = 608; i<=736; i+=64)
            addObject(new Coin(), i,352);
        for(int i = 992; i<=1120; i+=64)
            addObject(new Coin(), i,288);
            
        for(int i = 1888; i<=3104; i+=64)
            addObject(new Coin(), i,96);
        for(int i = 3552; i<=4000; i+=64)
            addObject(new Coin(), i,96);
        for(int i = 3552; i<=4064; i+=64)
            addObject(new Coin(), i,480);
    }
    
    private void addSawBlade()
    {
        for(int i = 1850; i<=2930; i+=180)
            addObject(new SawBlade(), i,254);
    }
    
    private void addSpikes()
    {
        for(int i = 480; i<=1568; i+=64)
            addObject(new Spike2(), i,550);
    }
    
    private void addEnemy()
    {
        addObject(new FlyingRobot(), 0,0);
        for(int i = 2100; i<=3400; i+=384)
            addObject(new FlyingRobot(), i,440);
        addObject(new FlyingRobot(), 2500,100);
        addObject(new FlyingRobot(), 4000,300);
    }
    
    private void addOtherObjects()
    {
        addObject(new ChestHealth(), 1696,168);
        addObject(new ChestCoin(), 64,232);
        addObject(new PoisonBarrel(), 418,210);
        for(int i = 2080; i<=3232; i+=384)
            addObject(new PoisonBarrel(), i,466);
        addObject(new PoisonBarrel(), 3168,210);
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