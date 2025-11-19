import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static ArrayList<Term> getTermsList() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(new File("src/IngleseItaliano.csv")));
        String line = "";
        ArrayList<Term> terms = new ArrayList<>();
        try{
            while((line = br.readLine()) != null){
                String[] splitted = line.split(",");
                Term term = new Term(splitted[0], splitted[1]);
                terms.add(term);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return terms;
    }

    public static void printTermsList(ArrayList<Term> terms){
        for(Term term : terms){
            System.out.println(term);
        }
    }

    //TODO: RicorsionMethod
    public static void addTermsToTree(BinarySearchTree<Term> bst, ArrayList<Term> terms){

        ArrayList<Term> firstHalf = terms.subList(0, terms.size()/2);
        ArrayList<Term> secondHalf = terms.subList(terms.size()/2, terms.size());


    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Term> terms = getTermsList();
        printTermsList(terms);
        Term mid = terms.get(terms.size()/2);
        BinarySearchTree<Term> bst = new BinarySearchTree<>(null);

    }

}