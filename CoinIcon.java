import greenfoot.*;

public class CoinIcon extends MyCoins
{
    public static int myCoins = 0;
    private Label myLabel;
    
    public CoinIcon(Label label)
    {
        myLabel = label;
    }
    
    public void act()
    {
        myLabel.setText("" + myCoins);
        Actor b = getOneIntersectingObject(CoinMove.class);  
        if(b != null)
        {
            getWorld().removeObject(b);
        }
    }
}