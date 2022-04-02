import greenfoot.*;

public class Stage5 extends World
{
    public Stage5()
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
        addObject(new Entrance(), 128, 452);
        addObject(new DoorSwitch(), 4064, 96);
        addObject(new ExitDoor(), 2240, 452);
        addObject(new ExplodeBarrel(), 286,466);
        addGround();
        addCoin();
        //mereset beberapa mekanisme
        Stage1.stage = 5;
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
        for(int i = 32; i<=224; i+=64)
            addObject(new Ground1(), i,544);
        addObject(new Ground2(), 288,544);
        for(int i = 352; i<=544; i+=64)
            addObject(new Ground1(), i,544);
        addObject(new Ground2(), 608,544);
        addObject(new Ground2(), 672,544);
        for(int i = 736; i<=3808; i+=64)
            addObject(new Ground1(), i,544);
        for(int i = 3872; i<=4064; i+=64)
            addObject(new Ground2(), i,544);
        //row8
        addObject(new TilesFake(), 288,480);
        addObject(new TilesFake(), 608,480);
        addObject(new Ground1(), 672,480);
        for(int i = 3872; i<=4064; i+=64)
            addObject(new Ground2(), i,480);
        //row7
        addObject(new TilesFake(), 288,416);
        addObject(new Ground2(), 608,416);
        for(int i = 3872; i<=4064; i+=64)
            addObject(new Ground2(), i,416);
        //row6
        addObject(new Ground1(), 32,352);
        addObject(new Ground2(), 288,352);
        addObject(new TilesFake(), 608,352);
        for(int i = 3872; i<=4064; i+=64)
            addObject(new Ground2(), i,352);
        //row5
        addObject(new Ground2(), 288,288);
        addObject(new Ground2(), 608,288);
        for(int i = 800; i<=3680; i+=192)
            addObject(new Ground3(), i,272);
        for(int i = 3872; i<=4064; i+=64)
            addObject(new Ground2(), i,288);
        //row4
        addObject(new Ground2(), 288,224);
        addObject(new TilesFake(), 608,224);
        for(int i = 3872; i<=4064; i+=64)
            addObject(new Ground2(), i,224);
        //row3
        for(int i = 224; i<=608; i+=64)
            addObject(new Ground1(), i,160);
        for(int i = 3872; i<=4064; i+=64)
            addObject(new Ground1(), i,160);
        //row2
    }
    
    private void addCoin()
    {
        for(int i = 352; i<=544; i+=64)
            addObject(new Coin(), i,416);
        for(int i = 352; i<=544; i+=64)
            addObject(new Coin(), i,352);
        for(int i = 352; i<=544; i+=64)
            addObject(new Coin(), i,288);
        for(int i = 352; i<=544; i+=64)
            addObject(new Coin(), i,224);
        for(int i = 384; i<=512; i+=64)
            addObject(new Coin(), i,96);
        for(int i = 800; i<=3680; i+=192)
            addObject(new Coin(), i,224);
        for(int i = 832; i<=2048; i+=64)
            addObject(new Coin(), i,480);
        for(int i = 2432; i<=3648; i+=64)
            addObject(new Coin(), i,480);
    }
    
    private void addAcid()
    {
        
    }
    
    private void addSawBlade()
    {
        addObject(new SawBlade(), 256,256);
    }
    
    private void addSpikes()
    {
        addObject(new SpikeTrap(), 3900,96);
    }
    
    private void addEnemy()
    {
        for(int i = 858; i<=3558; i+=900)
            addObject(new UfoShooter(), i,100);
        addObject(new EdgeGround(), 610,100);
        addObject(new EdgeGround(), 3806,100);
    }
    
    private void addOtherObjects()
    {
        addObject(new ChestCoin(), 399,488);
        addObject(new ChestHealth(), 497,488);
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