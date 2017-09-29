# SortingCompetitionMaterials2017

Materials for UMM CSci 3501 "Algorithms and computability" 2017 sorting competition.

## Goal of the competition

The Sorting Competition is a multi-lab exercise on developing the fastest sorting algorithm for a given type of data. By "fast" we mean the actual running time and not the Big-Theta approximation. The solutions are developed in Java and will be ran on a single processor.

## The data

Data for this sorting competition consists of posistive numbers of 17 decimal digits or less, passed to the sorting 
method as an array of strings. 

The length of the numbers is most likely to be 5 or 6 decimal digits (the probability of the length being 5 or 6 is 1/6 each). The probability of lengths decreases similar to a bell curve as the length gets smaller or larger than 5 or 6. More specifically, the chances of each length are as follows, out of 1500 total:
```
{10, 45, 100, 180, 250, 250, 200, 100, 80, 70, 60, 50, 40, 30, 20, 10, 5}
``` 
Here 10 out of 1500 is the probability of a single digit number, 45 out of 1500 is the probability of a two-digit number, etc.

## How is the data generated

First the length is generated, according to the probabilities listed above. Then the digits are generated, with the most significant digit chosen among non-zero digits (to make sure that the number does indeed have the correct length). More details are in the file [DataGenerator2017.java](src/DataGenerator2017.java).

## How do you need to sort the data 

Given a number N, let P(N) be the product of the two smallest different prime factors of N, or the only prime factor of N
if it only has one. For instance:

* P(100) = 10 
* P(8) = 2
* P(17) = 17
* P(121) = 11

The data is sorted by the following comparison:

* If P(N1) < P(N2) then N1 is considered to be smaller than N2
* If P(N1) > P(N2) then N1 is considered to be larger than N2
* If P(N1) = P(N2) then N1 and N2 are compared as regular numbers

For instance:

* 10000 is smaller than 15 since P(10000) = 10, P(15) = 15, and P(10000) < P(15)
* 20 is smaller than 100 since P(20) = P(100) = 10, and 20 < 100

The file [Group0.java](src/Group0.java) provides a Comparator that implements this comparison and provides some tests. Please
consult it as needed.

