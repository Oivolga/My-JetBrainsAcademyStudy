class CoffeeMachine:
    amount_of_ingredients = [400, 540, 120, 9, 550]

    def buy(self):
        coffee = input("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n")

        if coffee == '1':
            self.making_coffee(250, 0, 16, 1, 4)
        elif coffee == '2':
            self.making_coffee(350, 75, 20, 1, 7)
        elif coffee == '3':
            self.making_coffee(200, 100, 12, 1, 6)
        elif coffee == 'break':
            return

    def fill(self):
        how_much_water = int(input('\nWrite how many ml of water you want to add:\n'))
        how_much_milk = int(input('Write how many ml of milk you want to add:\n'))
        how_many_beans = int(input('Write how many grams of coffee beans you want to add:\n'))
        how_many_cups = int(input('Write how many disposable coffee cups you want to add:\n'))

        list_of_ingredients = [how_much_water, how_much_milk, how_many_beans, how_many_cups]

        for i in range(4):
            self.amount_of_ingredients[i] += list_of_ingredients[i]

    def take(self):
        print(f"\nI gave you ${self.amount_of_ingredients[4]}")
        self.amount_of_ingredients[4] = 0

    def remaining(self):
        print(f"\nThe coffee machine has:\n"
              f"{self.amount_of_ingredients[0]} of water\n"
              f"{self.amount_of_ingredients[1]} of milk\n"
              f"{self.amount_of_ingredients[2]} of coffee beans\n"
              f"{self.amount_of_ingredients[3]} of disposable cups\n"
              f"${self.amount_of_ingredients[4]} of money")

    def making_coffee(self, water, milk, beans, cups, money):
        if min([self.amount_of_ingredients[0] // 200,
                self.amount_of_ingredients[1] // 50,
                self.amount_of_ingredients[2] // 15]) >= 1:

            print('I have enough resources, making you a coffee!')
            list_of_ingredients = [water, milk, beans, cups]

            for i in range(4):
                self.amount_of_ingredients[i] -= list_of_ingredients[i]

            self.amount_of_ingredients[4] += money
        else:
            print('Sorry, not enough water!')


while True:
    coffee_machine = CoffeeMachine()
    answer = input("Write action (buy, fill, take, remaining, exit):\n")

    if answer == 'exit':
        break
    else:
        getattr(coffee_machine, answer)()
