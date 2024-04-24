public class MorseTree<T> {
    public TreeNode<T> root;

    public MorseTree(){
        this.root = null;
    }

    public String preorder(){
        if (root == null){return "";}
        return root.preorder();
    }

    public String postorder(){
        if (root == null){return "";}
        return root.postorder();
    }

    public String encode(String s){
        String toOut = "";
        String[] slst = s.toLowerCase().split("");
    
        for (int i = 0; i < slst.length; i++){
            TreeNode<T> node = this.root;

            if (!slst[i].equals(" ")){
                while (!node.getElement().equals(slst[i])){
                    if (node.getLeft().isIn(slst[i])){
                        toOut += "o";
                        node = node.getLeft();
                    }
                    else if (node.getRight().isIn(slst[i])){
                        toOut += "-";
                        node = node.getRight();
                    }
                    else{ // for testing purposes
                        System.out.println("Got a bug in the encoder! Send Help!");
                    }
                }
                toOut += "|";
            }
        }
        return toOut;
    }

    public String decode(String s){
        String toOut = "";
        String[] slst = s.split("\\|");
    
        for (int i = 0; i < slst.length; i++){
            TreeNode<T> node = this.root;
            String[] dd = slst[i].split("");

            for (int j = 0; j < dd.length; j++){
                if (dd[j].equals("o")){
                    node = node.getLeft();
                }
                else if (dd[j].equals("-")){
                    node = node.getRight();
                }
                else{ // for testing purposes
                    System.out.println("Got a bug in the decoder! Send Help!");
                }
            }
            toOut += node.getElement();
        }
        return toOut;
    }
    
}
