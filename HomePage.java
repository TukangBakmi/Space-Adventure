import greenfoot.*;

public class HomePage extends World
{
    public HomePage()
    {    
        super(1024, 576, 1); 
        prepare();
    }
    
    private void prepare()
    {
        addObject(new Start(),512,366);
        addObject(new QuitHomePage(),512,486);
        addObject(new Title(),512,156);
    }
    
    public void act()
    {
        startBGM();
    }
    //memulai musik dengan loop
    public static void startBGM()
    {
        BackGroundMusic.homePage.setVolume(40);
        BackGroundMusic.homePage.play();
    }
    //memberhentikan musik
    public static void stopBGM()
    {
        BackGroundMusic.homePage.stop();
    }
}