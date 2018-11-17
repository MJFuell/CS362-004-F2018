CFLAGS= -Wall -fpic -coverage -lm -std=c99

rngs.o: rngs.h rngs.c
	gcc -c rngs.c -g  $(CFLAGS)

dominion.o: dominion.h dominion.c rngs.o
	gcc -c dominion.c -g  $(CFLAGS)

playdom: dominion.o playdom.c
	gcc -o playdom playdom.c -g dominion.o rngs.o $(CFLAGS)
#To run playdom you need to entere: ./playdom <any integer number> like ./playdom 10*/
testDrawCard: testDrawCard.c dominion.o rngs.o
	gcc  -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

badTestDrawCard: badTestDrawCard.c dominion.o rngs.o
	gcc -o badTestDrawCard -g  badTestDrawCard.c dominion.o rngs.o $(CFLAGS)

testBuyCard: testDrawCard.c dominion.o rngs.o
	gcc -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

testAll: dominion.o testSuite.c
	gcc -o testSuite testSuite.c -g  dominion.o rngs.o $(CFLAGS)

interface.o: interface.h interface.c
	gcc -c interface.c -g  $(CFLAGS)



#This is the code I added to compile my random test files
randomTest1: randomtestcard1.c dominion.o rngs.o
	gcc -o rtc1 randomtestcard1.c -g dominion.o rngs.o $(CFLAGS)

randomTest2: randomtestcard2.c dominion.o rngs.o
	gcc -o rtc2 randomtestcard2.c -g  dominion.o rngs.o $(CFLAGS)

randomTestAdv: randomtestadventurer.c dominion.o rngs.o
	gcc -o rtca randomtestadventurer.c -g dominion.o rngs.o $(CFLAGS)

rts: randomtestcard1.c randomtestcard2.c randomtestadventurer.c
	make randomTest1
	make randomTest2
	make randomTestAdv

#This runs each test file and creates the .out files
runrts: rtc1 rtc2 rtca
	./rtc1 &> randomtestcard1.out
	gcov randomtestcard1.c -b >> randomtestcard1.out
	cat randomtestcard1.c.gcov >> randomtestcard1.out
	./rtc2 &> randomtestcard2.out
	gcov randomtestcard2.c -b >> randomtestcard2.out
	cat randomtestcard2.c.gcov >> randomtestcard2.out
	./rtca &> randomtestcardadventurer.out
	gcov randomtestadventurer.c -b >> randomtestcardadventurer.out
	cat randomtestadventurer.c.gcov >> randomtestadventurer.out





runtests: testDrawCard 
	./testDrawCard &> unittestresult.out
	gcov dominion.c >> unittestresult.out
	cat dominion.c.gcov >> unittestresult.out

player: player.c interface.o
	gcc -o player player.c -g  dominion.o rngs.o interface.o $(CFLAGS)

all: playdom player 

clean:
	rm -f *.o playdom.exe playdom player player.exe  *.gcov *.gcda *.gcno *.so *.out testDrawCard testDrawCard.exe rtc1 rtc2 rtca *.out



