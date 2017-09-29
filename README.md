# SortingCompetitionMaterials2017

Materials for UMM CSci 3501 "Algorithms and computability" 2017 sorting competition.

## Goal of the competition

The Sorting Competition is a multi-lab exercise on developing the fastest sorting algorithm for a given type of data. By "fast" we mean the actual running time and not the Big-Theta approximation. The solutions are developed in Java and will be ran on a single processor.

## The data



## How do you need to sort the data 

The points are sorted based on their distance to **the closer** of the two reference points. If the distance is smaller than the threshold `0.0000000001`, it is considered zero. If the two points being compared have the difference of their distances to the closest reference point within the treshold, they are considered to be at the equal distance. In this case the point with the smaller timestamp is considered smaller. 

## How is the data generated