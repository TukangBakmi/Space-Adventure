import greenfoot.*;

public class BossHpIcon extends BossHp
{
    private BossHpLabel bossHpLabel;
    
    public BossHpIcon(BossHpLabel hpLabel)
    {
        bossHpLabel = hpLabel;
    }
    
    public void act()
    {
        bossHpLabel.setText("Enemy Hp: " + Boss.hp*100/Boss.maxHp + "%");
    }
}