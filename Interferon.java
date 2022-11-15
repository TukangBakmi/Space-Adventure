import greenfoot.*;

public class Interferon extends Item
{
    public static boolean hoverInterferon = false;
    private int healPoint;
    private InterferonAmt myInterferon;
    
    public Interferon(InterferonAmt interferonAmmount)
    {
        myInterferon = interferonAmmount;
    }
    
    public void act()
    {
        myInterferon.setText("Amt:\n  " + Item.interferon);
        show();
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol ketika ditekan
            setImage("itemInterferon.png");
            Greenfoot.delay(4);
            setImage("itemHoverInterferon.png");
            //soundeffect
            if(Item.interferon <= 0)
                emptyItemSound();
            else
                buttonClick();
            //mengurangi item & memberi efek
            if(Item.interferon > 0)
            {
                Item.interferon--;
                HeroMechanics.burn = false;
                HeroMechanics.confuse = false;
                HeroMechanics.poison = false;
                //text heal
                healPoint = HeroMechanics.maxHealthPoints - HeroMechanics.healthPoints;
                HealEffect textHeal = new HealEffect("" + healPoint);
                getWorld().addObject(textHeal, HeroMechanics.xPosition, HeroMechanics.yPosition);
                HeroMechanics.healthPoints += healPoint;
                getWorld().addObject(new InterferonEffect(), HeroMechanics.xPosition, HeroMechanics.yPosition-20);
            }
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("itemHoverInterferon.png");
            hoverInterferon = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("itemInterferon.png");
            hoverInterferon = false;
        }
    }
}