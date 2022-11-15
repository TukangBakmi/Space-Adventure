import greenfoot.*;

public class Start extends Button
{
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
            setImage("start.png");
            setLocation(512, 366);
            buttonClick();  //soundeffect
            //Memberi jeda agar animasi terlihat
            Greenfoot.delay(5);
            HomePage.stopBGM();
            StoryLine.storyLinePage = 1;
            Tutorial.tutorialPage = 1;
            Greenfoot.setWorld(new StoryLinePage());   //Ke prologue
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("startHover.png");
            setLocation(507, 361);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("start.png");
            setLocation(512, 366);
        }
    }
}