import greenfoot.*;

public class Quit extends Button
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
            setImage("quit.png");
            setLocation(512, 486);
            buttonClick();  //soundeffect
            //reset posisi background
            Stage1.backgroundX = 0;
            Stage1.leftScreenPosition = 0;
            Stage1.rightScreenPosition = 1024;
            //Memberi jeda agar animasi terlihat 
            Greenfoot.delay(5);
            Greenfoot.setWorld(new HomePage());
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("quitHover.png");
            setLocation(507, 481);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("quit.png");
            setLocation(512, 486);
        }
    }
}