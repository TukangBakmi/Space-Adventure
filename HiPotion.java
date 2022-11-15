import greenfoot.*;

public class HiPotion extends Item
{
    public static boolean hoverHiPotion = false;
    private int healPoint = 200;
    private HiPotionAmt myHiPotion;
    
    public HiPotion(HiPotionAmt hiPotionAmmount)
    {
        myHiPotion = hiPotionAmmount;
    }
    
    public void act()
    {
        myHiPotion.setText("Amt:\n  " + Item.hiPotion);
        show();
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol ketika ditekan
            setImage("itemHiPotion.png");
            Greenfoot.delay(4);
            setImage("itemHoverHiPotion.png");
            //soundeffect
            if(Item.hiPotion <= 0)
                emptyItemSound();
            else
                buttonClick();
            //mengurangi item & memberi efek
            if(Item.hiPotion > 0)
            {
                Item.hiPotion--;
                if(HeroMechanics.healthPoints + healPoint > HeroMechanics.maxHealthPoints)
                {
                    healPoint = HeroMechanics.maxHealthPoints-HeroMechanics.healthPoints;
                }
                HeroMechanics.healthPoints += healPoint;
                //text heal
                HealEffect textHeal = new HealEffect("" + healPoint);
                getWorld().addObject(textHeal, HeroMechanics.xPosition, HeroMechanics.yPosition);
                healPoint = 200;
            }
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("itemHoverHiPotion.png");
            hoverHiPotion = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("itemHiPotion.png");
            hoverHiPotion = false;
        }
    }
}