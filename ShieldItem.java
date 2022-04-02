import greenfoot.*;

public class ShieldItem extends Item
{
    public static boolean hoverShield = false;
    private ShieldItemAmt myShield;
    
    public ShieldItem(ShieldItemAmt shieldAmmount)
    {
        myShield = shieldAmmount;
    }
    
    public void act()
    {
        myShield.setText("Amt:\n  " + Item.shield);
        show();
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol ketika ditekan
            setImage("itemShield.png");
            Greenfoot.delay(4);
            setImage("itemHoverShield.png");
            //soundeffect
            if(Item.shield <= 0)
                emptyItemSound();
            else
                buttonClick();
            //mengurangi item & memberi efek
            if(Item.shield > 0)
            {
                HeroMechanics.onShield = true;
                HeroMechanics.shieldAmmount = HeroMechanics.maxHealthPoints * 30 / 100;
                Item.shield--;
            }
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("itemHoverShield.png");
            hoverShield = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("itemShield.png");
            hoverShield = false;
        }
    }
}