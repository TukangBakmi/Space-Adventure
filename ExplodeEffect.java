import greenfoot.*;

public class ExplodeEffect extends Objects
{
    private GreenfootImage[] explosionImages = new GreenfootImage[44];
    private int pause=1, countDown=pause;
    private int explodeNum=1;
    public static boolean hitting = false;
    public static int damage = 90;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<explosionImages.length; i++){
            explosionImages[i] = new GreenfootImage("explosion ("+i+").png");
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
        if(countDown==0){
            countDown=pause;
        }
        if(countDown==1){
            setImage(explosionImages[explodeNum]);
            getImage().scale(340,365);
            explodeNum++;
            if(explodeNum >= explosionImages.length){
                getWorld().removeObject(this);
            }
        }
        if(countDown>0){
            countDown--;
        }
    }
}