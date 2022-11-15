import greenfoot.*;

public class QuitCredit extends Button
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
            setImage("quitCredit.png");
            buttonClick();  //soundeffect
            //reset posisi background
            Stage1.backgroundX = 0;
            Stage1.leftScreenPosition = 0;
            Stage1.rightScreenPosition = 1024;
            //Memberi jeda agar animasi terlihat 
            Greenfoot.delay(5);
            CreditScene.stopBGM();
            Greenfoot.setWorld(new HomePage());
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("quitHoverCredit.png");
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("quitCredit.png");
        }
    }
}