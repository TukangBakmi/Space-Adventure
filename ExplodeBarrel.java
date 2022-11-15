import greenfoot.*;

public class ExplodeBarrel extends TilesObject
{
    public void act()
    {
        moveTiles();
        gravity();
        saberHit();
    }
    
    private void saberHit()
    {
        Actor a = getOneIntersectingObject(ExplodeEffect.class);
        Actor b = getOneIntersectingObject(PoisonEffect.class);
        Actor c = getOneIntersectingObject(SaberSlash.class);
        if(c != null || b != null || a != null)
        {
            //play sound effect
            GreenfootSound explodeBarrel = new GreenfootSound("explodeBarrel.mp3");
            explodeBarrel.setVolume(70);
            explodeBarrel.play();
            //add effect
            getWorld().addObject(new ExplodeEffect(), getX(), getY()-18);
            //remove object
            getWorld().removeObject(this);
        }
    }
}