import greenfoot.*;

public class UnknownAlienCredit extends CreditSceneBackground
{
    //untuk animasi
    private GreenfootImage[] mirroredImages = new GreenfootImage[30];
    private int pause = 3;
    private int num = 1;
    //untuk pergerakan
    int xSpeed = 1; //kecepatan bergerak horizontal
    
    public void addedToWorld(World Stage1)
    {
        for(int j = 1; j<mirroredImages.length; j++){
            GreenfootImage mirroredImage = new GreenfootImage("unknownAlien ("+j+").png");
            mirroredImage.mirrorHorizontally();
            mirroredImages[j] = mirroredImage;
        }
    }
    
    public void act()
    {
        moveHorizontal();
        animation();
    }
    
    public void animation()
    {
        if(pause==0){
            pause=3;
        }
        if(pause==1){
            setImage(mirroredImages[num]);
            num++;
            if(num >= mirroredImages.length){
                num=1;
            }
        }
        if(pause>0){
            pause--;
        }
    }
    
    public void moveHorizontal()
    {
        setLocation(getX()+xSpeed, getY());
    }
}