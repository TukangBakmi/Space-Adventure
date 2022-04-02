import greenfoot.*;

public class PoisonBarrel extends TilesObject
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
            //play sound effect;
            GreenfootSound poisonBarrel = new GreenfootSound("poisonBarrel.mp3");
            poisonBarrel.setVolume(70);
            poisonBarrel.play();
            //add effect
            getWorld().addObject(new PoisonEffect(), getX(), getY()-63);
            //remove object
            getWorld().removeObject(this);
        }
    }
}