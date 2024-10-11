
import java.util.Vector;

public class TotalCube{
    private Vector<Cube> cubeList;//list of all the cubes
    private final int size;//number of cubes per side
    private final int length;//length of the input char

    public TotalCube(int size){//contructor
        cubeList = new Vector<Cube>();
        this.size=size;
        length=size*size*size;
    }

    //finding the solution by iteratively positioning the cubes
    public boolean solve(String input){
        boolean test;//test variable 
        for (int index=0;index<length;++index){
                char current = input.charAt(index);

                switch(current){
                    case 'A'://angle cube
                        CubeA cubeA=new CubeA(this,cubeList.get(index-1));//construct the cube
                        test=cubeA.findSolution();//find the corresponding solution
                        if(!test){
                            System.out.println("No solution found, the problem comes since cube "+ index);
                            return false;
                        }
                        else{
                            cubeList.add(cubeA);//add the cube to the list
                        }
                        break;
                    case 'E':
                        if(index==0){
                            CubeE cubeE=new CubeE(this);//initialization of the start cube
                            test=cubeE.findSolution();
                            if(!test){
                                System.out.println("No solution: Issue detected for the first cube"+ index);
                                return false;
                            }
                            else{
                                cubeList.add(cubeE);//add to the cube
                            }
                        }
                        else if (index==length-1){
                            CubeS cubeS=new CubeS(this,cubeList.get(index-1));//same behaviour than cube S for the last one-> no rotation possible
                            test=cubeS.findSolution();
                            if (test){
                                cubeList.add(cubeS);
                                return true;
                            }
                            else{
                                System.out.println("No solution: Issue detected for the last cube ");
                                return false;
                            }
                        }

                        break;
                    case 'S':
                        CubeS cubeS=new CubeS(this,cubeList.get(index-1));//create cube S
                        test=cubeS.findSolution();
                        if(!test){
                            System.out.println("No solution: Issue detected at cube "+ index);
                            return false;
                        }
                        else{
                            cubeList.add(cubeS);
                        }
                        break;
                }
        }

        return false;        
    }

    //check if the cube is in the grid limit
    public boolean checkBounds(int x, int y, int z){
        return x<=size && x>=1 && y<=size && y>=1 && z<=size && z>=1;
    }
    //display the cube
    public void displaySolution(){
        Cube currentCube;
        for(int index=0; index<cubeList.size();index++){
            currentCube=cubeList.get(index);
            System.out.println(currentCube.getCoordinates());
        }
        return;
    }
}
