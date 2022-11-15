import greenfoot.*;

public class AcidBubble extends Objects
{
    private boolean saveHeight = false;
    private int height;
    private int pause = 4;
    private int y;
    
    public void move()
    {
        if(pause==0){
            pause=4;
        }
        if(pause==1){
            if(saveHeight == false)
            {
                height = getY();
                y = (getY() / 64) * 64;
                saveHeight = true;
            }
            setLocation(getX(), getY()-1);
            if(getY() <= y)
            {
                setLocation(getX(), height + 5);
            }
        }
        if(pause>0){
            pause--;
        }
    }
}