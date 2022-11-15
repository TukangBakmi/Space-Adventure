import greenfoot.*;

public class Stage7 extends World
{
    public Stage7()
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
        addObject(new Entrance(), 64, 452);
        addObject(new DoorSwitch(), 3680, 288);
        addObject(new ExitDoor(), 3776, 260);
        addGround();
        addCoin();
        //mereset beberapa mekanisme
        Stage1.stage = 7;
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
        for(int i = 32; i<=736; i+=64)
            addObject(new Ground1(), i,544);
        addObject(new Ground2(), 800,544);
        for(int i = 864; i<=2400; i+=64)
            addObject(new Ground1(), i,544);
        addObject(new Ground2(), 2464,544);
        for(int i = 2528; i<=4064; i+=64)
            addObject(new Ground1(), i,544);
        //row8
        addObject(new TilesFake(), 800,480);
        addObject(new TilesFake(), 2464,480);
        //row7
        addObject(new Ground2(), 800,416);
        addObject(new Ground2(), 2464,416);
        //row6
        addObject(new TilesFake(), 800,352);
        for(int i = 544; i<=736; i+=64)
            addObject(new Ground1(), i,352);
        for(int i = 992; i<=1312; i+=64)
            addObject(new Ground1(), i,352);
        addObject(new Ground2(), 1376,352);
        for(int i = 1440; i<=1952; i+=64)
            addObject(new Ground1(), i,352);
        addObject(new Ground1(), 2400,352);
        addObject(new TilesFake(), 2464,352);
        for(int i = 2528; i<=3296; i+=64)
            addObject(new Ground1(), i,352);
        addObject(new Ground2(), 3616,352);
        for(int i = 3680; i<=3936; i+=64)
            addObject(new Ground1(), i,352);
        //row5
        addObject(new Ground2(), 800,288);
        addObject(new Ground2(), 1376,288);
        addObject(new Ground2(), 2464,288);
        addObject(new TilesFake(), 3616,288);
        //row4
        addObject(new TilesFake(), 800,224);
        addObject(new TilesFake(), 1376,224);
        addObject(new TilesFake(), 2464,224);
        addObject(new Ground2(), 3616,224);
        //row3
        for(int i = 608; i<=800; i+=64)
            addObject(new Ground1(), i,160);
        for(int i = 1056; i<=1312; i+=64)
            addObject(new Ground1(), i,160);
        addObject(new Ground2(), 1376,160);
        for(int i = 1440; i<=1760; i+=64)
            addObject(new Ground1(), i,160);
        for(int i = 2464; i<=3232; i+=64)
            addObject(new Ground1(), i,160);
        addObject(new TilesFake(), 3616,160);
        //row2
        addObject(new TilesFake(), 1376,96);
        addObject(new Ground2(), 3616,96);
        //row1
        addObject(new Ground2(), 1376,32);
        addObject(new TilesFake(), 3616,32);
        //row0
        addObject(new TilesFake(), 1376,-32);
        addObject(new Ground2(), 3616,-32);
        //row-1
        addObject(new Ground2(), 1376,-96);
    }
    
    private void addCoin()
    {
        
    }
    
    private void addAcid()
    {
        
    }
    
    private void addSpikes()
    {
        
    }
    
    private void addEnemy()
    {
        for(int i = 256; i<=448; i+=192)
            addObject(new SmallRobot(), 680,i);
        addObject(new FlyingSmallRobot(), 1080,256);
        for(int i = 64; i<=256; i+=192)
            addObject(new FlyingSmallRobot(), 1270,i);
        for(int i = 1500; i<=1692; i+=192)
            addObject(new SmallRobot(), i,64);
        for(int i = 1500; i<=1884; i+=192)
            addObject(new SmallRobot(), i,256);
        for(int i = 2550; i<=3126; i+=192)
            addObject(new FlyingSmallRobot(), i,448);
        for(int i = 2550; i<=3126; i+=192)
            addObject(new SmallRobot(), i,256);
    }
    
    private void addOtherObjects()
    {
        for(int i = 256; i<=448; i+=192)
            addObject(new ExplodeBarrel(), 608,i);
        addObject(new ExplodeBarrel(), 992,256);
        for(int i = 64; i<=256; i+=192)
            addObject(new ExplodeBarrel(), 1184,i);
        for(int i = 1568; i<=1952; i+=192)
            addObject(new ExplodeBarrel(), i,256);
        for(int i = 1568; i<=1760; i+=192)
            addObject(new ExplodeBarrel(), i,64);
        for(int i = 2656; i<=3232; i+=192)
            addObject(new ExplodeBarrel(), i,256);
        for(int i = 2656; i<=3232; i+=192)
            addObject(new ExplodeBarrel(), i,448);
        addObject(new ChestCoin(), 3936,256);
        addObject(new ChestHealth(), 3872,256);
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