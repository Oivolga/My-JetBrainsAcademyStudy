import random

num = int(input("Enter the number of friends joining (including you): "))
line = []
if num > 0:
    print("\nEnter the name of every friend (including you), each on a new line:")
    dictionary = {input(): 0 for element in range(num)}
    print("\nEnter the total bill value:")
    total = int(input())
    print("\nDo you want to use the 'Who is lucky?' feature? Write Yes/No:")
    choice = input()
    if choice == "Yes":
        for key in dictionary:
            dictionary[key] = round((total / num + 1), 2)
            line.append(key)
        rand = random.choice(line)
        print()
        print(rand, "is the lucky one!")
        dictionary[rand] = 0
        print()
        print(dictionary)
    else:
        print("\nNo one is going to be lucky")
        for key in dictionary:
            dictionary[key] = round((total / num), 2)
        print()
        print(dictionary)
else:
    print("\nNo one is joining for the party")
