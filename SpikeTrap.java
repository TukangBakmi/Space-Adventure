import greenfoot.*;

public class SpikeTrap extends Actor
{
    private boolean added = false;
    Spike1 spike = new Spike1();
    
    public void act()
    {
        getImage().setTransparency(0);
        moveTiles();
        addSpike();
    }
    
    public void moveTiles()
    {
        if(HeroMechanics.isDead == false)
            setLocation(getX() + Stage1.objectSpeed, getY());
    }
    
    private void addSpike()
    {
        if(added == false)
        {
            getWorld().addObject(spike, getX(), getY());
            spike.getImage().setTransparency(0);
            added = true;
        }
        if(getOneIntersectingObject(HeroMechanics.class) != null)
        {
            spike.getImage().setTransparency(255);
        }
    }
}