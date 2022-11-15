import greenfoot.*;

public class SawBlade extends Objects
{
    private GreenfootImage[] images = new GreenfootImage[10];
    private int pause=1, num=1;
    public static boolean hitting = false;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("sawBlade"+i+".png");
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