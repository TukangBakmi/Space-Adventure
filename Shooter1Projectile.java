import greenfoot.*;

public class Shooter1Projectile extends Enemy
{
    public void act()
    {
        move(10);
        moveBecauseScrollingBg();
        if(getOneIntersectingObject(Tiles.class) != null)
            getWorld().removeObject(this);
    }
}