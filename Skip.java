import greenfoot.*;

public class Skip extends Button
{
    public static boolean skipIsPressed = false;
    
    public void act()
    {
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol start ketika ditekan
            setImage("skip.png");
            setLocation(940, 540);
            buttonClick();  //soundeffect
            //Memberi jeda agar animasi terlihat
            Greenfoot.delay(5);
            stopBacksound();    //memberhentikan voice
            Greenfoot.setWorld(new TutorialPage());   //masuk tutorial
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            skipIsPressed = true;
            setImage("skipHover.png");
            setLocation(940, 540);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            skipIsPressed = false;
            setImage("skip.png");
            setLocation(940, 540);
        }
    }
    
    private void stopBacksound()
    {
        if(StoryLine.storyLinePage == 1)
        {
            BackGroundMusic.storyLine1.stop();
        }
        else if(StoryLine.storyLinePage == 2)
        {
            BackGroundMusic.storyLine2.stop();
        }
        else if(StoryLine.storyLinePage == 3)
        {
            BackGroundMusic.storyLine3.stop();
        }
        else if(StoryLine.storyLinePage == 4)
        {
            BackGroundMusic.storyLine4.stop();
        }
        else if(StoryLine.storyLinePage == 5)
        {
            BackGroundMusic.storyLine5.stop();
        }
        else if(StoryLine.storyLinePage == 6)
        {
            BackGroundMusic.storyLine6.stop();
        }
    }
}