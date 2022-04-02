import greenfoot.*;

public class HpIcon extends MyHealthPoint
{
    private HpLabel myHpLabel;
    
    public HpIcon(HpLabel hpLabel)
    {
        myHpLabel = hpLabel;
    }
    
    public void act()
    {
        myHpLabel.setText("Hp: " + HeroMechanics.healthPoints + "/" + HeroMechanics.maxHealthPoints);
        setImage(HeroMechanics.healthPoints + "-" + HeroMechanics.maxHealthPoints + ".png");
        changePosition();
    }
    
    private void changePosition()
    {
        if(HeroMechanics.maxHealthPoints == 300)
            setLocation(156, 69);
        if(HeroMechanics.maxHealthPoints == 400)
            setLocation(176, 69);
        if(HeroMechanics.maxHealthPoints == 500)
            setLocation(196, 69);
        if(HeroMechanics.maxHealthPoints == 600)
            setLocation(216, 69);
        if(HeroMechanics.maxHealthPoints == 700)
            setLocation(236, 69);
    }
}