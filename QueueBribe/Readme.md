Consider a queue = 1 2 3 4 5 6 7 8 <br>
Say, number 3 bribes twice and comes ahead. <br>
New queue = 3 1 2 4 5 6 7 8 <br><br>

Now, number 5 bribes one time. <br>
New queue = 3 1 2 5 4 6 7 8 <br><br>

Find the minimum number of bribes possible (in this case, answer = 3). <br><br>

Sample run case with my brute force logic <br>
<em>
<<< Create input string map >>> <br>
1 2345678 <br>
2 345678 <br>
3 45678 <br>
4 5678 <br>
5 678 <br>
6 78 <br>
7 8 <br>
8 <br>
<<< Create output string map >>> <br>
1 <br>
2 1 <br>
5 12 <br>
3 125 <br>
7 1253 <br>
8 12537 <br>
6 125378 <br>
4 1253786 <br>
<<< Procesing >>> <br>
Total number of bribes = 7 <br>
</em>
