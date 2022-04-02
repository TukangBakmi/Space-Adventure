import greenfoot.*;

public class PoisonEffect extends Objects
{
    private GreenfootImage[] smokeImages = new GreenfootImage[36];
    private int pause=2, countDown=pause;
    private int Num=1;
    public static boolean hitting = false;
    public static int damage = 50;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<smokeImages.length; i++){
            smokeImages[i] = new GreenfootImage("poison"+i+".png");
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
            pause=2;
        }
        if(pause==1){
            setImage(smokeImages[Num]);
            getImage().scale(340, 218);
            Num++;
            if(Num >= smokeImages.length){
                getWorld().removeObject(this);
            }
        }
        if(pause>0){
            pause--;
        }
    }
}