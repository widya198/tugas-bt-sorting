package bt_sorting;

import static bt_sorting.BinarySearchTree.Data.root;

public class BinarySearchTree{
    static class Data{
        Object element;
        Comparable key;
        public static BinaryTreeNode root;
        Data(Comparable theKey, Object theElement){
            key = theKey;
            element = theElement;
        }
        Data(){
            this.root = null;
        }
        public String toString(){
            return element.toString();
        }
    } 
    public Object get(Object theKey){
        BinaryTreeNode p = root;
        Comparable searchKey = (Comparable) theKey;
        while(p != null)
            if(searchKey.compareTo(((Data) p.element).key) < 0)
                p = p.leftChild;
            else
                if(searchKey.compareTo(((Data) p.element).key) > 0)
                    p = p.rightChild;
                else
                    return ((Data) p.element).element;
        return null;
    }
    public Object put(Object theKey, Object theElement){
        BinaryTreeNode p = root, pp = null;
        Comparable elementKey = (Comparable) theKey;
        while (p != null){
            pp = p;
            if(elementKey.compareTo(((Data) p.element).key) < 0)
                p = p.leftChild;
            else if(elementKey.compareTo(((Data) p.element).key) > 0)
                p = p.rightChild;
            else{
                Object elementToReturn = ((Data) p.element).element;
                ((Data) p.element).element = theElement;
                return elementToReturn;
            }
        }
        BinaryTreeNode r = new BinaryTreeNode(new Data(elementKey, theElement));
        if(root != null)
            if(elementKey.compareTo(((Data) pp.element).key) < 0)
                pp.leftChild = r;
            else
                pp.rightChild = r;
        else
            root = r;
        return null;
    }
    public Object remove(Object theKey){
        Comparable searchKey = (Comparable) theKey;
        BinaryTreeNode p = root, pp = null;
        while(p != null && !((Data) p.element).key.equals(searchKey)){
            pp = p;
            if(searchKey.compareTo(((Data)p.element).key) < 0)
                p = p.leftChild;
            else
                p = p.rightChild;
        }
        if(p == null)
            return null;
        Object theElement = ((Data) p.element).element;
        if(p.leftChild != null && p.rightChild != null){
            BinaryTreeNode s = p.leftChild, ps = p;
            while(s.rightChild != null){
                ps = s;
                s = s.rightChild;
            }
            p.element = s.element;
            p = s;
            pp = ps;
        }
        BinaryTreeNode c;
        if(p.leftChild == null)
            c = p.rightChild;
        else
            c = p.leftChild;
        if(p == root)
            root = c;
        else{
            if(p == pp.leftChild)
                pp.rightChild = c;
            else
                pp.rightChild = c;
        }
        return theElement;
    }
    public static void inOrder(BinaryTreeNode t){
      if (t != null){
        inOrder(t.leftChild);   // do left subtree
        System.out.println(t.element + " ");             // visit tree root
        inOrder(t.rightChild);  // do right subtree
      }
    }
    void inOrderOutput(){     
        inOrder(root);
    } 
    public void ascend(){
        inOrderOutput();
    }
}

