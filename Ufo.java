import greenfoot.*;

public class Ufo extends Enemy
{
    private boolean faceRight = false;
    private boolean faceLeft = true;
    //untuk pergerakan
    int dx = -1;
    int xSpeed = 3; //kecepatan bergerak horizontal
    //untuk atribut
    public static boolean hitting = false;
    private int hp = 70;
    public static int attack = 130;
    
    public void act()
    {
        moveHorizontal();
        moveBecauseScrollingBg();
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
            getWorld().addObject(new Coin(), this.getX()+20,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()+10,this.getY()-20);
            getWorld().addObject(new Coin(), this.getX(),this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-10,this.getY()-20);
            getWorld().addObject(new Coin(), this.getX()-20,this.getY()-10);
            //score
            ScoreIcon.myScore += 20;
            //remove
            getWorld().removeObject(this);
        }
    }
}