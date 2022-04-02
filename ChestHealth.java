import greenfoot.*;

public class ChestHealth extends Objects
{
    static final int gravity = 2;   //kecepatan gravitasi
    int ySpeed = 0; //kecepatan jatuh
    public static boolean chestHealthOpened = false;
    private int healPoint = 80;
    
    public void act()
    {
        moveObjects();
        gravity();
        open();
    }
    
    private void open()
    {
        if(getOneIntersectingObject(HeroMechanics.class) != null && Greenfoot.isKeyDown("e") && chestHealthOpened == false)
        {
            //sound effect
            GreenfootSound buttonClick = new GreenfootSound("buttonClick.mp3");
            buttonClick.setVolume(60);
            buttonClick.play();
            //menambahkan hp
            if(HeroMechanics.healthPoints + healPoint > HeroMechanics.maxHealthPoints)
            {
                healPoint = HeroMechanics.maxHealthPoints-HeroMechanics.healthPoints;
            }
            HeroMechanics.healthPoints += healPoint;
            //text heal
            HealEffect textHeal = new HealEffect("" + healPoint);
            getWorld().addObject(textHeal, HeroMechanics.xPosition, HeroMechanics.yPosition);
            //mengganti gambar
            setLocation(getX(), getY()-5);
            setImage("chestHealthOpen.png");
            chestHealthOpened = true;
            healPoint = 50;
        }
    }
    
    public void gravity()
    {
        ySpeed += gravity;  //Meningkatkan kecepatan jatuh
        //Membuat enemy berpindah sesuai kecepatan
        setLocation(getX(), getY()+ySpeed);
        int dy = (int)Math.signum(ySpeed);
        while(getOneIntersectingObject(Tiles.class) != null)
        {
            setLocation(getX(), getY()-dy);
            ySpeed = 0;
        }
    }
}