public class CubeE extends Cube{

    //call the super constructor
    public CubeE(TotalCube bigCube){
        super(1,1,1, null,1,bigCube);
    }

    public boolean findSolution(){
        return true;
    }
    public boolean moveOn(){
        return false;
    }
}
