import greenfoot.*;

public class DoorSwitch extends Objects
{
    public static boolean redSwitch = true;
    
    public void act()
    {
        moveObjects();
        switched();
    }
    
    private void switched()
    {
        if(getOneIntersectingObject(HeroMechanics.class) != null && Greenfoot.isKeyDown("e") && redSwitch == true)
        {
            //sound
            BackGroundMusic.doorSwitch.setVolume(80);
            BackGroundMusic.doorSwitch.play();
            redSwitch = false;
            setImage("switchGreen.png");
        }
    }
}