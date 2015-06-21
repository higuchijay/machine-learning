
import java.io.*;
import java.util.*;

public class DecisionTreeClassifier
{
public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    String line = null;
    classifier c = new classifier();
    int posCount = 0;
    int negCount = 0;
    
   /* while(reader.hasNextLine()){

        String lin = reader.nextLine();
        

        //System.out.println(lin);



        String[] l = lin.split("\t");
        //System.out.println(l.length);
            /*String category = l[0];
            //System.out.println(category);
            String[] sentence = l[1].split(" ");

            if(l[0].equals("0"))
                negCount++;
            if(l[0].equals("1"))
                posCount++;
            c.train(category, sentence);
        }
*/

        //System.out.println(a);
    BufferedReader fileReader = null;
    BufferedReader filereader = null;
    
    try {

        
        fileReader=new BufferedReader(new InputStreamReader(System.in));
        filereader=new BufferedReader(new FileReader(new File(args[0]))); 
        //System.out.println("a");
        long startTime = System.currentTimeMillis();
        
        int a = 0;
        while((line=fileReader.readLine())!=null)
        {
            //a++;
            String[] l = line.split("\t");
            String category = l[0];
            String[] sentence = l[1].split(" ");
            if(l[0].equals("0"))
                negCount++;
            if(l[0].equals("1"))
                posCount++;
            c.train(category, sentence);
        }
        //System.out.println("b");
        long stopTime = System.currentTimeMillis();
        //System.out.println(startTime-stopTime);
        int count = 0;
        int total = 0;
        

        c.posCount = posCount;
        c.negCount = negCount;
        //System.out.println(posCount + " " + negCount);
        long start = System.currentTimeMillis();

        while((line=filereader.readLine())!=null)
        {
            String[] l = line.split("\t");
            String category = l[0];
            String result;
            
            //int count = 0;
            //int total = 0;
            String[] sentence = l[1].split(" ");
            ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(sentence));
            if(c.calculate(wordList,"0")>=c.calculate(wordList,"1"))
                {
                    System.out.println("0");
                    //System.out.println(c.calculateProbability(wordList,"0"));
                    result = "0";
                }
                


           else
            {
                System.out.println("1");
                result = "1";
            }

            if(result.equals(category))
                count++;
            total++;


        }
        long stop = System.currentTimeMillis();
        long time = (stopTime - startTime)/(long)1000;
        long t = (stop - start)/(long)1000;
        System.out.println("\n" + time + " seconds");
        System.out.println(t + " seconds");
        double accuracy = (double) count/total;
        System.out.println(accuracy + " test accuracy");
        




    } 
    catch (FileNotFoundException e) {
 // TODO Auto-generated catch block
    e.printStackTrace();
    } 
    catch (IOException e) {
 // TODO Auto-generated catch block
    e.printStackTrace();
    }

 }
}