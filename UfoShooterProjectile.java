import greenfoot.*;

public class UfoShooterProjectile extends Enemy
{
    public void act()
    {
        move(10);
        moveBecauseScrollingBg();
        if(getOneIntersectingObject(Tiles.class) != null)
            getWorld().removeObject(this);
    }
}