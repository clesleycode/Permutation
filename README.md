# Permutation
COMS 3137 Assignment 1

Exercise 2.8.c in the Weiss text, with the following changes: Write a single Java applet to time
each of the three random permutation methods and use the Java 2D Graph package to graph the timings
of each algorithm for given input sequences on the same graph. For each random permutation method,
begin with an input value n = 100, and keep doubling the value of n until the time of execution for a run
is greater than 30 seconds or the value of n > 7, 000, 000. Figure 1 is a sample graph.
The Graph package, with examples, is available for download at:
http://www1.cs.columbia.edu/~allen/S14/graph/Top.html
You can also grab a simple applet on the class web page at:
www.cs.columbia.edu/~allen/S14/src/graphexample/example1.html
The source for the applet and Java jar file graph.jar with all the graph classes can also be downloaded from
this directory:
www.cs.columbia.edu/~allen/S14/src/graphexample/


Weiss 2.8.C:

Suppose you need to generate a random permutation of the first N integers.
For example, {4, 3, 1, 5, 2} and {3, 1, 4, 2, 5} are legal permutations, but
{5, 4, 1, 2, 1} is not, because one number (1) is duplicated and another (3) is
missing. This routine is often used in simulation of algorithms.We assume the existence
of a random number generator, r, with method randInt(i, j), that generates
integers between i and j with equal probability. Here are three algorithms:
  1. Fill the array a from a[0] to a[n-1] as follows: To fill a[i], generate random
numbers until you get one that is not already in a[0], a[1], . . . , a[i-1].
  2. Same as algorithm (1), but keep an extra array called the used array. When a
random number, ran, is first put in the array a, set used[ran] = true. This means
that when filling a[i] with a random number, you can test in one step to see
whether the random number has been used, instead of the (possibly) i steps in
the first algorithm.
  3. Fill the array such that a[i] = i + 1. Then
                for( i = 1; i < n; i++ )
                  swapReferences( a[ i ], a[ randInt( 0, i ) ] );
c. Write (separate) programs to execute each algorithm 10 times, to get a good
average. Run program (1) for N = 250, 500, 1,000, 2,000; program (2) for
N = 25,000, 50,000, 100,000, 200,000, 400,000, 800,000; and program (3) for
N = 100,000, 200,000, 400,000, 800,000, 1,600,000, 3,200,000, 6,400,000.
