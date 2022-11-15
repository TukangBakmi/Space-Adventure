import greenfoot.*;

public class CoinMove extends Coin
{
    private int speed = 16; //semakin kecil, semakin cepat
    
    public void act()
    {
        animation();
        move();
    }
    
    private void move()
    {
        if(getX() < 987)
        {
            setLocation(getX()+(987-getX())/speed, getY());
            if(getY() < 37)
            {
                setLocation(getX(), getY()+(getY()-37)/speed);
            }
            else if(getY() >= 37)
            {
                setLocation(getX(), getY()-(getY()-37)/speed);
            }
        }
        else if(getX() >= 987)
        {
            setLocation(getX()-(987-getX())/speed, getY());
            if(getY() < 37)
            {
                setLocation(getX(), getY()+(getY()-37)/speed);
            }
            else if(getY() >= 37)
            {
                setLocation(getX(), getY()-(getY()-37)/speed);
            }
        }
    }
}