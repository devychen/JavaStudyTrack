**Statement `if else`**
1. Syntax
```
if (Boolena_Expression) {
// do this if B_E is true;
} else {
// do this if false;
}
```
!else part could be omiited sometimes <br>
2. Nested `if else`
```
if (Boolean_Expression_1) {
  if (Boolean_Expression_2) {
    Statement(s)
  } else {
    Statement(s)
  }
} else {
  if (Boolean_Expression_3) {
    Statement(s)
  } else {  // each `else` paried with nearest `if`
    Statement(s);
  }
}
```
3. Multi branch `if else`
```
if (B_E_1) {
  Statement(s)
} else if (B_E_2) {
  Statement(s)
} else if (B_E_3) {
  Statement(s)
} else if ...
} else (
  Default_Statement(s)
)
```

**Statement `switch`**