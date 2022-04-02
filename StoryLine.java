import greenfoot.*;

public class StoryLine extends Actor
{
    private GreenfootImage[] images = new GreenfootImage[7];
    public static int storyLinePage = 1;  //halaman storyline
    boolean backsound = false;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("storyLine"+i+".png");
        }
    }
    
    public void act()
    {
        nextSlide();
        if(backsound == false)
        {
            BackGroundMusic.storyLine1.setVolume(50);
            BackGroundMusic.storyLine1.play();
            backsound = true;
        }
    }
    
    private void nextSlide()
    {     
        if(Greenfoot.mousePressed(null) && Skip.skipIsPressed == false)
        {
            storyLinePage++;
            if(storyLinePage > 6)
            {
                BackGroundMusic.storyLine6.stop();
                Greenfoot.setWorld(new TutorialPage());
            }
            else
                setImage(images[storyLinePage]);
                
            if(storyLinePage == 2)
            {
                BackGroundMusic.storyLine1.stop();
                BackGroundMusic.storyLine2.setVolume(50);
                BackGroundMusic.storyLine2.play();
            }
            else if(storyLinePage == 3)
            {
                BackGroundMusic.storyLine2.stop();
                BackGroundMusic.storyLine3.setVolume(50);
                BackGroundMusic.storyLine3.play();
            }
            else if(storyLinePage == 4)
            {
                BackGroundMusic.storyLine3.stop();
                BackGroundMusic.storyLine4.setVolume(50);
                BackGroundMusic.storyLine4.play();
            }
            else if(storyLinePage == 5)
            {
                BackGroundMusic.storyLine4.stop();
                BackGroundMusic.storyLine5.setVolume(50);
                BackGroundMusic.storyLine5.play();
            }
            else if(storyLinePage == 6)
            {
                BackGroundMusic.storyLine5.stop();
                BackGroundMusic.storyLine6.setVolume(50);
                BackGroundMusic.storyLine6.play();
            }
        }
    }
}