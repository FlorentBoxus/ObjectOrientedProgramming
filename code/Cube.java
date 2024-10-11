public abstract class Cube{
    protected int x,y,z;
    protected Cube previousCube;
    protected int direction;//1 for added + on x, 2 for added - on x, 3 for added + on y, 4 for added - on y, 5 for added + on z, 6 for added - on z
    protected final TotalCube bigCube;

    public Cube(int x, int y, int z,Cube previousCube, int direction,TotalCube bigCube){
        this.x=x;
        this.y=y;
        this.z=z;
        this.previousCube=previousCube;
        this.direction=direction;
        this.bigCube=bigCube;
    }

    public String getCoordinates(){//will be usefull to display the final code
        return "(" + x + "," + y +"," + z +")";
    }
    public int getX(){//get methods
        return x;
    }
    public int getY(){
        return y;
    }
    public int getZ(){
        return z;
    }
    public int getDirection(){
        return direction;
    }
    public Cube getPreviousCube(){
        return previousCube;
    }

    //check if the given coordinates are the same than those of the cube
    public boolean conflict(int x, int y, int z){
        if(this.x==x && this.y==y && this.z==z){ 
            return true;
        }
        //if there is no neighbor-->end recursion
        if(this.previousCube==null)
            return false;
        return previousCube.conflict(x,y,z);
    }

    //move to the next position using the previous direction
    public boolean moveto(){
        int moveDirection=previousCube.getDirection();
        switch (moveDirection){
            case 1:
                x++;
                break;
            case 2:
                x--;
                break;
            case 3:
                y++;
                break;
            case 4:
                y--;
                break;
            case 5:
                z++;
                break;
            case 6:
                z--;
                break;
            default:
                System.out.println("No direction found");
                System.exit(-1);
        }
        return true;
    }
    public abstract boolean findSolution();
    public abstract boolean moveOn();

    
    public boolean nextSolution(){
        return moveOn() && findSolution();
    }
}
