"""
Get total score based on varargs (the method that allows any number of arguments).
"""
import math


def calculate_score_with_multiplier(*args):
    """
    Function to calculate total score that increases the multiplier by 1.

    Parameters:
    args - list of numbers

    Returns:
    The total score.
    """
    score = 0
    multiplier = 1
    values = list(args)
    for value in values:
        score += value * multiplier
        multiplier += 1  # increase multiplier by 1 every time
    return score


def calculate_score_with_exponential_multiplier(*args):
    """
    Function to calculate the total score that increases the multiplier exponentially.

    Parameters:
    args - list of numbers

    Returns:
    The total score.
    """
    score = 0
    multiplier = 1.0
    values = list(args)
    for value in values:
        score += value * multiplier
        multiplier += multiplier / (
            1 + math.log(multiplier)
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
        value_of = int(input("Enter a number: "))
        values_list.append(
            sum(int(digit) for digit in str(value_of))
        )  # sum of all digits
        if value_of == 0:
            exit_program = True

if mode == 1:
    print("Score: " + str(calculate_score_with_multiplier(*values_list)))

elif mode == 2:
    print(
        "Score: "
        + str(math.floor(calculate_score_with_exponential_multiplier(*values_list)))
    )
