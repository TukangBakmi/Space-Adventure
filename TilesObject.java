import greenfoot.*;

public class TilesObject extends Tiles
{
    static final int gravity = 2;   //kecepatan gravitasi
    int ySpeed = 0; //kecepatan jatuh
    
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