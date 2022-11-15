import greenfoot.*;

public class EdgeGround extends Actor
{
    public void act()
    {
        moveTiles();
    }
    
    public void moveTiles()
    {
        if(HeroMechanics.isDead == false)
            setLocation(getX() + Stage1.objectSpeed, getY());
    }
}