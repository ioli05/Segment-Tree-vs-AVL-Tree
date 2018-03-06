import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException
    {
        AVLTree tree = new AVLTree();

        Scanner br = new Scanner(new FileReader("C:\\Users\\Ionela\\eclipse-workspace\\TemaAA\\src\\test6"));

        int n = br.nextInt();
        int [] elements = new int[n];
        int i = 0;
        while (br.hasNextInt()){

            elements[i] = br.nextInt();
            i++;
        }

        System.out.println("Pentru arborii AVL:");
        /*Adaugare elemente in arbore*/
        long startTime = System.nanoTime();
        for (i = 0; i < elements.length; i++) {

            tree.root = tree.insert(tree.root, elements[i]);
        }
        long endTime = System.nanoTime();
        System.out.println("Adaugare:  " + (endTime - startTime) + " milliseconds");


        /*Calculul minimului*/
        startTime = System.nanoTime();
        Node x = tree.minValueNode(tree.root);
        endTime = System.nanoTime();
        System.out.println("Minimul:  " + (endTime - startTime) + " milliseconds");

        /*Calcularea numarului de elemnte mai mici decat x*/

        startTime = System.nanoTime();
        int nr = tree.CountLower(tree.root, 31);
        endTime = System.nanoTime();
        System.out.println("Numar elemente mai mici:  " + (endTime - startTime) + " milliseconds");

        /*Stergerea tuturor elementelor*/
        System.out.println("Stergerea tuturor elemntelor");
        startTime = System.nanoTime();
        for (i = 0; i < elements.length; i++) {

            tree.deleteNode(tree.root, elements[i]);
        }
        endTime = System.nanoTime();
        System.out.println("Stergere: " + (endTime - startTime) + " milliseconds");

        SegmentTree st = null;


        System.out.println("Pentru arbori Segment: ");
        /*Adaugare elemente*/
        startTime = System.nanoTime();
        st = new SegmentTree(elements);
        endTime = System.nanoTime();
        System.out.println("Adaugare:  " + (endTime - startTime) + " milliseconds");

        /*Inlocuirea valorii*/
        startTime = System.nanoTime();
        i = 0;
        int index = 0;
        while (i < elements.length) {

            if (elements[i] == 31) {
                index = i;
            }
            i++;
        }

        st.update(index, index, 10);
        endTime = System.nanoTime();
        System.out.println("Update:  " + (endTime - startTime) + " milliseconds");

        /*Calculul minimului dintr-un interval x, y*/
        startTime = System.nanoTime();
        int min = st.rMinQ(0, 50);
        endTime = System.nanoTime();
        System.out.println("Minimul arborelui: " + (endTime - startTime) + " milliseconds");

        /*Inlocuirea elementelor ce urmeaza a fi sterse*/
        startTime = System.nanoTime();
        for (i = 0; i < elements.length; i++) {

            st.update(i, i, -1);

        }
        endTime = System.nanoTime();

        System.out.println("Stergere: " + (endTime - startTime) + " milliseconds");


    }
}
