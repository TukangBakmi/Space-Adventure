import greenfoot.*;

public class Stage8 extends World
{
    public Stage8()
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
        addSpikes();
        //mandatory
        Entrance.deployHero = false;
        addObject(new Entrance(), 64, 260);
        addObject(new DoorSwitch(), 416, 96);
        addObject(new ExitDoor(), 4032, 452);
        addGround();
        addCoin();
        //mereset beberapa mekanisme
        Stage1.stage = 8;
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
        //row9
        for(int i = 32; i<=288; i+=64)
            addObject(new Ground2(), i,544);
        for(int i = 352; i<=416; i+=64)
            addObject(new Ground1(), i,544);
        for(int i = 3744; i<=4064; i+=64)
            addObject(new Ground1(), i,544);
        //row8
        for(int i = 32; i<=224; i+=64)
            addObject(new Ground2(), i,480);
        addObject(new Ground1(), 288,480);
        for(int i = 672; i<=3488; i+=256)
            addObject(new Ground3(), i,496);
        //row7
        for(int i = 32; i<=160; i+=64)
            addObject(new Ground2(), i,416);
        addObject(new Ground1(), 224,416);
        //row6
        for(int i = 32; i<=160; i+=64)
            addObject(new Ground1(), i,352);
        addObject(new Ground3(), 3872,336);
        //row5
        //row4
        //row3
        addObject(new Ground2(), 352,160);
        addObject(new Ground1(), 416,160);
        for(int i = 480; i<=672; i+=64)
            addObject(new Ground3(), i,144);
        for(int i = 928; i<=3488; i+=256)
            addObject(new Ground3(), i,144);
        addObject(new Ground3(), 3744,144);
        //row2
        addObject(new TilesFake(), 352,96);
        //row1
        addObject(new Ground2(), 352,32);
    }
    
    private void addCoin()
    {
        
    }
    
    private void addAcid()
    {
        for(int i = 480; i<=3680; i+=64)
            addObject(new Acid1(), i,554);
        //acid bubble
        for(int i = 468; i<=3668; i+=64)
            addObject(new Bubble1(), i,524);
        for(int i = 500; i<=3700; i+=64)
            addObject(new Bubble2(), i,528);
        for(int i = 478; i<=3678; i+=64)
            addObject(new Bubble3(), i,525);
        for(int i = 461; i<=3661; i+=64)
            addObject(new Bubble4(), i,527);
        for(int i = 473; i<=3673; i+=64)
            addObject(new Bubble5(), i,530);
        for(int i = 490; i<=3690; i+=64)
            addObject(new Bubble6(), i,526);
    }
    
    private void addSpikes()
    {
        
    }
    
    private void addEnemy()
    {
        for(int i = 1024; i<=5824; i+=320)
            addObject(new UnknownAlien(), i,352);
        addObject(new Shooter1(), 544,66);
        addObject(new Shooter1(), 3488,434);
    }
    
    private void addOtherObjects()
    {
        
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