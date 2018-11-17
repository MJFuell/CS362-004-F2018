#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"


//Current player draws 3 cards

int testSmithy(int p, struct gameState *post, int hp) 
{
     struct gameState pre;
     //memcpy(&pre, post, sizeof(struct gameState));          //make a copy of the game state

     //  printf ("drawCard PRE: p %d HC %d DeC %d DiC %d\n",
     //	  p, pre.handCount[p], pre.deckCount[p], pre.discardCount[p]);

     int x;
     
     //printf("calling bug_smithy\n");
     x = bug_smithy(p, post, hp);
     //printf("done calling bug_smithy\n");
     //printf ("drawCard POST: p %d HC %d DeC %d DiC %d\n",
     //      p, post->handCount[p], post->deckCount[p], post->discardCount[p]);

     /*
     if (pre.deckCount[p] > 0) {
          pre.handCount[p]++;
          pre.hand[p][pre.handCount[p] - 1] = pre.deck[p][pre.deckCount[p] - 1];
          pre.deckCount[p]--;
     }
     else if (pre.discardCount[p] > 0) {
          memcpy(pre.deck[p], post->deck[p], sizeof(int) * pre.discardCount[p]);
          memcpy(pre.discard[p], post->discard[p], sizeof(int)*pre.discardCount[p]);
          pre.hand[p][post->handCount[p] - 1] = post->hand[p][post->handCount[p] - 1];
          pre.handCount[p]++;
          pre.deckCount[p] = pre.discardCount[p] - 1;
          pre.discardCount[p] = 0;
     }
     /*/

     assert(x == 0);
     //assert(memcmp(&pre, post, sizeof(struct gameState)) == 0);

     return 0;
};



int main()
{
     srand(time(0));
     int i, n, p, handPos;
     int k[10] = { adventurer, council_room, feast, gardens, mine, remodel, smithy, village, baron, great_hall };


     printf("Testing bugged smithy.\n");

     printf("RANDOM TESTS.\n");

     SelectStream(2);
     PutSeed(3);


     for (n = 0; n < 1000; n++)                             //create 1000 random tests
     {
          //printf("n = %i\n", n);

          struct gameState G;                               //create random game state
          int randPlayers = rand() % 4 + 1;
          int randSeed = rand() % 1000 + 1;

          //int initializeGame(int numPlayers, int kingdomCards[10], int randomSeed, struct gameState *state);
          initializeGame(randPlayers, k, randSeed, &G);    

          handPos = 1;

          //printf("calling testSmithy!\n");
          testSmithy(p, &G, handPos);
     }


/*
     G.numPlayers = 0; //number of players
     
     G.supplyCount[treasure_map + 1];  //this is the amount of a specific type of card given a specific number.
     G.embargoTokens[treasure_map + 1];
     
     G.outpostPlayed;
     G.outpostTurn;
     G.whoseTurn;
     G.phase;
     G.numActions;  //Starts at 1 each turn
     G.coins;       //Use as you see fit!
     G.numBuys;     //Starts at 1 each turn
     
     G.hand[MAX_PLAYERS][MAX_HAND];
     G.handCount[MAX_PLAYERS];
     G.deck[MAX_PLAYERS][MAX_DECK];
     G.deckCount[MAX_PLAYERS];
     G.discard[MAX_PLAYERS][MAX_DECK];
     G.discardCount[MAX_PLAYERS];
     G.playedCards[MAX_DECK];
     
     G.playedCardCount;
     */

     
     /*

     for (n = 0; n < 1000; n++)                             //create 1000 random game states
     {
          printf("n = %i\n", n);

          
          for (i = 0; i < sizeof(struct gameState); i++) 
          {
               //printf("i = %i\n", i);
               //((char*)&G)[i] = floor(Random() * 256);
          }

          
          //printf("set p\n");
          p = floor(Random() * 2);
          //printf("set deckcount\n");
          G.deckCount[p] = floor(Random() * MAX_DECK);      //setup a few limits so the state makes some kind of sense
          //printf("set discardCount\n");
          G.discardCount[p] = floor(Random() * MAX_DECK);
          //printf("set handcount\n");
          G.handCount[p] = floor(Random() * MAX_HAND);

          handPos = 0;

          printf("calling testSmithy!\n");
          testSmithy(p, &G, handPos);
     }
     */

     /*
     printf("SIMPLE FIXED TESTS.\n");
     for (p = 0; p < 2; p++) {
          for (deckCount = 0; deckCount < 5; deckCount++) {
               for (discardCount = 0; discardCount < 5; discardCount++) {
                    for (handCount = 0; handCount < 5; handCount++) {
                         memset(&G, 23, sizeof(struct gameState));
                         r = initializeGame(2, k, 1, &G);
                         G.deckCount[p] = deckCount;
                         memset(G.deck[p], 0, sizeof(int) * deckCount);
                         G.discardCount[p] = discardCount;
                         memset(G.discard[p], 0, sizeof(int) * discardCount);
                         G.handCount[p] = handCount;
                         memset(G.hand[p], 0, sizeof(int) * handCount);
                         checkDrawCard(p, &G);
                    }
               }
          }
     }

     */

    
     
     return 0;
}
