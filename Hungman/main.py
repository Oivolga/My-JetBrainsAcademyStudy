import random

print("H A N G M A N")


def play():
    lang = ['python', 'java', 'kotlin', 'javascript']
    game = random.choice(lang)
    count = 0
    output = list("-" * len(game))
    line = []

    while count != 8:
        print()
        print(''.join([str(elem) for elem in output]))
        if "-" not in output:
            print("You guessed the word!")
            print("You survived!")
            break
        user = input("Input a letter: ")

        if user in line:
            print("You've already guessed this letter")
            continue
        elif len(user) != 1:
            print("You should input a single letter")
            continue
        elif (not user.islower()) or (user in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]):
            print("Please enter a lowercase English letter")
            continue

        if user not in game:
            print("That letter doesn't appear in the word")
            count += 1
            line.append(user)
        else:
            for i in range(0, len(game)):
                if game[i] == user:
                    output[i] = user
                    line.append(user)

    if count == 8:
        print("You lost!")
    print()


while True:
    menu = input('Type "play" to play the game, "exit" to quit: ')
    if menu == "exit":
        break
    elif menu == "play":
        play()
    else:
        ""
