import greenfoot.*;

public class CreditScene extends World
{
    private boolean quit;
    private int time = 0;
    
    public CreditScene()
    {    
        super(1024, 576, 1, false); 
        prepare();
    }
    
    private void prepare()
    {
        CreditText.time = 0;
        quit = false;
        addObject(new BossCredit(),-1950, 288);
        addObject(new UnknownAlienCredit(),-1400, 250);
        addObject(new UnknownAlienCredit(),-1370, 230);
        addObject(new UnknownAlienCredit(),-1340, 290);
        addObject(new UnknownAlienCredit(),-1310, 210);
        addObject(new UnknownAlienCredit(),-1280, 270);
        addObject(new FlyingSmallRobotCredit(),3610, 476);
        addObject(new FlyingSmallRobotCredit(),2210, 100);
        addObject(new FlyingSmallRobotCredit(),-1500, 100);
        addObject(new FlyingSmallRobotCredit(),-900, 476);
        addObject(new FlyingSmallRobotCredit(),-510, 100);
        addObject(new FlyingSmallRobotCredit(),-10, 476);
        addObject(new UfoShooterCredit(),1054, 200);
        addObject(new CreditSceneBackground(),512,288);
        addObject(new CreditText(),512, 2200);
    }
    
    public void act()
    {
        startBGM();
        Greenfoot.setSpeed(52);
        time++;
        if(time > 550 && quit == false)
        {
            addObject(new QuitCredit(),967, 21);
            quit = true;
        }
    }
    //memulai musik dengan loop
    public static void startBGM()
    {
        BackGroundMusic.credit.setVolume(40);
        BackGroundMusic.credit.play();
    }
    //memberhentikan musik
    public static void stopBGM()
    {
        BackGroundMusic.credit.stop();
    }
}