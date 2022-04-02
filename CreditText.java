import greenfoot.*;

public class CreditText extends Images
{
    public static int time = 0;
    
    public void act()
    {
        if(getY() > -1070)
            setLocation(getX(), getY() - 1);
        else
            time++;
        if(time > 200 & getImage().getTransparency() > 0)
            getImage().setTransparency(getImage().getTransparency()-1);
        if (getImage().getTransparency() <= 0)
        {
            CreditScene.stopBGM();
            Greenfoot.setWorld(new HomePage());
        }
    }
}