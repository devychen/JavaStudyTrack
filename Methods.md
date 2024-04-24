**Method `exit`**
`System.exit(0)` <br>
To terminate program.
```
if (numberOfWinners == 0) {
  System.out.println ("Error: Dividing by zero.");
  System.exit (0);
  } else {
  oneShare = payoff / numberOfWinners;
  System.out.println("Each winner will receive $"
                    + oneShare);
}
```