import greenfoot.*;

public class RageEffect extends ItemEffects
{
    private GreenfootImage[] images = new GreenfootImage[18];
    private int pause=3, num=1;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("rage"+i+".png");
        }
    }
    
    public void act()
    {
        setLocation(HeroMechanics.xPosition, HeroMechanics.yPosition+4);
        animation();
        if(HeroMechanics.addRageEffect == false)
        {
            getWorld().removeObject(this);
        }
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
                num=1;
            }
        }
        if(pause>0){
            pause--;
        }
    }
}