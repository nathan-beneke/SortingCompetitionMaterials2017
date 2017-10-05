import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class sortByPrime {
    public static void main(String[] args){
        String inputFile = args[0];
        String outputFile = args[1];
        String line;
        ArrayList<String> strarr = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                strarr.add(line);
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        String[] strarr1 = strarr.toArray(new String[strarr.size()]);

//        primeComparator var = new primeComparator();
//        System.out.println(var.getSortValue(12));
//        System.out.println(var.getSortValue(23));
//        System.out.println(var.getSortValue(8));
//        System.out.println(var.getSortValue(4));
//        System.out.println(var.getSortValue(16));
//        System.out.println(var.getSortValue(1));
//
//        String[] toSort = {"12", "23", "15485863","15485864", "2", "4", "982451653", "8", "16", "7927"};
//        printArray(toSort);
//        sort(toSort);
//        printArray(toSort);
        
        sort(strarr1);
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(String i : strarr1){
                bufferedWriter.write(i);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void sort(String[] strs){
        Long[] numbers = new Long[strs.length];
        for (int i = 0; i < strs.length; i++){
            numbers[i] = Long.parseLong(strs[i]);
        }

        primeComparator comparator = new primeComparator();

        Arrays.sort(numbers, comparator);

        for(int i = 0; i < numbers.length; i++){
            strs[i] = numbers[i].toString();
        }
    }

    public static void printArray(Object[] arr){
        for (Object i : arr){
            System.out.print(i.toString() + ", ");
        }
        System.out.println();
    }

    public static class primeComparator implements Comparator<Long> {

        public long getSortValue(long x){
            long y,z;
            y = getFirstPrime(x);
            z = getSecondPrime(x, y);

            return z*y;
        }

        public long getFirstPrime(long n){
            for (long i = 2; i <= Math.sqrt(n); i++){
                if (n % i == 0){
                    return i;
                }
            }
            return n;
        }

        public long getSecondPrime(long n, long firstPrime){
            long newN = n / firstPrime;

            while (newN % firstPrime == 0 && newN != firstPrime){
                newN /= firstPrime;
            }

            for (long i = firstPrime + 1; i <= newN; i++){
                if (newN % i == 0 && i % firstPrime != 0){
                    return i;
                }
            }
            return 1;
        }

        public boolean isPrime(long n){
            if (n % 2 == 0){
                return false;
            }
            for (int i = 3; i < Math.sqrt(n); i = i+2){
                if(n % i == 0){
                    return false;
                }
            }
            return true;
        }

        public int compare(Long v1, Long v2){
            int result = 0;
            long v1Val = getSortValue(v1);
            long v2Val = getSortValue(v2);

            if (v1Val < v2Val){
                result = -1;
            } else if (v2Val < v1Val){
                result = 1;
            } else if(v1 < v2){
                    result = -1;
            } else if (v1 > v2){
                result = 1;
            }

            return result;
        }
    }
}
