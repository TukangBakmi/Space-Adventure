import greenfoot.*;

public class UfoShooterCredit extends CreditSceneBackground
{
    private int time = 0;
    //untuk pergerakan
    int xSpeed = -1; //kecepatan bergerak horizontal
    
    public void act()
    {
        moveHorizontal();
        projectile();
        time++;
        if(getX() < -80)
            getWorld().removeObject(this);
    }
    
    public void moveHorizontal()
    {
        setLocation(getX()+xSpeed, getY());
    }
    
    private void projectile()
    {
        if(time > 80)
        {
            UfoShooterProjectileCredit shot = new UfoShooterProjectileCredit();
            getWorld().addObject(shot, getX(), getY());
            shot.turnTowards(FlyingSmallRobotCredit.xPosition, FlyingSmallRobotCredit.yPosition);
            //play sound effect
            GreenfootSound shotLaser = new GreenfootSound("shotLaser.mp3");
            shotLaser.setVolume(60);
            shotLaser.play();
            time = 0;
        }
    }
}