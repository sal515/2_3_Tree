
public class testClass {

    // function looks for the leaf - to insert the new key
    public void addHHelp(int key) {
        node rt = null;
        // looks for a leaf
        if (rt.isLeaf()) {
            if (!rt.is3node()) {
                // convert the 2-node to 3-node
                // insert the key in the new 3-node
                // key should go in the proper position
            }
            // it is a 3 node already
            else {
                split3NodeLeaf(key);
                if (rt.getParent() != null) {
                    //rt.getParent(). -
                    promote(rt);
                }
            }
            return;
        }
    }


    // function splits a 3-node leaf
    public void split3NodeLeaf(int key) {
        // find where the new key is supposed to go in the 3-node
        // splits the 3-node to 2x 2-nodes
        // makes the 3-node as the parent of the 2x 2-nodes
        // and sets the children keys appropriately but
        // leaves the MIDDLE KEY HANGING
        // returns the 3-node with 2x 2-node children
    }

    //
    public void split3NodeInternal(node rt) {

        // takes in a internal 3-node to be split
        // then splits the 3-node into 4x 2-node -
        // CAREFULLY NOT MISPLACING THE FOUR CHILDREN
        // returns the control to the recursive function


    }

    // this function tries to absorb the child 2-nodes of the
    // splitted 3-node by the split function above
    public void promote(node rt) {

        if (true) {  // !Split_3-node.getparent().is3node -->
            // parent of the 3-node is 2-node
            // function into the 2-node parent turning it into a
            // 3-node parent
        }
        // // Split_3-node.getparent().is3node --> the parent is a 3-node
        else {
            split3NodeInternal(rt);
            if (true) {
                // split_3-node.getParent().getParent() != null -->
                // parent of the parent of the 3-node is 3-node
                // rt.getParent().
                promote(rt);
                // recursive function -
                // with base case when it hits null or a 2-node
            }
        }


    }


}




























/*
class Animal {
    public void makeSound() {
        System.out.println("Grr...");
    }
}
class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meow");
    }
}
class Dog extends Cat {
    public void makeSound() {
        System.out.println("Woof");
    }
}


interface AnimalINT {
    void makeSound() ;
//        System.out.println("Grr...");
//    }
}
class CatINT implements AnimalINT {
    public void makeSound() {
        System.out.println("Meow");
    }
}
class DogINT extends CatINT {
    public void makeSound() {
        System.out.println("Woof");
    }
}



abstract class Animalabs {
    public abstract void makeSound() ;
//        System.out.println("Grr...");
//    }
}
class Catabs extends Animalabs {
    public void makeSound() {
        System.out.println("Meow");
    }
}
class Dogabs extends Catabs {
    public void makeSound() {
        System.out.println("Woof");
    }
}
*/


// function: char extractor -- test codes

  /*

    public static void charExtractor(String filename) {
//        FileReader inputStream = null;
//        FileWriter outputStream = null;
        try {
//            inputStream = new FileReader(filename);
            BufferedReader buffReader = new BufferedReader(readingFile(filename));

            System.out.println("number of lines: " + countLines(readingFile(filename)));

            int inputChar;
//            System.exit(99);
//            while ((inputChar = inputStream.read()) != -1) {
            while ((inputChar = buffReader.read()) != -1) {
//                if(inputChar != 13 && inputChar != 10){
                if (inputChar != 13) {
                    if (inputChar == 10) {
                        System.out.println();
                    } else {
//                        System.out.print((char) inputChar + " - " + inputChar + " ");
                        System.out.print((char) inputChar);
                        //                System.out.println((char)inputChar + " - " + inputChar);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    */

// function: instructionExtractor - Test codes
                /*
                if (inputChar != 13) {
                    if (inputChar == 10) {
                        System.out.println();
                    } else {
//                        System.out.print((char) inputChar + " - " + inputChar + " ");
                        System.out.print((char) inputChar);
                        //                System.out.println((char)inputChar + " - " + inputChar);
                    }
                }
                */








