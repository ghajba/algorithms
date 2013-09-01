Various implementations of the Bellman-Ford algorithm: http://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm

The purpose of the program is to find a solution to a system of difference inequalities.
The program should accept a system of difference inequalities from the file 'input.txt'. It should output the values of variables into the file 'output.txt'.
The input file 'input.txt' contains the system of difference inequalities in canonical representation that has the following format:
 * the number of difference inequalities
 * the number of variables in the inequalities
 * the list of inequalities separated by a carriage return
 * Each inequality is represented by a triple of integers < variable number, variable number, constraint value> which stands to represent xi-xj<=a (i.e. i j a separated by a space) 

An example of an input file 'input.txt'
9
11
1 2 3
1 3 1 
3 5 -1
1 4 2
2 5 3 
3 6 -2
4 6 2
5 7 3
7 8 -1
7 9 1
8 9 1

The output file 'output.txt' should contain values of the variables represented by the list of pairs <variable number, value>

An example of an output file 'output.txt'
1: -1
2:0
3:-2 
4:0 
5:0 
6: 0
7:-1 
8:0 
9:0 