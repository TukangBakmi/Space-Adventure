import greenfoot.*;

public class InventoryItem extends Images
{
    public void act()
    {
        show();
        hover();
    }
    
    private void show()
    {
        if(Inventory.isOpened == true)
        {
            setLocation(512, 517);
        }
        else
        {
            setLocation(512, 635);
        }
    }
    
    public void showItem()
    {
        if(Inventory.isOpened == true)
        {
            setLocation(getX(), 501);
        }
        else if(Inventory.isOpened == false)
        {
            setLocation(getX(), 635);
        }
    }
    
    private void hover()
    {
        if(Greenfoot.mouseMoved(this))
        {
            Inventory.cursorOnInventoryBox = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            Inventory.cursorOnInventoryBox = false;
        }
    }
}