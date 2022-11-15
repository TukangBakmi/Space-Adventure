import greenfoot.*;

public class UfoShooterProjectileCredit extends CreditSceneBackground
{
    int time;
    
    public void act()
    {
        move(5);
        time++;
        if(time>100)
        {
            time = 0;
            getWorld().removeObject(this);
        }
    }
}