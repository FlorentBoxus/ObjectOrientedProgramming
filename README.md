# Object Oriented Programming
## The snakeCube Puzzle

The project consists in writing a Java program that is able to solve the snake cube puzzle, by starting
from a given initial configuration, and searching for a valid combination of rotations.
A character string encoding the initial configuration will be provided as an argument to the program, in
which each successive cube of the chain is described by a letter corresponding to its geometry:
- E (for Endpoint) if the cube is the first or the last one, i.e., it has only one neighbor (or zero if n = 1).
- S (for Straight) if the cube has two neighbors on opposite sides.
- A (for Angle) if the cube has two neighbors that share a common edge.

If a solution is found, the program must display it by outputting sequentially and on separate lines of
text the position of all the cubes in the chain.

## Comment utiliser ce projet
1. **Téléchargez le dépôt** : Clonez ce dépôt ou téléchargez-le sous forme de fichier ZIP.
   ```bash
   git clone https://github.com/FlorentBoxus/ObjectOrientedProgramming
