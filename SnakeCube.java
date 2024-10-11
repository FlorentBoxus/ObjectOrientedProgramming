public class SnakeCube {
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                String input = args[args.length - 1];//get the encoded input string
                int length = input.length();
                double root = Math.cbrt(length);//takes the cubic root to ensure the number of cubes per side

                //testing the encoding errors
                if ((root % 1) != 0) {
                    throw new TotalCubeException("Invalid input data: the input does not have an entire cubic root.");
                }
                int countE = 0;
                boolean unknownLetter =false;
                for (int i = 0; i < input.length(); i++) {//we check the input format is valid
                    if (input.charAt(i) == 'E') {
                        countE++;
                    }
                    if (input.charAt(i) !='E' && input.charAt(i) !='A' && input.charAt(i) !='S'){
                        unknownLetter=true;
                    }
                }
                if (countE != 2) {
                    throw new TotalCubeException("Invalid input data : the number of 'E' is different than 2.");
                }
                if (input.charAt(0) != 'E' || input.charAt(input.length() - 1) != 'E') {
                    throw new TotalCubeException("Invalid input data : the input does not begin or end by 'E'.");
                }
                if(unknownLetter){
                    throw new TotalCubeException("Invalid input data : the input contains a letter which is not 'E', 'A' or 'S'.");
                }

                //solve the problem
                int size = (int) root;
                TotalCube bigCube = new TotalCube(size);
                boolean test = bigCube.solve(input);
                if (test) {
                    System.out.println("Solution found");
                    bigCube.displaySolution();
                }
            } else {
                throw new TotalCubeException("Invalid input data: No input encoded.");
            }
        } catch (TotalCubeException e) {
            System.out.println(e.getMessage());
        }
    }
}
