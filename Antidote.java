import greenfoot.*;

public class Antidote extends Item
{
    public static boolean hoverAntidote = false;
    private AntidoteAmt myAntidote;
    
    public Antidote(AntidoteAmt antidoteAmmount)
    {
        myAntidote = antidoteAmmount;
    }
    
    public void act()
    {
        myAntidote.setText("Amt:\n  " + Item.antidote);
        show();
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol ketika ditekan
            setImage("itemAntidote.png");
            Greenfoot.delay(4);
            setImage("itemHoverAntidote.png");
            //soundeffect
            if(Item.antidote <= 0)
                emptyItemSound();
            else
                buttonClick();
            //mengurangi item & memberi efek
            if(Item.antidote > 0)
            {
                Item.antidote--;
                HeroMechanics.burn = false;
                HeroMechanics.confuse = false;
                HeroMechanics.poison = false;
                getWorld().addObject(new AntidoteEffect(), HeroMechanics.xPosition, HeroMechanics.yPosition-20);
            }
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("itemHoverAntidote.png");
            hoverAntidote = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("itemAntidote.png");
            hoverAntidote = false;
        }
    }
}