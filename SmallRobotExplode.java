import greenfoot.*;

public class SmallRobotExplode extends Enemy
{
    private GreenfootImage[] images = new GreenfootImage[7];
    private int pause=5, num=1;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("smallRobotExplode ("+i+").png");
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
            pause=5;
        }
        if(pause==1){
            setImage(images[num]);
            getImage().scale(207, 225);
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