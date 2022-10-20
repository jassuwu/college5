#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <errno.h>

int main(int argc, char **argv)
{
    int fd1[2];
    int fd2[2];
    if (pipe(fd1) == -1)
    {
        return 1;
    }
    if (pipe(fd2) == -1)
    {
        return 1;
    }
    int fork1, fork2;
    fork1 = fork(); // forking1
    if (fork1 == -1)
    {
        return 2;
    }
    if (fork1 == 0)
    {
        // Child process
        close(fd1[0]); // closed the read end fd1
        dup2(fd1[1], 1);
        close(fd1[1]); // closed the write end fd1
        execlp(argv[1], argv[1], NULL);
    }
    else
    {
        // parent process
        wait(NULL);
        fork2 = fork();
        close(fd1[1]);
        if (fork2 == -1)
        {
            return 2;
        }
        if (fork2 == 0)
        {
            dup2(fd1[0], 0);
            dup2(fd2[1], 1);
            close(fd1[0]); // closed read end of fd1
            close(fd2[0]); // closed read end of fd2
            close(fd2[1]); // closed write end of fd2
            execlp(argv[2], argv[2], NULL);
        }
        else
        {
            wait(NULL);
            close(fd2[1]); // closed write end of fd2
            dup2(fd2[0], 0);
            close(fd2[0]); // closed read end of fd2
            execlp(argv[3], argv[3], NULL);
        }
    }
    return 0;
}