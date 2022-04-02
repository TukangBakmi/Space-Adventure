import greenfoot.*;

public class ExitDoor extends Objects
{
    private GreenfootImage[] images = new GreenfootImage[30];
    private int pause=3, num=0;
    private boolean doorIsOpen;
    private boolean addScene = false;
    boolean youWin = false;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=0; i<images.length; i++){
            images[i] = new GreenfootImage("door"+i+".png");
        }
    }
    
    public void act()
    {
        moveObjects();
        open();
        goNextStage();
        if(youWin)
        {
            if(Greenfoot.mouseClicked(null))
            {
                Greenfoot.setWorld(new CreditScene());
            }
        }
    }
    
    private void open()
    {
        if(DoorSwitch.redSwitch)
        {
            doorIsOpen = false;
        }
        if(DoorSwitch.redSwitch == false)
        {
            animation();
            if(doorIsOpen == false && BackGroundMusic.doorSwitch != null)
            {
                //sound
                BackGroundMusic.doorOpened.setVolume(80);
                BackGroundMusic.doorOpened.play();
            }
            doorIsOpen = true;
        }
    }
    
    private void animation()
    {
        if(num < images.length){
            if(pause==0){
                pause=3;
            }
            if(pause==1){
                setImage(images[num]);
                num++;
                if(num == images.length)
                {
                    num = 29;
                }
            }
            if(pause>0){
                pause--;
            }
        }
    }
    
    private void goNextStage()
    {
        if(getOneIntersectingObject(HeroMechanics.class) != null && doorIsOpen && Greenfoot.isKeyDown("e"))
        {
            if(Stage1.stage < 9)
            {
                Stage1.onStage = false;
                Stage1.stage++;
                HeroMechanics.addShieldEffect = false;
                HeroMechanics.addRageEffect = false;
                HeroMechanics.onRage = false;
                ChestCoin.chestCoinOpened = false;
                ChestHealth.chestHealthOpened = false;
                Stage1.stopBGM();
                Greenfoot.setWorld(new ShopPage1());
            }
            else
            {
                if(addScene == false)
                {
                    //scene gameover
                    youWin = true;
                    HeroMechanics.isDead = true;
                    GameOverScene gameOver = new GameOverScene();
                    getWorld().addObject(gameOver, 512, 288);
                    FinalScoreLabel scoreLabel = new FinalScoreLabel("0");
                    getWorld().addObject(scoreLabel, 512, 400);
                    getWorld().addObject(new FinalScoreIcon(scoreLabel), 512,200);
                    addScene = true;
                }
            }
        }
    }
}