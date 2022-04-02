import greenfoot.*;

public class Stage4 extends World
{
    public Stage4()
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
        //mandatory
        Entrance.deployHero = false;
        addObject(new Entrance(), 64, 68);
        addObject(new DoorSwitch(), 416, 480);
        addObject(new ExitDoor(), 3840, 452);
        addObject(new ExplodeBarrel(), 290, 484);
        addGround();
        addCoin();
        //mereset beberapa mekanisme
        Stage1.stage = 4;
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
        addObject(new Ground2(), 32,544);
        for(int i = 96; i<=224; i+=64)
            addObject(new Ground1(), i,544);
        addObject(new Ground2(), 288,544);
        for(int i = 352; i<=2784; i+=64)
            addObject(new Ground1(), i,544);
        for(int i = 3808; i<=4064; i+=64)
            addObject(new Ground1(), i,544);
        //row8
        addObject(new Ground2(), 32,480);
        addObject(new Ground2(), 288,480);
        for(int i = 2784; i<=3680; i+=128)
            addObject(new Ground3(), i,496);
        //row7
        addObject(new Ground2(), 32,416);
        addObject(new TilesFake(), 288,416);
        //row6
        addObject(new Ground2(), 32,352);
        addObject(new TilesFake(), 288,352);
        addObject(new Ground1(), 3808,352);
        //row5
        addObject(new Ground2(), 32,288);
        addObject(new Ground2(), 288,288);
        //row4
        addObject(new Ground2(), 32,224);
        addObject(new Ground2(), 288,224);
        for(int i = 352; i<=2720; i+=64)
            addObject(new Ground1(), i,224);
        for(int i = 3936; i<=4064; i+=64)
            addObject(new Ground1(), i,224);
        //row3
        for(int i = 32; i<=288; i+=64)
            addObject(new Ground1(), i,160);
    }
    
    private void addCoin()
    {
        for(int i = 96; i<=224; i+=64)
            addObject(new Coin(), i,416);
        for(int i = 96; i<=224; i+=64)
            addObject(new Coin(), i,352);
        for(int i = 96; i<=224; i+=64)
            addObject(new Coin(), i,288);
        for(int i = 96; i<=224; i+=64)
            addObject(new Coin(), i,224);
        for(int i = 530; i<=2430; i+=100)
            addObject(new Coin(), i,160);
        for(int i = 630; i<=2430; i+=100)
            addObject(new Coin(), i,480);
        for(int i = 3936; i<=4064; i+=64)
            addObject(new Coin(), i,160);
        for(int i = 3936; i<=4064; i+=64)
            addObject(new Coin(), i,96);
    }
    
    private void addAcid()
    {
        //row 9
        for(int i = 2848; i<=3744; i+=64)
            addObject(new Acid1(), i,554);
        //acid bubble
        for(int i = 2836; i<=3732; i+=64)
            addObject(new Bubble1(), i,524);
        for(int i = 2868; i<=3764; i+=64)
            addObject(new Bubble2(), i,528);
        for(int i = 2846; i<=3742; i+=64)
            addObject(new Bubble3(), i,525);
        for(int i = 2829; i<=3725; i+=64)
            addObject(new Bubble4(), i,523);
        for(int i = 2841; i<=3737; i+=64)
            addObject(new Bubble5(), i,530);
        for(int i = 2858; i<=3754; i+=64)
            addObject(new Bubble6(), i,536);
    }
    
    private void addSpikes()
    {
        addObject(new SpikeTrapUp(), 3936,288);
        addObject(new SpikeTrap(), 2912,448);
        addObject(new SpikeTrap(), 3168,448);
        addObject(new SpikeTrap(), 3552,448);
    }
    
    private void addEnemy()
    {
        for(int i = 480; i<=2592; i+=1056)
            addObject(new FlameAlien(), i,96);
        addObject(new EdgeGround(), 322,96);
        addObject(new EdgeGround(), 2750,96);
        for(int i = 480; i<=2370; i+=945)
            addObject(new ToxicAlien(), i,416);
        addObject(new EdgeGround(), 322,416);
        addObject(new EdgeGround(), 2445,416);
    }
    
    private void addOtherObjects()
    {
        for(int i = 480; i<=2480; i+=100)
            addObject(new ExplodeBarrel(), i,146);
        for(int i = 580; i<=2480; i+=100)
            addObject(new PoisonBarrel(), i,466);
        addObject(new Ground3(), 2480,384);
        addObject(new ExplodeBarrel(), 2480,312);
        addObject(new ChestCoin(), 160,488);
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