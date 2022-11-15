import greenfoot.*;

public class ShieldEffect extends ItemEffects
{
    private GreenfootImage[] images = new GreenfootImage[26];
    private int pause=1, num=1;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("shieldEffect ("+i+").png");
        }
    }
    
    public void act()
    {
        setLocation(HeroMechanics.xPosition, HeroMechanics.yPosition);
        animation();
        if(HeroMechanics.addShieldEffect == false)
        {
            getWorld().removeObject(this);
        }
    }
    //set animation
    public void animation()
    {
        if(pause==0){
            pause=1;
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