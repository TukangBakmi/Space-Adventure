import greenfoot.*;

public class BossStatusIcon extends BossStatus
{
    private BossStatusLabel bossStatLabel;
    public static String status = "-";
    
    public BossStatusIcon(BossStatusLabel statLabel)
    {
        bossStatLabel = statLabel;
    }
    
    public void act()
    {
        if(Boss.defiance && Boss.rage && Boss.shield && Boss.regen)
            status = "Defiance, Rage, Shield, Regen";
            
        else if(Boss.defiance && Boss.rage && Boss.shield)
            status = "Defiance, Rage, Shield";
        else if(Boss.defiance && Boss.rage && Boss.regen)
            status = "Defiance, Rage, Regen";
        else if(Boss.defiance && Boss.shield && Boss.regen)
            status = "Defiance, Shield, Regen";
        else if(Boss.rage && Boss.shield && Boss.regen)
            status = "Rage, Shield, Regen";
            
        else if(Boss.defiance && Boss.rage)
            status = "Defiance, Rage";
        else if(Boss.defiance && Boss.shield)
            status = "Defiance, Shield";
        else if(Boss.defiance && Boss.regen)
            status = "Defiance, Regen";
        else if(Boss.rage && Boss.shield)
            status = "Rage, Shield";
        else if(Boss.rage && Boss.regen)
            status = "Rage, Regen";
        else if(Boss.shield && Boss.regen)
            status = "Shield, Regen";
        
        else if(Boss.defiance)
            status = "Defiance";
        else if(Boss.rage)
            status = "Rage";
        else if(Boss.shield)
            status = "Shield";
        else if(Boss.regen)
            status = "Regen";
            
        else
            status = "-";
        bossStatLabel.setText("Status: " + status);
    }
}