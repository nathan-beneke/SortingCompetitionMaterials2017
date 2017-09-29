import java.util.Comparator;

public class Group0 {

	public static void main(String[] args) throws InterruptedException {
		// testing the comparator:
		PrimesComparator.testPrimeFactors();
		
		if (args.length < 2) {
			System.out.println("Please run with two command line arguments: input and output file names");
			System.exit(0);
		}

		String inputFileName = args[0];
		String outFileName = args[1];
		
		// read as strings
	}
	
	private static class PrimesComparator implements Comparator<String> {

		@Override
		public int compare(String str1, String str2) {
			long n = new Long(str1);
			long m = new Long(str2);
			
			return 0;
		}
		
		// Takes a long number and returns the product of its up to two 
		// smallest prime factors
		private static long productOfPrimeFactors(long n) {
			long prime1 = 1;
			long prime2 = 1;
			long bound = (long) Math.sqrt(n) + 1;
			
			for (int i = 2; i <= bound; ++i) {
				if ((n % i) == 0) { // the first found factor must be prime
					if (prime1 == 1) {
						prime1 = i;
					} else { // the second found factor is a prime or a power of the first one
						if (i % prime1 != 0) { // now we know it's a prime
							prime2 = i;
							break;
						}
					}
				}
			}

			// if we didn't find any prime factors, the number itself must be prime
			if (prime1 == 1 && prime2 == 1) {
				prime1 = n;
			} else if (prime2 == 1)	{ // if we have only one prime, the other one may be larger than the square root,
									// but only if it's not a power of the other prime
				long candidate = n / prime1;
				if (candidate % prime1 != 0) {
					prime2 = candidate; 
				}
			}		
			
			return prime1 * prime2;
		}
		
		public static void testPrimeFactors() {
			if (productOfPrimeFactors(8) != 2) {
				System.out.println("fails on 8");
			}
			if (productOfPrimeFactors(27) != 3) {
				System.out.println("fails on 27");
			}
			if (productOfPrimeFactors(121) != 11) {
				System.out.println("fails on a square: 121");
			}
			if (productOfPrimeFactors(20) != 10) {
				System.out.println("fails on 20");
			}
			if (productOfPrimeFactors(7901) != 7901) {
				System.out.println("fails on prime: 7901");
			}			
			if (productOfPrimeFactors((new Long("1000000000000")).longValue()) != 10) {
				System.out.println("fails on 1000000000000");
			}
			if (productOfPrimeFactors(55852169) != 55852169) {
				System.out.println("fails on product of primes: 55852169");
				System.out.println(productOfPrimeFactors(55852169));
			}
			if (productOfPrimeFactors(446817352) != 14138) { // 8 * 7069 * 7901, so product = 2 * 7069 = 14138
				System.out.println("fails on 446817352");
				System.out.println(productOfPrimeFactors(446817352));
			}
		}
	}

}
