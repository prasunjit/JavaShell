# JavaShell
This is a Mini Java Shell (Bash) which will execute the commands (Linux/UNIX) specified by the user.Like any other shell, JavaShell takes as input the name of the program to run (e.g., hostname, pwd, echo, etc.) and three additional inputs.
<br>1.Whether the processes should execute concurrently or sequentially.</br>
2.The number of copies (processes) of the program to run. This is an integer from 1 to 9.</br>
3.A timeout (also an integer from 1 to 9) specifying the maximum duration of each process in seconds (reset between processes if running sequentially).If a process takes longer than the timeout, it is terminated. A timeout value of zero specifies no timeout.
