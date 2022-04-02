import greenfoot.*;

public class BossDead extends Enemy
{
    private GreenfootImage[] images = new GreenfootImage[27];
    private int pause=8, num=1;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("bossDead ("+i+").png");
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
            pause=8;
        }
        if(pause==1){
            setImage(images[num]);
            getImage().scale(837,610);
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