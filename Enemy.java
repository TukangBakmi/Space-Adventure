import greenfoot.*;

public class Enemy extends Actor
{
    static final int gravity = 2;   //kecepatan gravitasi
    int ySpeed = 0; //kecepatan jatuh
    
    public void moveVertically()
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
    
    public void moveBecauseScrollingBg()
    {
        if(HeroMechanics.isDead == false)
            setLocation(getX() + Stage1.objectSpeed, getY());
    }
}