import greenfoot.*;

public class Acid1 extends Acid
{
    private GreenfootImage[] images = new GreenfootImage[5];
    private int pause=10, num=1;
    public static boolean hitting = false;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("acid"+i+".png");
        }
        setImage(images[1]);
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
            pause=10;
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