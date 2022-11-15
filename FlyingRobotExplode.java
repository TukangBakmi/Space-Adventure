import greenfoot.*;

public class FlyingRobotExplode extends Enemy
{
    private GreenfootImage[] images = new GreenfootImage[7];
    private int pause=3, num=1;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("flyingRobotExplode ("+i+").png");
        }
    }
    
    public void act()
    {
        moveBecauseScrollingBg();
        animation();
    }
    //set animation
    public void animation()
    {
        if(pause==0){
            pause=3;
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