import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class MorseTester {
    
    public static void main(String[] args) {
        
        MorseTree<String> Morse = new MorseTree<>();
        Morse.root = new TreeNode<String>("");

        // fill tree
        try {
            File Morsetxt = new File("/Users/rogerspastio/Documents/UMaine/COS225/Homework6/morsecode.txt");
            Scanner myReader = new Scanner(Morsetxt);
            while (myReader.hasNextLine()) {
                String[] line = myReader.nextLine().split(" ",0);
                TreeNode<String> letter = new TreeNode<String>(line[0]);
                TreeNode<String> element = Morse.root;
                for (int i=1; i<line.length;i++){
                    if (i == line.length-1){
                        if (line[i].equals("o")){
                            element.setLeft(letter);
                        }
                        else{
                            element.setRight(letter);
                        }
                    }
                    else if (line[i].equals("o")){
                        element = element.getLeft();
                    }
                    else if (line[i].equals("-")){
                        element = element.getRight();
                    }
                    else{ // for testing purposes
                        System.out.println("Got a bug in the tree builder! Send Help!");
                    }
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(Morse.preorder());
        System.out.println(Morse.postorder());

        String str = "Its dangerous to go alone take this"; //"The quick fox";

        System.out.println(Morse.encode(str));
        System.out.println(Morse.decode(Morse.encode(str)));
    }
}
