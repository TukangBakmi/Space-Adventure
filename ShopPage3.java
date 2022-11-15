import greenfoot.*;

public class ShopPage3 extends World
{
    MaxSaber saber = new MaxSaber();
    MaxLaser laser = new MaxLaser();
    BotLeft button1 = new BotLeft();
    BotRight button2 = new BotRight();
    
    public ShopPage3()
    {
        super(1024, 576, 1, false); 
        prepare();
    }
    
    public void act()
    {
        maxLevel();
        ShopPage1.startBGM();
    }

    private void prepare()
    {
        ShopPage1.shopPage = 3;
        addObject(saber, 325,452);
        saber.getImage().setTransparency(0);
        addObject(laser, 699,452);
        laser.getImage().setTransparency(0);
        addObject(new Continue(),841,60);
        addObject(new ArrowLeft(),74,338);
        addObject(new UpLeft(),229,288);
        addObject(new UpRight(),600,288);
        addObject(button1,229,516);
        addObject(button2,600,516);
        //menambahkan label coin
        Label label = new Label("" + CoinIcon.myCoins);
        addObject(label,540-label.getImage().getWidth()/2, 38+label.getImage().getHeight()/2);
        addObject(new CoinIcon(label), 570,60);
        //menambahkan inventory
        Inventory.isOpened = false;
        addInventory();
    }
    
    private void addInventory()
    {
        addObject(new Inventory(), 512, 560);
        addObject(new InventoryItem(), 512, 635);
        //potion
        PotionAmt potionLabel = new PotionAmt("Amt:\n  " + Item.potion);
        addObject(potionLabel, 232,635);
        addObject(new Potion(potionLabel), 232, 635);
        addObject(new PotionImg(), 232, 635);
        //hiPotion
        HiPotionAmt hiPotionLabel = new HiPotionAmt("Amt:\n  " + Item.hiPotion);
        addObject(hiPotionLabel, 312,635);
        addObject(new HiPotion(hiPotionLabel), 312, 635);
        addObject(new HiPotionImg(), 312, 635);
        //antidote
        AntidoteAmt antidoteLabel = new AntidoteAmt("Amt:\n  " + Item.antidote);
        addObject(antidoteLabel, 392,635);
        addObject(new Antidote(antidoteLabel), 392, 635);
        addObject(new AntidoteImg(), 392, 635);
        //rage
        RageAmt rageLabel = new RageAmt("Amt:\n  " + Item.rage);
        addObject(rageLabel, 472,635);
        addObject(new Rage(rageLabel), 472, 635);
        addObject(new RageImg(), 472, 635);
        //battery
        BatteryItemAmt batteryLabel = new BatteryItemAmt("Amt:\n  " + Item.battery);
        addObject(batteryLabel, 552,635);
        addObject(new BatteryItem(batteryLabel), 552, 635);
        addObject(new BatteryImg(), 552, 635);
        //shield
        ShieldItemAmt shieldLabel = new ShieldItemAmt("Amt:\n  " + Item.antidote);
        addObject(shieldLabel, 632,635);
        addObject(new ShieldItem(shieldLabel), 632, 635);
        addObject(new ShieldImg(), 632, 635);
        //interferon
        InterferonAmt interferonLabel = new InterferonAmt("Amt:\n  " + Item.interferon);
        addObject(interferonLabel, 712,635);
        addObject(new Interferon(interferonLabel), 712, 635);
        addObject(new InterferonImg(), 712, 635);
        //crystal
        CrystalAmt crystalLabel = new CrystalAmt("Amt:\n  " + Item.crystal);
        addObject(crystalLabel, 792,635);
        addObject(new Crystal(crystalLabel), 792, 635);
        addObject(new CrystalImg(), 792, 635);
    }
    
    private void maxLevel()
    {
        if(Item.levelHp >= 6)
        {
            addObject(new MaxHp(), 325,224);
        }
        if(Item.levelBattery >= 6)
        {
            addObject(new MaxBattery(), 699,224);
        }
        if(Item.levelSaber >= 6)
        {
            saber.getImage().setTransparency(255);
            removeObject(button1);
        }
        if(Item.levelLaser >= 6)
        {
            laser.getImage().setTransparency(255);
            removeObject(button2);
        }
    }
}