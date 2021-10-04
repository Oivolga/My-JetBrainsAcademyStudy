import random

name = input("Enter your name: ")
print("Hello,", name)
word = ['water', 'dragon', 'devil', 'gun', 'rock', 'fire', 'scissors', 'snake', 'human', 'tree', 'wolf', 'sponge',
        'paper', 'air', 'lightning']
rating = 0
count = 0
lets = 0
comp = ""
rule = ""
wins = {
    'water': ['scissors', 'fire', 'rock', 'gun', 'lightning', 'devil', 'dragon'],
    'dragon': ['snake', 'scissors', 'fire', 'rock', 'gun', 'lightning', 'devil'],
    'devil': ['lightning', 'human', 'snake', 'scissors', 'fire', 'rock', 'gun'],
    'gun': ['wolf', 'tree', 'human', 'snake', 'scissors', 'fire', 'rock'],
    'rock': ['sponge', 'wolf', 'tree', 'human', 'snake', 'scissors', 'fire'],
    'fire': ['paper', 'sponge', 'wolf', 'tree', 'human', 'snake', 'scissors'],
    'scissors': ['air', 'paper', 'sponge', 'wolf', 'tree', 'human', 'snake'],
    'snake': ['water', 'air', 'paper', 'sponge', 'wolf', 'tree', 'human'],
    'human': ['dragon', 'water', 'air', 'paper', 'sponge', 'wolf', 'tree'],
    'tree': ['devil', 'dragon', 'water', 'air', 'paper', 'sponge', 'wolf'],
    'wolf': ['lightning', 'devil', 'dragon', 'water', 'air', 'paper', 'sponge'],
    'sponge': ['gun', 'lightning', 'devil', 'dragon', 'water', 'air', 'paper'],
    'paper': ['rock', 'gun', 'lightning', 'devil', 'dragon', 'water', 'air'],
    'air': ['fire', 'rock', 'gun', 'lightning', 'devil', 'dragon', 'water'],
    'lightning': ['tree', 'human', 'snake', 'scissors', 'fire', 'rock', 'gun']
}
while (True):
    user = input()
    if user == "!exit":
        print("Bye!")
        break
    elif user == "!rating":
        if count == 0:
            file = open('rating.txt', 'r')
            line = file.read().split()
            file.close()
            for i in range(0, len(line) - 1):
                if line[i] == name:
                    rating += int(line[i + 1])
            count += 1
        print("Your rating: ", rating)
    elif user in ("blabla", "invalid", "rock-n-roll") or user not in ("", "!exit", "!rating") and user not in word and not user.find(','):
        print("Invalid input")
    elif user.find(',') or user == "":
        if lets == 0:
            print("Okay, let's start")
            lets += 1
            if user != "":
                rule = user
            else:
                rule = 'rock,paper,scissors'
    comp = random.choice(rule.split(','))
    if user in word:
        if user == comp:
            print(f"There is a draw ({comp})")
            rating += 50
        elif user in wins[comp]:
            print(f"Sorry, but the computer chose {comp}")
        else:
            print(f"Well done. The computer chose {comp} and failed")
            rating += 100
