import greenfoot.*;

public class BossCredit extends CreditSceneBackground
{
    //untuk animasi
    private GreenfootImage[] images = new GreenfootImage[26];
    private int pause = 3;
    private int num = 1;
    //untuk pergerakan
    int dx = 1;
    int xSpeed = 1; //kecepatan bergerak horizontal
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("bossCredit ("+i+").png");
        }
    }
    
    public void act()
    {
        animation();
        moveHorizontal();
    }
    
    public void animation()
    {
        if(pause==0){
            pause=3;
        }
        if(pause%4 == 0){
            moveHorizontal();
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
    
    public void moveHorizontal()
    {
        setLocation(getX()+dx*xSpeed, getY());
    }
}