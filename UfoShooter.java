import greenfoot.*;

public class UfoShooter extends Enemy
{
    private boolean faceRight = false;
    private boolean faceLeft = true;
    private int time = 0;
    //untuk pergerakan
    int dx = -1;
    int xSpeed = 2; //kecepatan bergerak horizontal
    //untuk atribut
    public static boolean hitting = false;
    private int hp = 300;
    public static int attack = 100;
    
    public void act()
    {
        moveHorizontal();
        moveBecauseScrollingBg();
        projectile();
        time++;
        getHit();
    }
    
    public void moveHorizontal()
    {
        if(getOneIntersectingObject(EdgeGround.class) != null)
        {
            dx *= -1;
            if(faceRight == true)
            {
                getImage().mirrorHorizontally();
                setLocation(getX()-6, getY());
                faceRight = false;
                faceLeft = true;
            }
            else
            {
                getImage().mirrorHorizontally();
                setLocation(getX()+6, getY());
                faceRight = true;
                faceLeft = false;
            }
        }
        setLocation(getX()+dx*xSpeed, getY());
    }
    
    private void projectile()
    {
        if(time > 40)
        {
            UfoShooterProjectile shot = new UfoShooterProjectile();
            getWorld().addObject(shot, getX(), getY());
            shot.turnTowards(HeroMechanics.xPosition, HeroMechanics.yPosition);
            //play sound effect
            GreenfootSound shotLaser = new GreenfootSound("shotLaser.mp3");
            shotLaser.setVolume(65);
            shotLaser.play();
            time = 0;
        }
    }
    
    private void getHit()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class); 
        if(projectile != null)
        {
            //mengurangi hp
            hp -= HeroMechanics.laserDamage;
            //text damage
            ProjectileTextDamage textDamage = new ProjectileTextDamage("" + HeroMechanics.laserDamage);
            getWorld().addObject(textDamage, getX(), getY());
            //menghapus projectile
            getWorld().removeObject(projectile);
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy1.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
        if(getOneIntersectingObject(SaberSlash.class) != null && SaberSlash.hitEnemy == false)
        {
            SaberSlash.hitEnemy = true;
            //mengurangi hp
            hp -= HeroMechanics.saberDamage;
            //text damage
            SaberTextDamage textDamage = new SaberTextDamage("" + HeroMechanics.saberDamage);
            getWorld().addObject(textDamage, getX(), getY());
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy1.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
        if(hp <= 0)
        {
            //koin
            getWorld().addObject(new Coin(), this.getX()+42,this.getY()-20);
            getWorld().addObject(new Coin(), this.getX()+30,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()+30,this.getY()-30);
            getWorld().addObject(new Coin(), this.getX()+18,this.getY()-20);
            getWorld().addObject(new Coin(), this.getX()+6,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-6,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-18,this.getY()-20);
            getWorld().addObject(new Coin(), this.getX()-30,this.getY()-30);
            getWorld().addObject(new Coin(), this.getX()-30,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-42,this.getY()-20);
            //score
            ScoreIcon.myScore += 50;
            //remove
            getWorld().removeObject(this);
        }
    }
}