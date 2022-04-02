import greenfoot.*;

public class Potion extends Item
{
    public static boolean hoverPotion = false;
    private int healPoint = 100;
    private PotionAmt myPotion;
    
    public Potion(PotionAmt potionAmmount)
    {
        myPotion = potionAmmount;
    }
    
    public void act()
    {
        myPotion.setText("Amt:\n  " + Item.potion);
        show();
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol ketika ditekan
            setImage("itemPotion.png");
            Greenfoot.delay(4);
            setImage("itemHoverPotion.png");
            //soundeffect
            if(Item.potion <= 0)
                emptyItemSound();
            else
                buttonClick();
            //mengurangi item & memberi efek
            if(Item.potion > 0)
            {
                Item.potion--;
                if(HeroMechanics.healthPoints + healPoint > HeroMechanics.maxHealthPoints)
                {
                    healPoint = HeroMechanics.maxHealthPoints-HeroMechanics.healthPoints;
                }
                HeroMechanics.healthPoints += healPoint;
                //text heal
                HealEffect textHeal = new HealEffect("" + healPoint);
                getWorld().addObject(textHeal, HeroMechanics.xPosition, HeroMechanics.yPosition);
                healPoint = 100;
            }
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("itemHoverPotion.png");
            hoverPotion = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("itemPotion.png");
            hoverPotion = false;
        }
    }
}