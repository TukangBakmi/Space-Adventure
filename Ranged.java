import greenfoot.*;

public class Ranged extends Weapon
{   
    public void act()
    {
        hover();
    }
    
    private void hover()
    {
        if(HeroMechanics.usingRanged == true)
        {
            setImage("weaponRangedHover.png");
        }
        else
        {
            setImage("weaponRanged.png");
            getImage().setTransparency(90);
        }
    }
}