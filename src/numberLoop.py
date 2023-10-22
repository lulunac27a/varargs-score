import math

def multiplier(*args):
    out = 0
    multi = 1
    values = list(args)
    for value in values:
        out += value * multi # increase multiplier by 1 every time
        multi += 1
    return out

def multiplierLog(*args):
    out = 0
    multi = 1.0
    values = list(args)
    for value in values:
        out += value * multi
        multi += multi / (1 + math.log(multi)) # increase multiplier exponentially every time
    return out

values = []
exit = 0

mode = int(input("Enter 1 for score with multiplier or 2 for score with multiplier growing exponentially: "))
if (mode == 1) | (mode == 2):
    while exit != 1:
        valueOf = int(input("Enter a number: "))
        values.append(int(str(valueOf)[:1])) # get the first digit of entered value
        if valueOf == 0:
            exit = 1

if mode == 1:
    print("Score: " + str(multiplier(*values)))

if mode == 2:
    print("Score: " + str(math.floor(multiplierLog(*values))))