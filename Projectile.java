import greenfoot.*;

public class Projectile extends Objects
{
    private int time = 0;   
    
    public void act()
    {
        moveObjects();
        move(10);   //kecepatan projectile
        barrelCollision();  //jika mengenai barrel
    }
    
    private void barrelCollision()
    {
        Actor explodeBarrel = getOneIntersectingObject(ExplodeBarrel.class);
        Actor poisonBarrel = getOneIntersectingObject(PoisonBarrel.class);
        //menghapus laser pada waktu yang ditentukan
        if(time >= 50)
        {
            getWorld().removeObject(this);
            time = 0;
        }
        else if(explodeBarrel != null)
        {
            //play sound effect
            GreenfootSound explode = new GreenfootSound("explodeBarrel.mp3");
            explode.setVolume(70);
            explode.play();
            //add effect
            getWorld().addObject(new ExplodeEffect(), explodeBarrel.getX(), explodeBarrel.getY()-18);
            //remove object
            getWorld().removeObject(explodeBarrel);
            getWorld().removeObject(this);
        }
        else if(poisonBarrel != null)
        {
            //play sound effect;
            GreenfootSound poison = new GreenfootSound("poisonBarrel.mp3");
            poison.setVolume(70);
            poison.play();
            //add effect
            getWorld().addObject(new PoisonEffect(), poisonBarrel.getX(), poisonBarrel.getY()-36);
            //remove object
            getWorld().removeObject(poisonBarrel);
            getWorld().removeObject(this);
        }
        //jika terkena tiles, laser dihapus
        else if(getOneIntersectingObject(Tiles.class) != null)
        {
            getWorld().removeObject(this);
        }
        time++;
    }
}