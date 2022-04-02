import greenfoot.*;

public class BossProjectileExplode extends Enemy
{
    //untuk animasi
    private GreenfootImage[] images = new GreenfootImage[9];
    private int pause = 5;
    private int num = 1;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("bossProjectileExplode ("+i+").png");
        }
    }
    
    public void act()
    {
        moveBecauseScrollingBg();
        animation();
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
                getWorld().removeObject(this);
            }
        }
        if(pause>0){
            pause--;
        }
    }
}