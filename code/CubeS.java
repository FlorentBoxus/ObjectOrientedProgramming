public class CubeS extends Cube{
    private final int possibleMove=1;
    private int moveDone;

    //call the super constructor
    public CubeS(TotalCube bigCube,Cube previousCube){
        super(previousCube.getX(),previousCube.getY(),previousCube.getZ(),previousCube, previousCube.getDirection(),bigCube);
        moveDone=0;
    }
    
    public boolean findSolution(){
        while(previousCube.conflict(x,y,z) || !(bigCube.checkBounds(x,y,z))){
            if(!moveOn())
                return false;
        }
        return true;
    }

    //ensures we followed the last coordinates when the previous cube moved
    public boolean moveOn(){
        if(moveDone<possibleMove){
            direction=previousCube.getDirection();
            x=previousCube.getX();
            y=previousCube.getY();
            z=previousCube.getZ();
            moveto();
            ++moveDone;
            return true;
        }
        moveDone=0;//reset
        return previousCube.nextSolution();
    }
}
