import greenfoot.*;

public class Restart extends Button
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
            //Mengganti tombol quit ketika ditekan
            setImage("restart.png");
            setLocation(512, 376);
            buttonClick();  //soundeffect
            //Memberi jeda agar animasi terlihat 
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Stage1());
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("restartHover.png");
            setLocation(507, 371);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("restart.png");
            setLocation(512, 376);
        }
    }
}