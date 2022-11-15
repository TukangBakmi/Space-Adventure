import greenfoot.*;

public class CreditSceneBackground extends Images
{
    public void act()
    {
        if(CreditText.time == 0)
            getImage().setTransparency(70);
        if(CreditText.time > 200 && getImage().getTransparency() < 255)
            getImage().setTransparency(getImage().getTransparency()+1);
    }
}