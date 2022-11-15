import greenfoot.*;

public class HeroMechanics extends Hero
{
    static final int gravity = 2;   //kecepatan gravitasi
    static final int jumpForce = 31;    //gaya lompat hero
    public static int dx = 0;
    public static int xSpeed = 8; //kecepatan bergerak horizontal
    public static int ySpeed = 0; //kecepatan jatuh
    public static boolean faceLeft = false;           //hero menghadap kiri
    public static boolean faceRight = true;   //hero menghadap kanan
    //fitur dead
    public static boolean isDead = false;
    //fitur battery
    public static boolean displayBatteryIcon = false;
    //fitur change weapon
    public static boolean saberAttack = false;
    public static boolean usingMelee = true;
    public static boolean usingRanged = false;
    private int pause = 15;
    //atribut hero
    public static int healthPoints = 700;
    public static int maxHealthPoints = 700;
    public static int batteryInt = 10;
    public static int maxBattery = 10;
    public static int laserDamage = 10;
    public static int saberDamage = 10;
    public static int xPosition;
    public static int yPosition;
    //debuff
    public static boolean poison = false;
    private int poisonDuration = 5010;
    public static boolean burn = false;
    private int burnDuration = 1010;
    public static boolean confuse = false;
    //buff
    public static boolean onRage = false;
    public static boolean addRageEffect = false;
    private boolean addSaberBuff = false;
    private boolean addLaserBuff = false;
    public static int rageDuration;
    public static boolean onShield = false;
    public static boolean addShieldEffect = false;
    public static int shieldAmmount;
    public static boolean revived = false;
    //enemyDamage
    private int acidDamage = 60;
    private int spikeDamage = 50;
    private int sawBladeDamage = 100;
    private int fallDamage = 120;
    private int poisonDamage = 10;
    private int burnDamage = 20;
    private int hitTimeDynamic = 60;
    private int hitTime = 60;
    
    public void act()
    {
        if(isDead == false)
        {
            heroAttack();           //attack
            heroFall();             //jatuh keluar screen
            acidCollision();        //jika terkena acid
            spikesCollision();      //jika terkena spike
            sawBladeCollision();    //jika terkena sawblade
            //jika terkena musuh
            slimeCollision();
            robotCollision();
            ufoCollision();
            shooter1Collision();
            flameAlienCollision();
            toxicAlienCollision();
            ufoShooterCollision();
            flyingRobotCollision();
            flyingSmallRobotCollision();
            smallRobotCollision();
            unknownAlienCollision();
            bossCollision();
            hitTimeDynamic++;
            invincible();
            
            displayBattery();       //menampilkan gambar battery
            xPosition = getX();
            yPosition = getY();
            adjustLevel();          //menyesuaikan level
            //buff & debuff
            rage();
            rageDuration--;
            shield();
            poison();               //debuff poison
            poisonCollision();      //check poison collision
            poisonDuration--;       //durasi poison
            burn();                 //debuff burn
            explosionCollision();   //check explosion collision
            burnDuration--;         //durasi burn
            heroDead();
            moveHorizontally();     //bergerak kiri kanan
            //Membuat hero tidak bisa menembus tiles
            while(isTouching(Tiles.class) == true|| getOneIntersectingObject(Tiles.class) != null)
            {
                setLocation(getX()-dx*xSpeed, getY());
            }
            moveVertically();       //lompat
        }
        if(revived == true)
        {
            healthPoints = maxHealthPoints * 20 / 100;
            isDead = false;
            getImage().setTransparency(255);
            poison = false;
            burn = false;
            confuse = false;
            onRage = false;
            HeroMechanics.onShield = true;
            HeroMechanics.shieldAmmount = HeroMechanics.healthPoints * 30 / 100;
            revived = false;
        }
    }
    
