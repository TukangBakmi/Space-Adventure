import greenfoot.*;

public class SkipTutorial extends Button
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
            BackGroundMusic.stage1.stop();     //memberhentikan voice
            Greenfoot.setWorld(new Stage1());   //masuk stage1
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
}
