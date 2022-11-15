import greenfoot.*;

public class StatusIcon extends MyStatus
{
    private StatusLabel myStatLabel;
    public static String status = "-";
    
    public StatusIcon(StatusLabel statLabel)
    {
        myStatLabel = statLabel;
    }
    
    public void act()
    {
        if(HeroMechanics.onRage && HeroMechanics.onShield && HeroMechanics.burn && HeroMechanics.confuse  && HeroMechanics.poison)
            status = "Rage, Shield, Burn, Confuse, Poison";
            
        else if(HeroMechanics.onRage && HeroMechanics.onShield && HeroMechanics.burn && HeroMechanics.confuse)
            status = "Rage, Shield, Burn, Confuse";
        else if(HeroMechanics.onRage && HeroMechanics.onShield && HeroMechanics.burn && HeroMechanics.poison)
            status = "Rage, Shield, Burn, Poison";
        else if(HeroMechanics.onRage && HeroMechanics.onShield && HeroMechanics.confuse && HeroMechanics.poison)
            status = "Rage, Shield, Confuse, Poison";
        else if(HeroMechanics.onRage && HeroMechanics.burn && HeroMechanics.confuse && HeroMechanics.poison)
            status = "Rage, Burn, Confuse, Poison";
        else if(HeroMechanics.onShield && HeroMechanics.burn && HeroMechanics.confuse && HeroMechanics.poison)
            status = "Shield, Burn, Confuse, Poison";
            
        else if(HeroMechanics.onRage && HeroMechanics.onShield && HeroMechanics.burn)
            status = "Rage, Shield, Burn";
        else if(HeroMechanics.onRage && HeroMechanics.onShield && HeroMechanics.confuse)
            status = "Rage, Shield, Confuse";
        else if(HeroMechanics.onRage && HeroMechanics.onShield && HeroMechanics.poison)
            status = "Rage, Shield, Poison";
        else if(HeroMechanics.onRage && HeroMechanics.burn && HeroMechanics.confuse)
            status = "Rage, Burn, Confuse";
        else if(HeroMechanics.onRage && HeroMechanics.burn && HeroMechanics.poison)
            status = "Rage, Burn, Poison";
        else if(HeroMechanics.onRage && HeroMechanics.confuse && HeroMechanics.poison)
            status = "Rage, Confuse, Poison";
        else if(HeroMechanics.onShield && HeroMechanics.burn && HeroMechanics.confuse)
            status = "Shield, Burn, Confuse";
        else if(HeroMechanics.onShield && HeroMechanics.burn && HeroMechanics.poison)
            status = "Shield, Burn, Poison";
        else if(HeroMechanics.onShield && HeroMechanics.confuse && HeroMechanics.poison)
            status = "Shield, Confuse, Poison";
        else if(HeroMechanics.burn && HeroMechanics.confuse && HeroMechanics.poison)
            status = "Burn, Confuse, Poison";
            
        else if(HeroMechanics.poison && HeroMechanics.burn)
            status = "Burn, Poison";
        else if(HeroMechanics.poison && HeroMechanics.onRage)
            status = "Rage, Poison";
        else if(HeroMechanics.poison && HeroMechanics.onShield)
            status = "Shield, Poison";
        else if(HeroMechanics.poison && HeroMechanics.confuse)
            status = "Confuse, Poison";
        else if(HeroMechanics.onRage && HeroMechanics.burn)
            status = "Rage, Burn";
        else if(HeroMechanics.onShield && HeroMechanics.burn)
            status = "Shield, Burn";
        else if(HeroMechanics.confuse && HeroMechanics.burn)
            status = "Burn, Confuse";
        else if(HeroMechanics.onRage && HeroMechanics.onShield)
            status = "Rage, Shield";
        else if(HeroMechanics.onRage && HeroMechanics.confuse)
            status = "Rage, Confuse";
        else if(HeroMechanics.onShield && HeroMechanics.confuse)
            status = "Shield, Confuse";
        
        else if(HeroMechanics.burn)
            status = "Burn";
        else if(HeroMechanics.poison)
            status = "Poison";
        else if(HeroMechanics.onRage)
            status = "Rage";
        else if(HeroMechanics.onShield)
            status = "Shield";
        else if(HeroMechanics.confuse)
            status = "Confuse";
        else
            status = "-";
        myStatLabel.setText("Status: " + status);
    }
}