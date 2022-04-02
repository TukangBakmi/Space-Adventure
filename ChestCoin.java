import greenfoot.*;

public class ChestCoin extends Objects
{
    static final int gravity = 2;   //kecepatan gravitasi
    int ySpeed = 0; //kecepatan jatuh
    public static boolean chestCoinOpened = false;
    
    public void act()
    {
        moveObjects();
        gravity();
        open();
    }
    
    private void open()
    {
        if(getOneIntersectingObject(HeroMechanics.class) != null && Greenfoot.isKeyDown("e") && chestCoinOpened == false)
        {
            setLocation(getX(), getY()-5);
            setImage("chestCoinOpen.png");
            getWorld().addObject(new Coin(), getX()-30, getY());
            getWorld().addObject(new Coin(), getX()-15, getY());
            getWorld().addObject(new Coin(), getX(), getY());
            getWorld().addObject(new Coin(), getX()+15, getY());
            getWorld().addObject(new Coin(), getX()+30, getY());
            chestCoinOpened = true;
        }
    }
    
    public void gravity()
    {
        ySpeed += gravity;  //Meningkatkan kecepatan jatuh
        //Membuat enemy berpindah sesuai kecepatan
        setLocation(getX(), getY()+ySpeed);
        int dy = (int)Math.signum(ySpeed);
        while(getOneIntersectingObject(Tiles.class) != null)
        {
            setLocation(getX(), getY()-dy);
            ySpeed = 0;
        }
    }
}