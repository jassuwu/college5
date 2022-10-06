#include<stdio.h>
#include<unistd.h>
#include<sys/wait.h>

int main(int argc, char **argv)
{
        int fd1[2];
        int fork1,fork2;

        pipe(fd1);
        fork1 = fork();

        if(fork1 == 0){
                dup2(fd1[1],1);
                //close(fd1[0]); //reading end closing is optional
                execlp(argv[1],argv[1],NULL);
        }
        else{
                wait(NULL);
                int fd2[2];
                pipe(fd2);
                fork2 = fork();
                close(fd1[1]);

                if(fork2 == 0){
                        dup2(fd1[0],0);
                        dup2(fd2[1],1);
                        //close(fd2[0]); //reading end closing is optional
                        execlp(argv[2],argv[2],NULL);
                }
                else{
                        wait(NULL);
                        dup2(fd2[0],0);
                        close(fd2[1]);
                        execlp(argv[3],argv[3],NULL);
                }
        }
}
