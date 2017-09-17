package miscCodingQuestions;

import java.util.Scanner;

/*
 *  Complete the function that takes an integer as its argument
 *  and returns the encoded string in base 7 using the following 
 *  encoding rule: base 10 0 1 2 3 4 5 6
 *   base 7 0 a t l s i N 
 *   Sample Input 1 7 
 *   Sample Output 1 a0 
 */
public class Base10ToBase7Conversion {
	public static void main(String[] args) {

        char [] b7={'0','a', 't', 'l', 's', 'i', 'n'};
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int i=t;
        StringBuffer sb = new StringBuffer();
        while (i>0){
            int m=i%7;
            sb.append(b7[m]);
            i=i/7;
        }

        System.out.println(Integer.parseInt(sb.reverse().toString()));
        in.close();

    }
}
