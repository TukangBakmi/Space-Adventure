import greenfoot.*;

public class SaberSlash extends Objects
{
    private GreenfootImage[] images = new GreenfootImage[13];
    private GreenfootImage[] mirroredImages = new GreenfootImage[13];
    private int pause=1, num=0;
    public static boolean hitEnemy = false;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("saberSlash"+i+".png");
        }
        for(int j = 1; j<images.length; j++){
            GreenfootImage mirroredImage = new GreenfootImage("saberSlash"+j+".png");
            mirroredImage.mirrorHorizontally();
            mirroredImages[j] = mirroredImage;
        }
    }
    
    public void act()
    {
        moveObjects();
        animation();
    }
    //set animation
    public void animation()
    {
        if(pause==0){
            pause=1;
        }
        if(pause==1){
            if(HeroMechanics.faceLeft == true)
            {
                setImage(images[num]);
            }
            else if(HeroMechanics.faceRight == true)
            {
                setImage(mirroredImages[num]);
            }
            num++;
            if(num >= images.length){
                num=12;
                getWorld().removeObject(this);
                hitEnemy = false;
                HeroMechanics.saberAttack = false;
            }
        }
        if(pause>0){
            pause--;
        }
    }
}