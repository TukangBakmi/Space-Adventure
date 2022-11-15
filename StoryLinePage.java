import greenfoot.*;

public class StoryLinePage extends World
{
    public StoryLinePage()
    {    
        super(1024, 576, 1); 
        prepare();
    }
    
    private void prepare()
    {
        addObject(new StoryLine(), 512,288);
        addObject(new Skip(),940, 540);
    }
}