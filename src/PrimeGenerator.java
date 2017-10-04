import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator {
    public static void main(String[] args){
        System.out.println(listPrimes(1000));
    }

    public static ArrayList<Integer> listPrimes(int i){
        ArrayList<Integer> primes = new ArrayList<Integer>();

        primes.add(2);
        int j = 1;
        int k = 3;
        while(j <= i){
            if (isPrime(k, primes.subList(0, j - 1))){
                primes.add(k);
                j++;
            }
            k++;
        }

        return primes;
    }

    //Takes an integer and an int array of all primes less than that integer.
    //returns true if that integer is prime and false otherwise
    public static boolean isPrime(int n, List<Integer> lesserPrimes){
        for(Integer i : lesserPrimes){
            if(n % i == 0){
                return false;
            } else if (i > Math.sqrt(n)){
                break;
            }
        }
        return true;
    }
}