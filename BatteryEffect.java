import greenfoot.*;

public class BatteryEffect extends ItemEffects
{
    private GreenfootImage[] images = new GreenfootImage[8];
    private int pause=2, num=1;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("batteryEffect ("+i+").png");
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
            pause=2;
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