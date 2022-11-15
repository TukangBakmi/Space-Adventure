import greenfoot.*;

public class TilesFake extends Actor
{
    public void act()
    {
        if(HeroMechanics.isDead == false)
            setLocation(getX() + Stage1.objectSpeed, getY());
    }
}