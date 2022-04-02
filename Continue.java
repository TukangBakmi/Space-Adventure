import greenfoot.*;

public class Continue extends Button
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
            setImage("continue.png");
            setLocation(841, 60);
            buttonClick();  //soundeffect
            ShopPage1.stopBGM();
            //Memberi jeda agar animasi terlihat
            Greenfoot.delay(5);
            if(Stage1.stage == 2)
                Greenfoot.setWorld(new Stage2());   //Ke next Stage
            if(Stage1.stage == 3)
                Greenfoot.setWorld(new Stage3());   //Ke next Stage
            if(Stage1.stage == 4)
                Greenfoot.setWorld(new Stage4());   //Ke next Stage
            if(Stage1.stage == 5)
                Greenfoot.setWorld(new Stage5());   //Ke next Stage
            if(Stage1.stage == 6)
                Greenfoot.setWorld(new Stage6());   //Ke next Stage
            if(Stage1.stage == 7)
                Greenfoot.setWorld(new Stage7());   //Ke next Stage
            if(Stage1.stage == 8)
                Greenfoot.setWorld(new Stage8());   //Ke next Stage
            if(Stage1.stage == 9)
                Greenfoot.setWorld(new Stage9());   //Ke next Stage
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("continueHover.png");
            setLocation(836, 55);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("continue.png");
            setLocation(841, 60);
        }
    }
}
