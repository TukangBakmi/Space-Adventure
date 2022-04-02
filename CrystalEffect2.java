import greenfoot.*;

public class CrystalEffect2 extends ItemEffects
{
    private GreenfootImage[] images = new GreenfootImage[13];
    private int pause=3, num=1;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("immortalityEffect2 ("+i+").png");
        }
    }
    
    public void act()
    {
        animation();
        setLocation(HeroMechanics.xPosition, HeroMechanics.yPosition);
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