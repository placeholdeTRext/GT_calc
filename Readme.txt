=========
2x2 Games
=========

Picture a 2x2 matrix, with each element showing the payoff for two players. The payoffs are shown separated by a comma.
This matrix presents four possible scenarios, determined by Player1's decisions (U,D) and Player2's decisions (L,R).

		 L	     R
	U	a,b	    c,d
	D	e,f	    g,h

We can interpret 'a,b' as the combination of payoffs should Player1 choose strategy 'U', and Player2 choose strategy 'L'.
In this case, the payoff for Player1 is 'a' and the payoff for Player2 is 'b'.

A Nash Equilibrium is a pair of strategies where no player has any incentive to change their choice. This can be shown as
a combination of pure strategies, for example (U,L) where Player1 chooses U and Player2 L, or as a mixed strategy, like
([y; 1-y], R) where Player2 will always play R and Player1 plays U with a probability of y and D with a probability of 1-y.

What the program means when it says 'non-essential' is that sometimes we find mixed Nash equilibria which is the same as
our pure Nash equilibria.

============
Instructions
============

1- Put in two numbers into each of the text boxes separated by a comma
    eg: 5,4

2- Press the Find Nash Equilibrium button