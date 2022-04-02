import greenfoot.*;

public class Boss extends Enemy
{
    //untuk animasi
    private GreenfootImage[] images = new GreenfootImage[26];
    private int pause = 11;
    private int num = 1;
    //untuk pergerakan
    int dx = 1;
    int xSpeed = 2; //kecepatan bergerak horizontal
    //untuk atribut
    public static boolean hitting = false;
    public static int hitTime = 0;
    public static int hp;
    public static int maxHp;
    public static int attack = 180;
    //skill passive
    public static boolean defiance = false;
    public static boolean rage = false;
    public static boolean shield;
    public static int shieldActivated;
    private int shieldDuration;
    public static boolean regen;
    public static int regenActivated;
    private int regenDuration;
    private int healPoint;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("boss ("+i+").png");
        }
    }
    
    public void act()
    {
        Defiance();
        Rage();
        Shield();
        shieldDuration--;
        Regen();
        regenDuration--;
        moveVertically();
        moveBecauseScrollingBg();
        animation();
        hitTime++;
        if(hitTime > 50)
        {
            hitting = false;
            hitTime = 0;
        }
        getHit();
    }
    
    public void animation()
    {
        if(pause==0){
            pause=11;
        }
        if(pause%4 == 0){
            moveHorizontal();
        }
        if(pause==1){
            setImage(images[num]);
            num++;
            if(num == 13)
            {
                if(rage)
                {
                    BossProjectile shot = new BossProjectile();
                    getWorld().addObject(shot, getX(), getY());
                    shot.turnTowards(HeroMechanics.xPosition, HeroMechanics.yPosition);
                    //play sound effect
                    GreenfootSound shotLaser = new GreenfootSound("shotLaser.mp3");
                    shotLaser.setVolume(65);
                    shotLaser.play();
                }
            }
            if(num >= images.length){
                BossProjectile shot = new BossProjectile();
                getWorld().addObject(shot, getX(), getY());
                shot.turnTowards(HeroMechanics.xPosition, HeroMechanics.yPosition);
                //play sound effect
                GreenfootSound shotLaser = new GreenfootSound("shotLaser.mp3");
                shotLaser.setVolume(65);
                shotLaser.play();
                num=1;
            }
        }
        if(pause>0){
            pause--;
        }
    }
    
    public void moveHorizontal()
    {
        setLocation(getX()+dx*xSpeed, getY());
        while(getOneIntersectingObject(Tiles.class) != null)
        {
            setLocation(getX()-dx, getY());
        }
    }
    
    private void getHit()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class); 
        if(projectile != null)
        {
            if(shield)
            {
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("immune");
                getWorld().addObject(shieldDamage, getX()+300, getY());
                //menghapus projectile
                getWorld().removeObject(projectile);
            }
            else
            {
                int damage;
                if(defiance)
                    damage = HeroMechanics.laserDamage * 90 / 100;
                else
                    damage = HeroMechanics.laserDamage;
                //mengurangi hp
                hp -= damage;
                //text damage
                ProjectileTextDamage textDamage = new ProjectileTextDamage("" + damage);
                getWorld().addObject(textDamage, getX()+300, getY());
                //menghapus projectile
                getWorld().removeObject(projectile);
                //backsound
                GreenfootSound hitEnemy = new GreenfootSound("hitEnemy2.wav");
                hitEnemy.setVolume(90);
                hitEnemy.play();
            }
        }
        if(getOneIntersectingObject(SaberSlash.class) != null && SaberSlash.hitEnemy == false)
        {
            SaberSlash.hitEnemy = true;
            if(shield)
            {
                //text damage
                ShieldDamage shieldDamage = new ShieldDamage("immune");
                getWorld().addObject(shieldDamage, getX()+300, getY());
            }
            else
            {
                int damage;
                if(defiance)
                    damage = HeroMechanics.saberDamage * 90 / 100;
                else
                    damage = HeroMechanics.saberDamage;
                //mengurangi hp
                hp -= damage;
                //text damage
                SaberTextDamage textDamage = new SaberTextDamage("" + damage);
                getWorld().addObject(textDamage, getX()+300, getY());
                //backsound
                GreenfootSound hitEnemy = new GreenfootSound("hitEnemy2.wav");
                hitEnemy.setVolume(90);
                hitEnemy.play();
            }
        }
        if(hp <= 0)
        {
            hp = 0;
            BossStatusIcon.status = "-";
            //score
            ScoreIcon.myScore += 500;
            //dead
            getWorld().addObject(new BossDead(), getX()+300, getY()-70);
            //remove
            getWorld().removeObject(this);
        }
    }
    
    private void Defiance()
    {
        if((hp*100/maxHp) <= 50)
        {
            defiance = true;
            attack = 270;
        }
        else
        {
            defiance = false;
            attack = 180;
        }
    }
    
    private void Rage()
    {
        if((hp*100/maxHp) <= 30)
        {
            rage = true;
        }
        else
            rage = false;
    }
    
    private void Shield()
    {
        if((hp*100/maxHp) <= 20 && shieldActivated == 0)
        {
            shieldDuration = 1650;
            shieldActivated = 1;
            shield = true;
        }
        if(shieldDuration <= 0)
        {
            shield = false;
        }
    }
    
    private void Regen()
    {
        if((hp*100/maxHp) <= 15 && regenActivated == 0)
        {
            regenDuration = 660;
            regenActivated = 1;
            regen = true;
        }
        if(regen == true && regenDuration%55 == 0)
        {
            healPoint = (maxHp-hp)*5/100;
            hp += healPoint;
        }
        if(regenDuration <= 0)
        {
            regen = false;
        }
    }
}