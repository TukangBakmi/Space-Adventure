import greenfoot.*;

public class BossProjectile extends Enemy
{
    //untuk animasi
    private GreenfootImage[] images = new GreenfootImage[9];
    private int pause = 5;
    private int num = 1;
    private int time = 0;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("bossProjectile ("+i+").png");
        }
    }
    
    public void act()
    {
        move(6);
        animation();
        moveBecauseScrollingBg();
        time++;
        if(time > 150)
        {
            getWorld().addObject(new BossProjectileExplode(), getX(), getY());
            time = 0;
            getWorld().removeObject(this);
        }
    }
    
    public void animation()
    {
        if(pause==0){
            pause=5;
        }
        if(pause==1){
            setImage(images[num]);
            num++;
            if(num >= images.length){
                num=1;
            }
        }
        if(pause>0){
            pause--;
        }
    }
}