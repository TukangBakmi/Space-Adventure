import greenfoot.*;

public class Stage9 extends World
{
    public Stage9()
    {
        super(1024,576, 1, false);
        Stage1.background = new GreenfootImage("backgroundStageD.png");
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
        addObject(new Entrance(), 512, 452);
        addObject(new DoorSwitch(), 32, 480);
        addObject(new ExitDoor(), 4032, 452);
        addGround();
        addCoin();
        //mereset beberapa mekanisme
        Stage1.stage = 9;
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
        //atribut boss
        Boss.hp = 10000;
        Boss.maxHp = 10000;
        Boss.shield = false;
        Boss.shieldActivated = 0;
        Boss.regen = false;
        Boss.regenActivated = 0;
        //menambahkan label hp
        BossHpLabel bossHpLabel = new BossHpLabel("Enemy Hp: " + Boss.hp*100/Boss.maxHp + "%");
        addObject(bossHpLabel,1024, 70+bossHpLabel.getImage().getHeight()/2);
        addObject(new BossHpIcon(bossHpLabel), 0,0);
        //menambahkan label status
        BossStatusLabel bossStatLabel = new BossStatusLabel("Status: " + BossStatusIcon.status);
        addObject(bossStatLabel,1024-bossStatLabel.getImage().getWidth()/2, 110+bossStatLabel.getImage().getHeight()/2);
        addObject(new BossStatusIcon(bossStatLabel), 0,0);
    }
    
    private void addGround()
    {
        for(int i = 32; i<=4064; i+=64)
            addObject(new Ground1(), i,544);
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
        addObject(new Boss(), 0,312);
    }
    
    private void addOtherObjects()
    {
        addObject(new ChestHealth(), 2080,488);
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