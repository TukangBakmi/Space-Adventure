import greenfoot.*;

public class Objects extends Actor
{
    public void moveObjects()
    {
        if(HeroMechanics.isDead == false)
            setLocation(getX() + Stage1.objectSpeed, getY());
    }
}