    private void moveHorizontally()
    {
        int worldWidth = getWorld().getWidth(); //lebar world
        int heroWidth = getImage().getWidth();  //lebar hero
        dx = 0; //kecepatan bergerak horizontal
        if(confuse == false)
        {
            if(Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
            {
                if(faceLeft == false)
                {
                    getImage().mirrorHorizontally();
                    faceLeft = true;
                    faceRight = false;
                }
                dx-=1;  //kecepatannya minus (ke kiri)
                //menggeser background
                if(getX() < 350 && getOneIntersectingObject(Tiles.class) == null)
                {
                    if(Stage1.leftScreenPosition <= 0)
                    {
                        Stage1.scrollBackgroundX(0);
                        Stage1.objectSpeed = 0;
                    }
                    else
                    {
                        Stage1.scrollBackgroundX(-xSpeed);
                        Stage1.leftScreenPosition -= xSpeed;
                        Stage1.rightScreenPosition -= xSpeed;
                        Stage1.objectSpeed = xSpeed;
                        dx = 0;
                    }
                }
                else
                {
                    Stage1.scrollBackgroundX(0);
                    Stage1.objectSpeed = 0;
                }
            }
            else if(Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("a") )
            {
                dx+=1;  //kecepatannya plus (ke kanan)
                if(faceRight == false)
                {
                    getImage().mirrorHorizontally();
                    faceRight = true;
                    faceLeft = false;
                }
                //menggeser background
                if(getX() > worldWidth-350 && getOneIntersectingObject(Tiles.class) == null)
                {
                    if(Stage1.rightScreenPosition >= 4096)
                    {
                        Stage1.scrollBackgroundX(0);
                        Stage1.objectSpeed = 0;
                    }
                    else
                    {
                        Stage1.scrollBackgroundX(xSpeed);
                        Stage1.rightScreenPosition += xSpeed;
                        Stage1.leftScreenPosition += xSpeed;
                        Stage1.objectSpeed = -xSpeed;
                        dx = 0;
                    }
                }
                else
                {
                    Stage1.scrollBackgroundX(0);
                    Stage1.objectSpeed = 0;
                }
            }
            else
            {
                Stage1.objectSpeed = 0;
            }
        }
        else
        {
            if(Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("w"))
            {
                if(faceLeft == false)
                {
                    getImage().mirrorHorizontally();
                    faceLeft = true;
                    faceRight = false;
                }
                dx-=1;  //kecepatannya minus (ke kiri)
                //menggeser background
                if(getX() < 350 && getOneIntersectingObject(Tiles.class) == null)
                {
                    if(Stage1.leftScreenPosition <= 0)
                    {
                        Stage1.scrollBackgroundX(0);
                        Stage1.objectSpeed = 0;
                    }
                    else
                    {
                        Stage1.scrollBackgroundX(-xSpeed);
                        Stage1.leftScreenPosition -= xSpeed;
                        Stage1.rightScreenPosition -= xSpeed;
                        Stage1.objectSpeed = xSpeed;
                        dx = 0;
                    }
                }
                else
                {
                    Stage1.scrollBackgroundX(0);
                    Stage1.objectSpeed = 0;
                }
            }
            else if(Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("d") )
            {
                dx+=1;  //kecepatannya plus (ke kanan)
                if(faceRight == false)
                {
                    getImage().mirrorHorizontally();
                    faceRight = true;
                    faceLeft = false;
                }
                //menggeser background
                if(getX() > worldWidth-350 && getOneIntersectingObject(Tiles.class) == null)
                {
                    if(Stage1.rightScreenPosition >= 4096)
                    {
                        Stage1.scrollBackgroundX(0);
                        Stage1.objectSpeed = 0;
                    }
                    else
                    {
                        Stage1.scrollBackgroundX(xSpeed);
                        Stage1.rightScreenPosition += xSpeed;
                        Stage1.leftScreenPosition += xSpeed;
                        Stage1.objectSpeed = -xSpeed;
                        dx = 0;
                    }
                }
                else
                {
                    Stage1.scrollBackgroundX(0);
                    Stage1.objectSpeed = 0;
                }
            }
            else
            {
                Stage1.objectSpeed = 0;
            }
        }
        //Membuat heronya berpindah sesuai kecepatan
        setLocation(getX()+(dx*xSpeed), getY());
        //Membuat hero tetap berada dalam screen
        if(getX() < heroWidth/2)
        {
            setLocation(heroWidth/2, getY());
        }
        if(getX() > worldWidth-heroWidth/2)
        {
            setLocation(worldWidth-heroWidth/2, getY());
        }
    }
    
    private void moveVertically()
    {
        int worldHeight = 1024;   //tinggi world
        int heroHeight = getImage().getHeight();    //tinggi hero
        boolean onGround = false;   //di atas tanah atau tidak
        ySpeed += gravity;  //Meningkatkan kecepatan jatuh
        //Membuat heronya berpindah sesuai kecepatan
        setLocation(getX(), getY()+ySpeed);
        int dy = (int)Math.signum(ySpeed);
            
        while(getOneIntersectingObject(Tiles.class) != null)
        {
            setLocation(getX(), getY()-dy);
            if(dy > 0) onGround = true;
            ySpeed = 0;
        }
        //Membuat hero lompat
        if(confuse == false)
        {
            if(onGround && Greenfoot.isKeyDown("w"))
            {
                ySpeed = -jumpForce;
                //play sound
                GreenfootSound jumpSound = new GreenfootSound("jumpSound.mp3");
                jumpSound.setVolume(70);
                jumpSound.play();
            }
        }
        else
        {
            if(onGround && Greenfoot.isKeyDown("c"))
            {
                ySpeed = -jumpForce;
                //play sound
                GreenfootSound jumpSound = new GreenfootSound("jumpSound.mp3");
                jumpSound.setVolume(70);
                jumpSound.play();
            }
        }
    }
    
    private void adjustLevel()
    {
        //menyesuaikan level max hp
        if(Item.levelHp == 2)
            maxHealthPoints = 300;
        else if(Item.levelHp == 3)
            maxHealthPoints = 400;
        else if(Item.levelHp == 4)
            maxHealthPoints = 500;
        else if(Item.levelHp == 5)
            maxHealthPoints = 600;
        else if(Item.levelHp == 6)
            maxHealthPoints = 700;
        //menyesuaikan level battery
        if(Item.levelBattery == 2)
            maxBattery = 20;
        else if(Item.levelBattery == 3)
            maxBattery = 30;
        else if(Item.levelBattery == 4)
            maxBattery = 40;
        else if(Item.levelBattery == 5)
            maxBattery = 50;
        else if(Item.levelBattery == 6)
            maxBattery = 60;
        //menyesuaikan level light saber
        if(Item.levelSaber == 1 && onRage == false)
            saberDamage = 16;
        else if(Item.levelSaber == 2 && onRage == false)
            saberDamage = 24;
        else if(Item.levelSaber == 3 && onRage == false)
            saberDamage = 36;
        else if(Item.levelSaber == 4 && onRage == false)
            saberDamage = 52;
        else if(Item.levelSaber == 5 && onRage == false)
            saberDamage = 72;
        else if(Item.levelSaber == 6 && onRage == false)
            saberDamage = 96;
        //menyesuaikan level laser gun
        if(Item.levelLaser == 1 && onRage == false)
            laserDamage = 8;
        else if(Item.levelLaser == 2 && onRage == false)
            laserDamage = 12;
        else if(Item.levelLaser == 3 && onRage == false)
            laserDamage = 18;
        else if(Item.levelLaser == 4 && onRage == false)
            laserDamage = 26;
        else if(Item.levelLaser == 5 && onRage == false)
            laserDamage = 36;
        else if(Item.levelLaser == 6 && onRage == false)
            laserDamage = 48;
    }
    
    private void heroAttack()
    {
        //cek kursor berada di area inventory atau tidak
        if(Inventory.cursorOnInventoryButton == true || Inventory.cursorOnInventoryBox == true || Inventory.cursorOnInventoryItems == true)
        {
            Inventory.cursorOnInventory = true;
        }
        else
        {
            Inventory.cursorOnInventory = false;
        }
        //hero attack
        if(usingRanged == true)
        {
            if(Greenfoot.mousePressed(null) && batteryInt > 0 && Inventory.cursorOnInventory == false)
            {
                //mengurangi peluru
                batteryInt --;
                //menggambar peluru
                Projectile shot = new Projectile();
                getWorld().addObject(shot, getX(), getY());
                shot.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                //play sound effect
                GreenfootSound shotLaser = new GreenfootSound("shotLaser.mp3");
                shotLaser.setVolume(65);
                shotLaser.play();
            }
            if(confuse == false)
            {
                if(Greenfoot.isKeyDown("c") && pause < 0)
                {
                    //play sound effect
                    GreenfootSound changeWeapon = new GreenfootSound("changeWeapon.mp3");
                    changeWeapon.setVolume(50);
                    changeWeapon.play();
                    //ganti gambar
                    setImage("heroMelee.png");
                    if(faceLeft == true)
                        getImage().mirrorHorizontally();
                    usingMelee = true;
                    usingRanged = false;
                    pause = 15;
                }
            }
            else
            {
                if(Greenfoot.isKeyDown("a") && pause < 0)
                {
                    //play sound effect
                    GreenfootSound changeWeapon = new GreenfootSound("changeWeapon.mp3");
                    changeWeapon.setVolume(50);
                    changeWeapon.play();
                    //ganti gambar
                    setImage("heroMelee.png");
                    if(faceLeft == true)
                        getImage().mirrorHorizontally();
                    usingMelee = true;
                    usingRanged = false;
                    pause = 15;
                }
            }
        }
        else if (usingMelee = true)
        {
            if(Greenfoot.mousePressed(null) && saberAttack == false && Inventory.cursorOnInventory == false)
            {
                saberAttack = true;
                //menggambar slash
                SaberSlash slash = new SaberSlash();
                if(faceLeft)
                    getWorld().addObject(slash, getX()-50, getY()-10);
                if(faceRight)
                    getWorld().addObject(slash, getX()+50, getY()-10);
                //play sound effect
                GreenfootSound saberAttack = new GreenfootSound("saberAttack.wav");
                saberAttack.setVolume(90);
                saberAttack.play();
            }
            if(confuse == false)
            {
                if(Greenfoot.isKeyDown("c") && pause < 0)
                {
                    //play sound effect
                    GreenfootSound changeWeapon = new GreenfootSound("changeWeapon.mp3");
                    changeWeapon.setVolume(50);
                    changeWeapon.play();
                    //ganti gambar
                    setImage("heroRanged.png");
                    if(faceLeft == true)
                        getImage().mirrorHorizontally();
                    usingRanged = true;
                    usingMelee = false;
                    pause = 15;
                }
            }
            else
            {
                if(Greenfoot.isKeyDown("a") && pause < 0)
                {
                    //play sound effect
                    GreenfootSound changeWeapon = new GreenfootSound("changeWeapon.mp3");
                    changeWeapon.setVolume(50);
                    changeWeapon.play();
                    //ganti gambar
                    setImage("heroRanged.png");
                    if(faceLeft == true)
                        getImage().mirrorHorizontally();
                    usingRanged = true;
                    usingMelee = false;
                    pause = 15;
                }
            }
        }
        pause--;
    }
    
    private void heroFall(){
        if(getY() >= getWorld().getHeight()){
            if(onShield == false)
            {
                healthPoints -= fallDamage;
                setLocation(getX(), getY() - 20);
                ySpeed = -(jumpForce);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + fallDamage);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
            }
            else
            {
                shieldAmmount -= fallDamage;
                setLocation(getX(), getY() - 20);
                ySpeed = -(jumpForce);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + fallDamage);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
    }
    
    private void invincible()
    {
        if(hitTime > hitTimeDynamic)
        {
            if((hitTimeDynamic+6)%12 == 0)
                getImage().setTransparency(10);
            if(hitTimeDynamic % 12 == 0)
                getImage().setTransparency(255);
        }
        else
        {
            getImage().setTransparency(255);
        }
    }
    
    public void rage()
    {
        int saberBuff;
        int laserBuff;
        if(onRage == true && addSaberBuff == false && addLaserBuff == false)
        {
            rageDuration = 3000;
            saberBuff = 150 * saberDamage / 100;
            saberDamage = saberBuff;
            addSaberBuff = true;
            laserBuff = 150 * laserDamage / 100;
            laserDamage = laserBuff;
            addLaserBuff = true;
        }
        if(onRage == true && addRageEffect == false)
        {
            getWorld().addObject(new RageEffect(), getX(), getY()+4);
            addRageEffect = true;
        }
        if(rageDuration <= 0)
        {
            onRage = false;
            addSaberBuff = false;
            addLaserBuff = false;
            addRageEffect = false;
        }
    }
    
    public void shield()
    {
        if(onShield == true && addShieldEffect == false)
        {
            getWorld().addObject(new ShieldEffect(), getX(), getY());
            addShieldEffect = true;
        }
        if(shieldAmmount <= 0)
        {
            onShield = false;
            addShieldEffect = false;
        }
    }
    
    public void explosionCollision()
    {
        if(isDead == false && getOneIntersectingObject(ExplodeEffect.class) != null && ExplodeEffect.hitting == false)
        {
            ExplodeEffect.hitting = true;
            if(onShield == false)
            {
                if(hitTimeDynamic > hitTime)
                {
                    healthPoints -= ExplodeEffect.damage;
                    ySpeed = -(jumpForce);  //knockback
                    //text damage
                    EnemyTextDamage textDamage = new EnemyTextDamage("" + ExplodeEffect.damage);
                    getWorld().addObject(textDamage, getX(), getY());
                    hitTimeDynamic = 0;
                }
                ySpeed = -(jumpForce);
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                burn = true;
                burnDuration = 1010;
            }
            else
            {
                shieldAmmount -= ExplodeEffect.damage;
                ySpeed = -(jumpForce + 5);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + ExplodeEffect.damage);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(ExplodeEffect.class) == null)
            ExplodeEffect.hitting = false;
    }
    
    public void burn()
    {
        if(burn == true && burnDuration % 100 == 0)
        {
            healthPoints -= burnDamage;
            //text damage
            EnemyTextDamage textDamage = new EnemyTextDamage("" + burnDamage);
            getWorld().addObject(textDamage, getX(), getY());
        }
        if(burnDuration <= 0)
        {
            burn = false;
        }
    }
    
    public void poisonCollision()
    {
        if(isDead == false && getOneIntersectingObject(PoisonEffect.class) != null && PoisonEffect.hitting == false)
        {
            PoisonEffect.hitting = true;
            if(onShield == false)
            {
                if(hitTimeDynamic > hitTime)
                {
                    healthPoints -= PoisonEffect.damage;
                    ySpeed = -(jumpForce);  //knockback
                    //text damage
                    EnemyTextDamage textDamage = new EnemyTextDamage("" + PoisonEffect.damage);
                    getWorld().addObject(textDamage, getX(), getY());
                    hitTimeDynamic = 0;
                }
                ySpeed = -(jumpForce);
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                poison = true;
                poisonDuration = 5010;
            }
            else
            {
                shieldAmmount -= PoisonEffect.damage;
                ySpeed = -(jumpForce + 5);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + PoisonEffect.damage);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(PoisonEffect.class) == null)
            PoisonEffect.hitting = false;
    }
    
    public void poison()
    {
        if(poison == true && poisonDuration % 200 == 0)
        {
            healthPoints -= poisonDamage;
            //text damage
            EnemyTextDamage textDamage = new EnemyTextDamage("" + poisonDamage);
            getWorld().addObject(textDamage, getX(), getY());
        }
        if(poisonDuration <= 0)
        {
            poison = false;
        }
    }
    
    public void acidCollision()
    {
        //jika hero terkena acid
        if(isDead == false && getOneIntersectingObject(Acid1.class) != null && Acid1.hitting == false)
        {
            Acid1.hitting = true;
            if(onShield == false)
            {
                if(hitTimeDynamic > hitTime)
                {
                    healthPoints -= acidDamage;
                    poison = true;
                    poisonDuration = 5010;
                    ySpeed = -(jumpForce - 3);  //knockback
                    //text damage
                    EnemyTextDamage textDamage = new EnemyTextDamage("" + acidDamage);
                    getWorld().addObject(textDamage, getX(), getY());
                    hitTimeDynamic = 0;
                }
                ySpeed = -(jumpForce - 3);  //knockback
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
            }
            else
            {
                shieldAmmount -= acidDamage;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + acidDamage);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(Acid1.class) == null)
            Acid1.hitting = false;
    }
    
    private void spikesCollision()
    {
        //jika hero terkena spike
        if(isDead == false && getOneIntersectingObject(Spikes.class) != null && Spikes.hitting == false)
        {
            Spikes.hitting = true;
            if(onShield == false)
            {
                if(hitTimeDynamic > hitTime)
                {
                    healthPoints -= spikeDamage;
                    ySpeed = -(jumpForce);  //knockback
                    //text damage
                    EnemyTextDamage textDamage = new EnemyTextDamage("" + spikeDamage);
                    getWorld().addObject(textDamage, getX(), getY());
                    hitTimeDynamic = 0;
                }
                ySpeed = -(jumpForce);  //knockback
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
            }
            else
            {
                shieldAmmount -= spikeDamage;
                ySpeed = -(jumpForce + 3);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + spikeDamage);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(Spikes.class) == null)
            Spikes.hitting = false;
    }
    
    private void sawBladeCollision()
    {
        //jika hero terkena spike
        if(isDead == false && getOneIntersectingObject(SawBlade.class) != null && SawBlade.hitting == false)
        {
            SawBlade.hitting = true;
            if(onShield == false)
            {
                if(hitTimeDynamic > hitTime)
                {
                    healthPoints -= sawBladeDamage;
                    ySpeed = -(jumpForce);  //knockback
                    //text damage
                    EnemyTextDamage textDamage = new EnemyTextDamage("" + sawBladeDamage);
                    getWorld().addObject(textDamage, getX(), getY());
                    hitTimeDynamic = 0;
                }
                ySpeed = -jumpForce;
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
            }
            else
            {
                shieldAmmount -= sawBladeDamage;
                ySpeed = -(jumpForce + 3);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + sawBladeDamage);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(SawBlade.class) == null)
            SawBlade.hitting = false;
    }
    
    private void slimeCollision()
    {
        //jika hero terkena enemy
        if(isDead == false && getOneIntersectingObject(Slime.class) != null && Slime.hitting == false)
        {
            Slime.hitting = true;
            if(onShield == false)
            {
                healthPoints -= Slime.slimeAttack;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + Slime.slimeAttack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
            }
            else
            {
                shieldAmmount -= Slime.slimeAttack;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + Slime.slimeAttack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(Slime.class) == null)
            Slime.hitting = false;
    }
    
    private void robotCollision()
    {
        //jika hero terkena enemy
        if(isDead == false && getOneIntersectingObject(Robot.class) != null && Robot.hitting == false)
        {
            Robot.hitting = true;
            if(onShield == false)
            {
                healthPoints -= Robot.robotAttack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + Robot.robotAttack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
            }
            else
            {
                shieldAmmount -= Robot.robotAttack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + Robot.robotAttack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(Robot.class) == null)
            Robot.hitting = false;
    }
    
    private void ufoCollision()
    {
        //jika hero terkena enemy
        if(isDead == false && getOneIntersectingObject(Ufo.class) != null && Ufo.hitting == false)
        {
            Ufo.hitting = true;
            if(onShield == false)
            {
                healthPoints -= Ufo.attack;
                ySpeed = -(jumpForce + 3);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + Ufo.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
            }
            else
            {
                shieldAmmount -= Ufo.attack;
                ySpeed = -(jumpForce + 3);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + Ufo.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(Ufo.class) == null)
            Ufo.hitting = false;
    }
    
    private void shooter1Collision()
    {
        //jika hero terkena enemy
        if(isDead == false && getOneIntersectingObject(Shooter1.class) != null && Shooter1.hitting == false)
        {
            Shooter1.hitting = true;
            if(onShield == false)
            {
                healthPoints -= Shooter1.shooter1Attack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + Shooter1.shooter1Attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                confuse = true;
            }
            else
            {
                shieldAmmount -= Shooter1.shooter1Attack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + Shooter1.shooter1Attack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(Shooter1.class) == null)
            Shooter1.hitting = false;
        //jika hero terkena projectile
        Actor projectile = getOneIntersectingObject(Shooter1Projectile.class);
        if(projectile != null)
        {
            if(onShield == false)
            {
                //mengurangi hp
                healthPoints -= Shooter1.shooter1Attack;
                ySpeed = -(jumpForce - 15);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + Shooter1.shooter1Attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                //menghapus projectile
                getWorld().removeObject(projectile);
                confuse = true;
            }
            else
            {
                shieldAmmount -= Shooter1.shooter1Attack;
                ySpeed = -(jumpForce - 15);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + Shooter1.shooter1Attack);
                getWorld().addObject(shieldDamage, getX(), getY());
                //menghapus projectile
                getWorld().removeObject(projectile);
            }
        }
    }
    
    private void flameAlienCollision()
    {
        //jika hero terkena enemy
        if(isDead == false && getOneIntersectingObject(FlameAlien.class) != null && FlameAlien.hitting == false)
        {
            FlameAlien.hitting = true;
            if(onShield == false)
            {
                healthPoints -= FlameAlien.attack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + FlameAlien.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                burn = true;
            }
            else
            {
                shieldAmmount -= FlameAlien.attack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + FlameAlien.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(FlameAlien.class) == null)
            FlameAlien.hitting = false;
    }
    
    private void toxicAlienCollision()
    {
        //jika hero terkena enemy
        if(isDead == false && getOneIntersectingObject(ToxicAlien.class) != null && ToxicAlien.hitting == false)
        {
            ToxicAlien.hitting = true;
            if(onShield == false)
            {
                healthPoints -= ToxicAlien.attack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + ToxicAlien.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                poison = true;
            }
            else
            {
                shieldAmmount -= ToxicAlien.attack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + ToxicAlien.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(ToxicAlien.class) == null)
            ToxicAlien.hitting = false;
    }
    
    private void ufoShooterCollision()
    {
        //jika hero terkena enemy
        if(isDead == false && getOneIntersectingObject(UfoShooter.class) != null && UfoShooter.hitting == false)
        {
            UfoShooter.hitting = true;
            if(onShield == false)
            {
                healthPoints -= UfoShooter.attack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + UfoShooter.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
            }
            else
            {
                shieldAmmount -= UfoShooter.attack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + UfoShooter.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
        }
        if(isDead == false && getOneIntersectingObject(UfoShooter.class) == null)
            UfoShooter.hitting = false;
        //jika hero terkena projectile
        Actor projectile = getOneIntersectingObject(UfoShooterProjectile.class);
        if(projectile != null)
        {
            if(onShield == false)
            {
                //mengurangi hp
                healthPoints -= UfoShooter.attack;
                ySpeed = -(jumpForce - 15);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + UfoShooter.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                //menghapus projectile
                getWorld().removeObject(projectile);
            }
            else
            {
                shieldAmmount -= UfoShooter.attack;
                ySpeed = -(jumpForce - 15);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + UfoShooter.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
                //menghapus projectile
                getWorld().removeObject(projectile);
            }
        }
    }
    
    private void flyingRobotCollision()
    {
        Actor b = getOneIntersectingObject(FlyingRobot.class);
        if(isDead == false && b != null)
        {
            //explode
            getWorld().addObject(new FlyingRobotExplode(), b.getX(), b.getY());
            getWorld().removeObject(b);
            if(onShield == false)
            {
                healthPoints -= FlyingRobot.attack;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + FlyingRobot.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                burn = true;
            }
            else
            {
                shieldAmmount -= FlyingRobot.attack;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + FlyingRobot.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy1.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
    }
    
    private void flyingSmallRobotCollision()
    {
        Actor b = getOneIntersectingObject(FlyingSmallRobot.class);
        if(isDead == false && b != null)
        {
            //explode
            getWorld().addObject(new FlyingSmallRobotExplode(), b.getX(), b.getY());
            getWorld().removeObject(b);
            if(onShield == false)
            {
                healthPoints -= FlyingSmallRobot.attack;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + FlyingSmallRobot.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                burn = true;
            }
            else
            {
                shieldAmmount -= FlyingSmallRobot.attack;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + FlyingSmallRobot.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy1.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
    }
    
    private void smallRobotCollision()
    {
        Actor b = getOneIntersectingObject(SmallRobot.class);
        if(isDead == false && b != null)
        {
            //explode
            getWorld().addObject(new SmallRobotExplode(), b.getX(), b.getY());
            getWorld().removeObject(b);
            if(onShield == false)
            {
                healthPoints -= SmallRobot.attack;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + SmallRobot.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                poison = true;
            }
            else
            {
                shieldAmmount -= SmallRobot.attack;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + SmallRobot.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy1.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
    }
    
    private void unknownAlienCollision()
    {
        Actor b = getOneIntersectingObject(UnknownAlien.class);
        if(isDead == false && b != null)
        {
            //explode
            getWorld().addObject(new UnknownAlienExplode(), b.getX(), b.getY());
            getWorld().removeObject(b);
            if(onShield == false)
            {
                healthPoints -= UnknownAlien.attack;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + UnknownAlien.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                confuse = true;
            }
            else
            {
                shieldAmmount -= UnknownAlien.attack;
                ySpeed = -(jumpForce - 5);  //knockback
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + UnknownAlien.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
            }
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy2.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
    }
    
    private void bossCollision()
    {
        //jika hero terkena enemy
        if(isDead == false && getOneIntersectingObject(Boss.class) != null && Boss.hitting == false)
        {
            Boss.hitTime = 0;
            Boss.hitting = true;
            if(onShield == false)
            {
                healthPoints -= 5*Boss.attack;
                ySpeed = -(jumpForce);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + 5*Boss.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                randomDebuff();
            }
            else
            {
                shieldAmmount -= 5*Boss.attack;
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + 5*Boss.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
                if(Boss.rage)
                {
                    healthPoints -= 5*Boss.attack;
                    ySpeed = -(jumpForce);  //knockback
                    //text damage
                    EnemyTextDamage textDamage = new EnemyTextDamage("" + 5*Boss.attack);
                    getWorld().addObject(textDamage, getX(), getY());
                    //play sound effect
                    GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                    heroGetHit.play();
                    randomDebuff();
                }
            }
        }
        if(isDead == false && getOneIntersectingObject(Boss.class) == null)
            Boss.hitting = false;
            
        //jika hero terkena projectile
        Actor projectile = getOneIntersectingObject(BossProjectile.class);
        if(projectile != null)
        {
            Boss.hitting = true;
            getWorld().addObject(new BossProjectileExplode(), projectile.getX(), projectile.getY());
            if(onShield == false)
            {
                //mengurangi hp
                healthPoints -= Boss.attack;
                ySpeed = -(jumpForce - 15);  //knockback
                //text damage
                EnemyTextDamage textDamage = new EnemyTextDamage("" + Boss.attack);
                getWorld().addObject(textDamage, getX(), getY());
                //play sound effect
                GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                heroGetHit.play();
                //menghapus projectile
                getWorld().removeObject(projectile);
                randomDebuff();
            }
            else
            {
                shieldAmmount -= Boss.attack;
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("" + Boss.attack);
                getWorld().addObject(shieldDamage, getX(), getY());
                if(Boss.rage)
                {
                    healthPoints -= Boss.attack;
                    ySpeed = -(jumpForce);  //knockback
                    //text damage
                    EnemyTextDamage textDamage = new EnemyTextDamage("" + Boss.attack);
                    getWorld().addObject(textDamage, getX(), getY());
                    //play sound effect
                    GreenfootSound heroGetHit = new GreenfootSound("heroGetHit.wav");
                    heroGetHit.play();
                    randomDebuff();
                }
                //menghapus projectile
                getWorld().removeObject(projectile);
            }
        }
    }
    
    private void randomDebuff()
    {
        int random = Greenfoot.getRandomNumber(3);
        if(random == 0)
            burn = true;
        else if(random == 1)
            confuse = true;
        else if(random == 2)
            poison = true;
    }
    
    private void heroDead()
    {
        if(healthPoints <= 0)
        {
            healthPoints = 0;
            isDead = true;
            getImage().setTransparency(0);
            if(Item.crystal == 0)
            {
                getWorld().addObject(new HeroDead(), getX(), getY());
                //play sound effect
                BackGroundMusic.deadHero.setVolume(60);
                BackGroundMusic.deadHero.play();
                Stage1.objectSpeed = 0;
                Stage1.leftScreenPosition = 0;
                Stage1.rightScreenPosition = 1024;
            }
            else
            {
                Item.crystal = 0;
                onRage = false;
                addSaberBuff = false;
                addLaserBuff = false;
                addRageEffect = false;
                getWorld().addObject(new CrystalEffect1(), getX(), getY());
            }
        }
    }
    
    public void displayBattery()
    {
        if(displayBatteryIcon == false)
        {
            BatteryLabel batteryLabel = new BatteryLabel((batteryInt * 100 / maxBattery) +"%");
            getWorld().addObject(batteryLabel, 440, 5+batteryLabel.getImage().getHeight()/2);
            getWorld().addObject(new BatteryIcon(batteryLabel), 330, 28);
            displayBatteryIcon = true;
        }
    }
}