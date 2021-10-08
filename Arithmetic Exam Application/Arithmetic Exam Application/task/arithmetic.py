import random


def input_answer():
    global user
    while True:
        try:
            user = int(input())
            return user
        except ValueError:
            print("Wrong format! Try again.")


def correct(res):
    global right, count, level
    if res == user:
        print("Right!")
        right += 1
        count += 1
    else:
        print("Wrong!")
        count += 1
    first() if level == "1" else second()
    return count, right


def first():
    global count, right
    line = ["+", "-", "*"]
    res = 0
    while True:
        if count == 5:
            output(right, level)
            break
        else:
            a = random.randint(2, 9)
            b = random.randint(2, 9)
            operation = random.choice(line)
            if operation == "+":
                res = a + b
            elif operation == "-":
                res = a - b
            elif operation == "*":
                res = a * b
            print(a, operation, b)
            input_answer()
            correct(res)
            return res


def output(right, level):
    print(f"Your mark is {right}/5. Would you like to save your result to the file? Enter yes or no.")
    fin = input()
    if fin in ['yes', 'YES', 'y', 'Yes']:
        print("What is your name?")
        name = input()
        file = open('results.txt', 'a', encoding='utf-8')
        if level == "1":
            file.write(f'{name}: {right}/5 in level 1 (simple operations with numbers 2-9)')
        else:
            file.write(f'{name}: {right}/5 in level 2 (integral squares 11-29)')
        file.close()
        print('The results are saved in "results.txt".')


def second():
    c = random.randint(11, 29)
    while True:
        if count == 5:
            output(right, level)
            break
        else:
            print(c)
            input_answer()
            res = c * c
            correct(res)
        return res


user = 0
right = 0
count = 0
while True:
    print("""Which level do you want? Enter a number:
    1 - simple operations with numbers 2-9
    2 - integral squares of 11-29""")
    level = input()
    if level == "1":
        first()
        break
    elif level == "2":
        second()
        break
    else:
        print("Incorrect format.")
