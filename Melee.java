import greenfoot.*;

public class Melee extends Weapon
{
    public void act()
    {
        hover();
    }
    
    private void hover()
    {
        if(HeroMechanics.usingMelee == true)
        {
            setImage("weaponMeleeHover.png");
        }
        else
        {
            setImage("weaponMelee.png");
            getImage().setTransparency(90);
        }
    }
}