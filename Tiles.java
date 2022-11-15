import greenfoot.*;

public class Tiles extends Actor
{
    public void moveTiles()
    {
        if(HeroMechanics.isDead == false)
            setLocation(getX() + Stage1.objectSpeed, getY());
    }
}