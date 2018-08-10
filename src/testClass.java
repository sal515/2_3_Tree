
public class testClass {


    public static void classCheck(Object obj, String Obj2) {
//        if (obj instanceof Obj2){
//            System.out.println("true");
//        } else{
//            System.out.println("testClass.classCheck");
//        }
    }


    public static void treeOperations(String fileName) {
    }

    public static void printFile(String[] in) {
        for (String anIn : in) {
            System.out.print(anIn);
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








