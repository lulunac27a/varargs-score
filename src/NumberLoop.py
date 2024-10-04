import math


def multiplier(*args):
    out = 0
    multi = 1
    values = list(args)
    for value in values:
        out += value * multi  # increase multiplier by 1 every time
        multi += 1
    return out


def multiplier_log(*args):
    out = 0
    multi = 1.0
    values = list(args)
    for value in values:
        out += value * multi
        multi += multi / (
            1 + math.log(multi)
        )  # increase multiplier exponentially every time
    return out


values = []

mode = int(
    input(
        "Enter 1 for score with multiplier or 2 for score with multiplier growing exponentially: "
    )
)
if (mode == 1) | (mode == 2):
    exit_program = False
    while not exit_program:
        valueOf = int(input("Enter a number: "))
        values.append(int(str(valueOf)[:1]))  # get the first digit of entered value
        if valueOf == 0:
            exit_program = True

if mode == 1:
    print("Score: " + str(multiplier(*values)))

elif mode == 2:
    print("Score: " + str(math.floor(multiplier_log(*values))))
