import greenfoot.*;

public class TutorialPage extends World
{
    public TutorialPage()
    {    
        super(1024, 576, 1); 
        prepare();
    }
    
    private void prepare()
    {
        addObject(new Tutorial(), 512,288);
        addObject(new SkipTutorial(),940, 540);
    }
}