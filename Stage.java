import greenfoot.*;

public class Stage extends Images
{
    public static boolean changeImage;
    
    public void act()
    {
        if(changeImage)
        {
            setImage("stage" + Stage1.stage + ".png");
            changeImage = false;
        }
        if(getImage().getTransparency() > 0 && Entrance.deployHero == true)
        {
            getImage().setTransparency(getImage().getTransparency()-2);
            if(getImage().getTransparency() < 2)
                getWorld().removeObject(this);
        }
    }
}