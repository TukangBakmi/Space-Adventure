import greenfoot.*;

public class CrystalEffect1 extends ItemEffects
{
    private GreenfootImage[] images = new GreenfootImage[11];
    private int pause=3, num=1;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("immortalityEffect1 ("+i+").png");
        }
    }
    
    public void act()
    {
        setLocation(HeroMechanics.xPosition, HeroMechanics.yPosition);
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
            getImage().scale(96,159);
            num++;
            if(num >= images.length){
                Greenfoot.delay(55);
                HeroMechanics.revived = true;
                //play sound effect
                GreenfootSound revive = new GreenfootSound("revive.wav");
                revive.play();
                getWorld().addObject(new CrystalEffect2(), getX(), getY()-15);
                getWorld().removeObject(this);
            }
        }
        if(pause>0){
            pause--;
        }
    }
}