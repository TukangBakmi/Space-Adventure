import greenfoot.*;

public class Rage extends Item
{
    public static boolean hoverRage = false;
    private RageAmt myRage;
    
    public Rage(RageAmt rageAmmount)
    {
        myRage = rageAmmount;
    }
    
    public void act()
    {
        myRage.setText("Amt:\n  " + Item.rage);
        show();
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol ketika ditekan
            setImage("itemRage.png");
            Greenfoot.delay(4);
            setImage("itemHoverRage.png");
            //soundeffect
            if(Item.rage <= 0)
                emptyItemSound();
            else
                buttonClick();
            //mengurangi item & memberi efek
            if(Item.rage > 0)
            {
                HeroMechanics.onRage = true;
                Item.rage--;
            }
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("itemHoverRage.png");
            hoverRage = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("itemRage.png");
            hoverRage = false;
        }
    }
}