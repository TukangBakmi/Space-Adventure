import greenfoot.*;

public class ShieldItemAmt extends Item
{
    public ShieldItemAmt(String text)
    {
        GreenfootImage itemAmmount = new GreenfootImage (60, 45);
        itemAmmount.setColor(Color.BLACK);
        itemAmmount.setFont(new Font("OptimusPrinceps", false, false , 18));
        itemAmmount.drawString(text, 12, 16);
        setImage(itemAmmount);
    }
    
    public void setText(String text)
    {
        GreenfootImage itemAmmount = getImage();
        itemAmmount.clear();
        GreenfootImage newItemAmmount = new GreenfootImage (60, 45);
        newItemAmmount.setColor(Color.BLACK);
        newItemAmmount.setFont(new Font("OptimusPrinceps", false, false , 18));
        newItemAmmount.drawString(text, 12, 16);
        setImage(newItemAmmount);
    }
    
    public void act()
    {
        showAmt();
    }
}