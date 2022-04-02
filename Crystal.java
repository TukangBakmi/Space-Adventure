import greenfoot.*;

public class Crystal extends Item
{
    public static boolean hoverCrystal = false;
    private CrystalAmt myCrystal;
    
    public Crystal(CrystalAmt crystalAmmount)
    {
        myCrystal = crystalAmmount;
    }
    
    public void act()
    {
        myCrystal.setText("Amt:\n  " + Item.crystal);
        show();
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol ketika ditekan
            setImage("itemCrystal.png");
            Greenfoot.delay(4);
            if(Item.crystal <= 0)
                setImage("itemHoverDontHaveCrystal.png");
            else
                setImage("itemHoverHaveCrystal.png");
            //soundeffect
            emptyItemSound();
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            if(Item.crystal <= 0)
                setImage("itemHoverDontHaveCrystal.png");
            else
                setImage("itemHoverHaveCrystal.png");
            hoverCrystal = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("itemCrystal.png");
            hoverCrystal = false;
        }
    }
}