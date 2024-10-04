import math


def multiplier(*args):
    score = 0
    multi = 1
    values = list(args)
    for value in values:
        score += value * multi  # increase multiplier by 1 every time
        multi += 1
    return score


def multiplier_log(*args):
    score = 0
    multi = 1.0
    values = list(args)
    for value in values:
        score += value * multi
        multi += multi / (
            1 + math.log(multi)
        )  # increase multiplier exponentially every time
    return score


values_list = []

mode = int(
    input(
        "Enter 1 for score with multiplier or 2 for score with multiplier growing exponentially: "
    )
)
if (mode == 1) | (mode == 2):
    exit_program = False
    while not exit_program:
        valueOf = int(input("Enter a number: "))
        values_list.append(
            int(str(valueOf)[:1])
        )  # get the first digit of entered value
        if valueOf == 0:
            exit_program = True

if mode == 1:
    print("Score: " + str(multiplier(*values_list)))

elif mode == 2:
    print("Score: " + str(math.floor(multiplier_log(*values_list))))
