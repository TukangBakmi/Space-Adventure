import greenfoot.*;

public class ShopPage1 extends World
{
    public static int shopPage = 1;
    
    public ShopPage1()
    {
        super(1024, 576, 1, false); 
        prepare();
    }

    private void prepare()
    {
        shopPage = 1;
        addObject(new Continue(),841,60);
        addObject(new ArrowRight(),950,338);
        addObject(new UpLeft(),229,288);
        addObject(new UpRight(),600,288);
        addObject(new BotLeft(),229,516);
        addObject(new BotRight(),600,516);
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
    
    public void act()
    {
        startBGM();
    }
    //memulai musik dengan loop
    public static void startBGM()
    {
        BackGroundMusic.shop.setVolume(50);
        BackGroundMusic.shop.play();
    }
    //memberhentikan musik
    public static void stopBGM()
    {
        BackGroundMusic.shop.stop();
    }
}