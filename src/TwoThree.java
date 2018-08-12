class TwoThree {
    public static void main(String[] args) {

//        run_instructions(args);


/*
        // test 2 levels of all 3 nodes
        tree treeobj2 = new t23Tree();
        testClass.allThreeNode2Leves(treeobj2);
        testClass.orderTraversal(treeobj2.getRoot());
        System.out.println();
        treeobj2.add(302, treeobj2.getRoot(), treeobj2);
        testClass.orderTraversal(treeobj2.getRoot());

*/
        // test 3 levels of all 3 nodes
        tree treeobj = new t23Tree();
        testClass.allThreeNode3Leves(treeobj);
        testClass.orderTraversal(treeobj.getRoot());
        System.out.println();

        treeobj.add(999, treeobj.getRoot(), treeobj);
//        treeobj.add(126, treeobj.getRoot(), treeobj);
        testClass.orderTraversal(treeobj.getRoot());

//        testClass.graphicalTraversal(treeobj.getRoot());
// testing with manual tree made by me -- from the assignment provided example
//        tree treeObj;
//        treeObj = testTreeStep6();
//        treeObj = testTreeStep7();
//        treeObj.preOrderTraverse(treeObj.getRoot());
//        System.out.println();

// testing add function
//        tree testAddtree = new t23Tree();
//        int findVal = 901;
//        buildAsstree(testAddtree);
//        t23output(testAddtree, 6);
        int unnecessary = 9999;

    }

    private static void run_instructions(String[] args) {
        String fileName;
        int traversalStep;
        if (args.length != 0) {
            fileName = args[0];
            traversalStep = Integer.parseInt(args[1]);
            // System.out.println(fileName + " " + traversalStep);
            operationsQueue operationsQueueObj = inputManager.instructionExtractor(fileName);

            // Processing all the inputs from the test file into a Queue for easier handling of the instructions
            // initializing instructions object to hold the instruction values
            instructions instruction = null;
            // initializing 2-3 Tree object
            tree treeObj = new t23Tree();
            // iterating through all the Instructions found in the text file
            while (!operationsQueueObj.isEmpty()) {
                instruction = operationsQueueObj.denqueue();
                // skip the char 'n' is found as the operator. n indicates null.
                if (instruction.getOperator() != 'n') {
                    if (instruction.getOperator() == 'a' || instruction.getOperator() == 'A') {
                        treeObj.add(instruction.getKey(), treeObj.getRoot(), treeObj);
                        treeObj.instructionCounterIncrement();
                    } else if (instruction.getOperator() == 'f' || instruction.getOperator() == 'F') {
                        treeObj.find(instruction.getKey(), treeObj.getRoot());
                        treeObj.findInstructionCounterIncrement();
                        treeObj.instructionCounterIncrement();
                    } else if (instruction.getOperator() == 'r' || instruction.getOperator() == 'R') {
                        treeObj.remove(instruction.getKey());
                        treeObj.instructionCounterIncrement();
                    } else {
                        System.out.print(instruction.getOperator() + ": Is not a recognized instruction operator. Please choose between a, f or r");
                    }
                    // Check the instructions for the tree
//                    System.out.println(instruction.getOperator() + " " + instruction.getKey());
                }

                printt23PreorderTraversal(treeObj, traversalStep);
            }
            t23output(treeObj, traversalStep);
        }
    }

    private static void printt23PreorderTraversal(tree treeobj, int stepNumber) {
        if (stepNumber == treeobj.getInstructionsCounter()) {
            System.out.print("Pre-order traversal after step " + stepNumber + ": ");
            treeobj.preOrderTraverse(treeobj.getRoot());
            System.out.print(" ");
        }
    }

    private static void t23output(tree treeObj, int stepNumber) {
        System.out.print(
                treeObj.getComparisons() + " Comparisons Made " +
                        treeObj.getThreeNodeCounter() + " Three Nodes Created " +
                        treeObj.getAddInstructionCounter() + " add operations " +
                        treeObj.getFindInstructionCounter() + " find operations " +
                        treeObj.getRemoveInstructionCounter() + " remove operations "
        );
//        treeObj.preOrderTraverse(treeObj.getRoot());
    }
}
