def status(line):
    print("\nThe coffee machine has:")
    print(str(line[0]), "of water")
    print(str(line[1]), "of milk")
    print(str(line[2]), "of coffee beans")
    print(str(line[3]), "of disposable cups")
    print(str(line[4]), "of money")


def espresso(line):
    if line[0] < 250:
        print("Sorry, not enough water!")
    elif line[2] < 16:
        print("Sorry, not enough coffee beans!")
    elif line[3] == 0:
        print("Sorry, not enough disposable cups!")
    else:
        print("I have enough resources, making you a coffee!")
        line[0] -= 250
        line[2] -= 16
        line[3] -= 1
        line[4] += 4
    return line


def latte(line):
    if line[0] < 350:
        print("Sorry, not enough water!")
    elif line[1] < 75:
        print("Sorry, not enough milk!")
    elif line[2] < 20:
        print("Sorry, not enough coffee beans!")
    elif line[3] == 0:
        print("Sorry, not enough disposable cups!")
    else:
        print("I have enough resources, making you a coffee!")
        line[0] -= 350
        line[1] -= 75
        line[2] -= 20
        line[3] -= 1
        line[4] += 7
    return line


def cappuccino(line):
    if line[0] < 200:
        print("Sorry, not enough water!")
    elif line[1] < 100:
        print("Sorry, not enough milk!")
    elif line[2] < 12:
        print("Sorry, not enough coffee beans!")
    elif line[3] == 0:
        print("Sorry, not enough disposable cups!")
    else:
        print("I have enough resources, making you a coffee!")
        line[0] -= 200
        line[1] -= 100
        line[2] -= 12
        line[3] -= 1
        line[4] += 6
    return line


def buy(line):
    number = input("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n")
    if number == "back":
        return
    elif number == "1":
        espresso(line)
    elif number == "2":
        latte(line)
    else:
        cappuccino(line)


def fill(line):
    water = int(input("Write how many ml of water you want to add:\n"))
    line[0] += water
    milk = int(input("Write how many ml of milk you want to add:\n"))
    line[1] += milk
    beans = int(input("Write how many grams of coffee beans you want to add:\n"))
    line[2] += beans
    cups = int(input("Write how many disposable coffee cups you want to add:\n"))
    line[3] += cups
    return line


def menu():
    while True:
        print("\nWrite action (buy, fill, take, remaining, exit):")
        user = input()
        if user == "exit":
            break
        elif user == "remaining":
            status(line)
        elif user == "buy":
            buy(line)
        elif user == "fill":
            fill(line)
        else:
            print("I gave you $" + str(line[4]))
            line[4] = 0


line = [400, 540, 120, 9, 550]  # water = 400, milk = 540, beans = 120, cups = 9, money = 550
menu()
