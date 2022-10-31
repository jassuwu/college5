#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h>
#include <string.h>

#define SHMSIZE 32

int main()
{
    srand(time(NULL));
    int cScore = 0, dScore = 0, pChoice;
    int c, d, r, shmid1, shmid2;
    key_t key1, key2;
    char num[27], num2[27], *shm1, *shm2, *s1, *s2;
    const char *Arr[] = {"MIN", "MAX"};
    key1 = rand();
    key2 = rand();
    for (int k = 0; k < 5; k++)
    {
        printf("Iteration: %d\n", k);
        if (fork() == 0)
        {
            sleep(2);
            if ((shmid1 = shmget(key1, SHMSIZE, 0)) == -1)
            {
                exit(1);
            }
            if ((shm1 = shmat(shmid1, NULL, 0)) == (char *)-1)
            {
                exit(1);
            }
            r = rand();
            sprintf(num, "%d", r);
            for (int i = 0; i < strlen(num); i++)
            {
                shm1[i] = num[i];
            }
            printf("Process C Wrote: %d\n", r);
        }
        else
        {
            srand(time(NULL));
            // printf("parent process\n");
            if ((shmid1 = shmget(key1, 32, 0666 | IPC_CREAT)) == -1)
            {
                printf("Error creating shared memory region\n");
                exit(1);
            }
            shm1 = shmat(shmid1, NULL, 0);
            if (shm1 == (char *)-1)
            {
                printf("Error attaching shared memory\n");
                exit(1);
            }
            // printf("shared memory id: %d\n",shmid1);
            wait(NULL);
            for (int i = 0; *(shm1 + i) != '\0'; i++)
            {
                num[i] = *(shm1 + i);
            }
            sscanf(num, "%d", &c);
            // printf("Parent read: %d\n",c);
            if (fork() == 0)
            {
                sleep(2);
                if ((shmid2 = shmget(key2, SHMSIZE, 0)) == -1)
                {
                    exit(1);
                }
                if ((shm2 = shmat(shmid2, NULL, 0)) == (char *)-1)
                {
                    exit(1);
                }
                // printf("Process D writing\n");
                r = rand();
                // printf("Process C Wrote: %d\n",r);
                // itoa(r,num,10);
                sprintf(num2, "%d", r);
                for (int i = 0; i < strlen(num); i++)
                {
                    shm2[i] = num2[i];
                }
                printf("Process D Wrote: %d\n", r);
            }
            else
            {
                // printf("parent 2 process\n");
                if ((shmid2 = shmget(key2, 32, 0666 | IPC_CREAT)) == -1)
                {
                    printf("Error creating shared memory region\n");
                    exit(1);
                }
                shm2 = shmat(shmid2, NULL, 0);
                if (shm2 == (char *)-1)
                {
                    printf("Error attaching shared memory\n");
                    exit(1);
                }
                // printf("shared memory id: %d\n",shmid2);
                wait(NULL);
                for (int i = 0; *(shm2 + i) != '\0'; i++)
                {
                    num2[i] = *(shm2 + i);
                }
                sscanf(num2, "%d", &d);
                printf("C's number: %d\n", c);
                printf("D's number: %d\n", d);

                if (strcmp(Arr[rand() % 2], "MIN") == 0)
                {
                    printf("Parent Choice: MIN\n");
                    if (c < d)
                    {
                        printf("C won!\n");
                        cScore += 1;
                    }
                    else if (d < c)
                    {
                        printf("D won!\n");
                        dScore += 1;
                    }
                    else
                    {
                        printf("TIE\n");
                    }
                }
                else
                {
                    printf("Parent Choice: MAX\n");
                    if (c > d)
                    {
                        printf("C won!\n");
                        cScore += 1;
                    }
                    else if (d > c)
                    {
                        printf("D won!\n");
                        dScore += 1;
                    }
                    else
                    {
                        printf("TIE\n");
                    }
                }
                printf("**SCORE**\nC: %d\nD: %d\n*********\n\n", cScore, dScore);
                // REMOVE SHARED MEMORY
                shmdt(NULL);
                if (shmctl(shmid2, IPC_RMID, NULL) == -1)
                {
                    printf("Error Removing chared memory\n");
                    exit(1);
                }
                printf("Shared memory 2 removed\n");

                if (shmctl(shmid1, IPC_RMID, NULL) == -1)
                {
                    printf("Error Removing chared memory\n");
                    exit(1);
                }
                printf("Shared memory 1 removed\n");
            }
        }
        // printf("Outside Parent C: %d\n",c);
        // printf("Outside Parent D: %d\n",d);

        // if(shmctl(shmid1,IPC_RMID,NULL) == -1){
        //       printf("Error Removing chared memory\n");
        //       exit(1);
        // }
        // printf("Shared memory 1 removed\n");
    }
}