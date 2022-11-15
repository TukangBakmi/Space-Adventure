import greenfoot.*;

public class Tutorial extends Actor
{
    private GreenfootImage[] images = new GreenfootImage[17];
    public static int tutorialPage = 1;  //halaman tutorial
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("tutorial"+i+".png");
        }
    }
    
    public void act()
    {
        nextSlide();
        if(BackGroundMusic.stage1 != null)
        {
            BackGroundMusic.stage1.setVolume(40);
            BackGroundMusic.stage1.play();
        }
    }
    
    private void nextSlide()
    {
        if(Greenfoot.mousePressed(null) && SkipTutorial.skipIsPressed == false)
        {
            tutorialPage++;
            if(tutorialPage > 16)
            {
                BackGroundMusic.stage1.stop();
                Greenfoot.setWorld(new Stage1());
            }
            else
                setImage(images[tutorialPage]);
        }
    }
}