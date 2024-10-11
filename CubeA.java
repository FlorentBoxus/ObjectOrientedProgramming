import java.util.ArrayList;
import java.util.List;

public class CubeA extends Cube{
    private final int possibleMove=4;//4 possible rotations
    private int moveDone;//move already done since the last neighbor has moved
    List<Integer> movelist;//list of possible rotations

    
    public CubeA(TotalCube bigCube, Cube previousCube){
        super(previousCube.getX(),previousCube.getY(),previousCube.getZ(),previousCube, 0,bigCube);
        movelist=new ArrayList<>();
        moveDone=0;
    }

    public boolean findSolution(){
        while(previousCube.conflict(x,y,z) || !(bigCube.checkBounds(x,y,z))){
            if(!moveOn())
                return false;
        }
        return true;
    }
    public boolean moveOn(){
        //compute the possible directions
        if(moveDone==0){
            int lastDirection=previousCube.getDirection();
            if((lastDirection%2)==0){
                movelist.add((lastDirection)%6+1);
                movelist.add((lastDirection+1)%6+1);
                movelist.add((lastDirection+2)%6+1);
                movelist.add((lastDirection+3)%6+1);
            }
            else{
                movelist.add((lastDirection+1)%6+1);//add an offset of 1
                movelist.add((lastDirection+2)%6+1);
                movelist.add((lastDirection+3)%6+1);
                movelist.add((lastDirection+4)%6+1);
            }
        }
        //ensures we followed the last coordinates when the previous cube moved
        if(moveDone<possibleMove){
            x=previousCube.getX();
            y=previousCube.getY();
            z=previousCube.getZ();
            direction=movelist.get(moveDone);
            moveDone++;
            moveto();
            return true;
        }
        moveDone=0;//reset because we will rotate the previous cube
        movelist.clear();
        return previousCube.nextSolution();
    }

}