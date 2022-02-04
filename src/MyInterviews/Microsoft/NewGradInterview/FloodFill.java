package MyInterviews.Microsoft.NewGradInterview;
/*
    Your coding assignment is to write a flood fill algorithm.
C++ or other OO language preferred, but you can select it.

The behavior of the algorithm is as follows:
Given a 2D screen of random pixel colors,
The user selects a pen color (e.g., Red)
The user selects a starting pixel and clicks on it
The starting pixel color is noted as the starting color (e.g., Blue)
The starting pixel is changed to the pen color (Red)
The starting pixel's neighbors are then considered:
For each neighboring pixel, if it is the starting color,
  it too is changed to the pen color
  its neighbors are then also considered in like manner

So, given this screen configuration (R=red, G=green, B=blue):

  G R B
  B B R
  G B B

If the user selects Red and clicks the center Blue pixel,
the final screen configuration will be:

  G R B
  R R R
  G R R

The focus should be on the algorithm, not the data structures.
I.e., you can assume a 2D array of ints to model the screen.

 */
public class FloodFill {
}
