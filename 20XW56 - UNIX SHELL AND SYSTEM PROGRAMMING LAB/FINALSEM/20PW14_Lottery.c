/*
By : @jassuwu - 20PW14


Q. Program the Raju, Binu, and Nina to play the lottery game.
The lottery game is played by selecting 5 numbers from 1 to MAXNUM (100 here).
The program should generate 3 lottery tickets and display them.
The program should keep generating a random number and display it.
The program should then match the random number with all the lottery tickets and see if any of them match.
First person to match all the 5 numbers wins the lottery.

A. Done using shared memory.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <time.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>

#define MAXNUM 10
#define NOTUPDATED 10101
#define CROSSED 11111
#define UPDATED 11001

int main(int argc, char **argv)
{
    srand(time(NULL));

    // Ticket generation for the three
    int *raju = (int *)malloc(5 * sizeof(int));
    int *binu = (int *)malloc(5 * sizeof(int));
    int *nina = (int *)malloc(5 * sizeof(int));

    for (int i = 0; i < 5; i++)
    {
        raju[i] = (rand() % MAXNUM) + 1;
        binu[i] = (rand() % MAXNUM - 1) + 2;
        nina[i] = (rand() % MAXNUM - 2) + 3;
    }
    printf("TICKET GENERATION COMPLETE...\n");
    printf("\nRaju's lottery ticket:\t");
    for (int i = 0; i < 5; i++)
    {
        printf("%d ", raju[i]);
    }
    printf("\nBinu's lottery ticket:\t");
    for (int i = 0; i < 5; i++)
    {
        printf("%d ", binu[i]);
    }
    printf("\nNina's lottery ticket:\t");
    for (int i = 0; i < 5; i++)
    {
        printf("%d ", nina[i]);
    }
    // int raju[] = {1, 70, 80, 75, 25};
    // int binu[] = {2, 60, 50, 56, 21};
    // int nina[] = {7, 43, 86, 73, 12};
    int shmidR, shmidB, shmidN;
    int *shmR, *shmB, *shmN;

    // Getting the shared memories
    shmidR = shmget(IPC_PRIVATE, 1024, 0666 | IPC_CREAT);
    shmR = shmat(shmidR, NULL, 0);

    shmidB = shmget(IPC_PRIVATE, 1024, 0666 | IPC_CREAT);
    shmB = shmat(shmidB, NULL, 0);

    shmidN = shmget(IPC_PRIVATE, 1024, 0666 | IPC_CREAT);
    shmN = shmat(shmidN, NULL, 0);

    // Initializing the shared region
    *shmR = NOTUPDATED;
    *shmB = NOTUPDATED;
    *shmN = NOTUPDATED;

    sleep(3);

    if (fork() == 0)
    {
        // RAJU
        while (1)
        {
            // busy wait till the writes happen from parent
            while (*shmR == NOTUPDATED || *shmB == NOTUPDATED || *shm N == NOTUPDATED)
                ;
            for (int i = 0; i < 5; i++)
            {
                if (*shmR == raju[i])
                {
                    *shmR = CROSSED;
                    break;
                }
            }
            if (*shmR != CROSSED)
                *shmR = UPDATED;
            ;
        }
        exit(0);
    }
    else
    {
        if (fork() == 0)
        {
            // BINU
            while (1)
            {
                // busy wait till the writes happen from parent
                while (*shmR == NOTUPDATED || *shmB == NOTUPDATED || *shmN == NOTUPDATED)
                    ;
                for (int i = 0; i < 5; i++)
                {
                    if (*shmB == binu[i])
                    {
                        *shmB = CROSSED;
                        break;
                    }
                }
                if (*shmB != CROSSED)
                    *shmB = UPDATED;
            }
            exit(0);
        }
        else
        {
            if (fork() == 0)
            {
                // NINA
                while (1)
                {
                    // busy wait till the writes happen from parent
                    while (*shmR == NOTUPDATED || *shmB == NO TUPDATED || *shmN == NOTUPDATED)
                        ;
                    for (int i = 0; i < 5; i++)
                    {
                        if (*shmN == nina[i])
                        {
                            *shmN = CROSSED;
                            break;
                        }
                    }
                    if (*shmN != CROSSED)
                        *shmN = UPDATED;
                }
                exit(0);
            }
            else
            {
                // PARENT
                int R = 0;
                int B = 0;
                int N = 0;
                int r = 0;
                int round = 0;
                while (B < 5 && R < 5 && N < 5)
                {
                    printf("\nROUND %d:\n", ++round);
                    // Writing the lot number to the shared regions
                    r = (rand() % MAXNUM - 5) + 6;
                    *shmR = r;
                    *shmB = r;
                    *shmN = r;
                    printf("%d is the lot number.\n", r);
                    sleep(1);

                    // busy waiting when not updated whether crossed
                    while (*shmR == NOTUPDATED || *shmB == NOTU PDATED || *shmN == NOTUPDATED)
                        ;

                    // Update the score or not
                    if (*shmR == CROSSED)
                    {
                        printf("Raju crossed his %dth number.\n", ++R);
                        sleep(1);
                    }
                    else
                    {
                        printf("Raju was unlucky this round.\n");
                    }
                    if (*shmB == CROSSED)
                    {
                        printf("Binu crossed her %dth number.\n", ++B);
                        sleep(1);
                    }
                    else
                    {
                        printf("Binu was unlucky this round.\n");
                    }
                    if (*shmN == CROSSED)
                    {
                        printf("Nina crossed her %dth number.\n", ++N);
                        sleep(1);
                    }
                    else
                    {
                        printf("Nina was unlucky this round.\n");
                    }

                    // display the scores
                    printf("Raju: %d\nBinu: %d\nNina: %d\n", R, B, N);

                    // Reset to NOTUPDATED
                    *shmR = NOTUPDATED;
                    *shmB = NOTUPDATED;
                    *shmN = NOTUPDATED;
                } // ENDWHILE
                if (R == 5)
                {
                    printf("Raju won the lottery.\n");
                }
                else if (B == 5)
                {
                    printf("Binu won the lottery.\n");
                }
                else if (N == 5)
                {
                    printf("Nina won the lottery.\n");
                }

                // EXIT SUCCESS
                exit(0);
            } // ENDOFFORK3
        }     // ENDOFFORK2
    }         // ENDOFFORK1
    return 0;
}
