def lazy(x, op, y):
    msg = ""
    if float(x) % 1 == 0 and float(y) % 1 == 0:
        if float(x) and float(y) in range(-9, 10):
            msg += " ... lazy"
        if (float(x) == 1 or float(y) == 1) and op == "*":
            msg += " ... very lazy"
        if (float(x) == 0.0 or float(y) == 0.0) and op in "+-*":
            msg += " ... very, very lazy"
        if msg:
            print("You are" + msg)


operations = {
    "+": (lambda x, y: float(x) + float(y)),
    "-": (lambda x, y: float(x) - float(y)),
    "*": (lambda x, y: float(x) * float(y)),
    "/": (lambda x, y: float(x) / float(y))
}

memory = 0.0
start = True

while start:
    print("Enter an equation")
    x, op, y = input().split()
    if x == "M" and y == "M":
        x = memory
        y = memory
    elif x == "M":
        x = memory
    elif y == "M":
        y = memory
    try:
        float(x), float(y)
        if op in "+-*/":
            if op == "/" and float(y) == 0.0:
                print("You are ... lazy\nYeah... division by zero. Smart move...")
            else:
                lazy(x, op, y)
                result = operations[op](x, y)
                print(result)
                print("Do you want to store the result? (y / n):")
                ans1 = input()
                if ans1 == "y":
                    if result in range(-9, 10):
                        print("Are you sure? It is only one digit! (y / n)")
                        ans3 = input()
                        if ans3 == "y":
                            print("Don't be silly! It's just one number! Add to the memory? (y / n)")
                            ans4 = input()
                            if ans4 == "y":
                                print("Last chance! Do you really want to embarrass yourself? (y / n)")
                                ans5 = input()
                                if ans5 == "y":
                                    memory = result
                    else:
                        memory = result
                print("Do you want to continue calculations? (y / n):")
                ans2 = input()
                if ans2 == "n":
                    start = False
                    break
        else:
            print("Yes ... an interesting math operation. You've slept through all classes, haven't you?")
    except ValueError:
        print("Do you even know what numbers are? Stay focused!")
