import argparse
import math

parser = argparse.ArgumentParser()
parser.add_argument("--type")
parser.add_argument("--principal", type=int)
parser.add_argument("--payment", type=int)
parser.add_argument("--periods", type=int)
parser.add_argument("--interest", type=float)

args = parser.parse_args()
parameters = [args.type, args.principal, args.payment, args.periods, args.interest]
count = 0

if not args.interest or not args.type:
    print("Incorrect parameters")
else:
    i = args.interest / (12 * 100)
    if args.type == "diff":
        if args.payment or len(parameters) < 4 or args.principal < 0 or args.interest < 0:
            print("Incorrect parameters")
        else:
            for m in range(1, args.periods + 1):
                d = (args.principal / args.periods) + (
                            i * (args.principal - ((args.principal * (m - 1)) / args.periods)))
                count += math.ceil(d)
                print("Month " + str(m) + ": payment is " + str(math.ceil(d)))
            print()
            print("Overpayment = " + str(count - args.principal))
    elif args.type == "annuity":
        if not args.payment:
            if args.principal < 0 or args.periods < 0 or args.interest < 0:
                print("Incorrect parameters")
            else:
                a = math.ceil(
                    args.principal * (i * math.pow((1 + i), args.periods) / (math.pow((1 + i), args.periods) - 1)))
                print("Your annuity payment = " + str(a) + "!")
                print("Overpayment = " + str(a * args.periods - args.principal))
        elif not args.principal:
            if args.payment < 0 or args.periods < 0 or args.interest < 0:
                print("Incorrect parameters")
            else:
                p = math.floor(args.payment / (i * math.pow((1 + i), args.periods) / (math.pow((1 + i), args.periods) - 1)))
                print("Your loan principal = " + str(p) + "!")
                print("Overpayment = " + str(args.payment * args.periods - p))
        elif not args.periods:
            if args.payment < 0 or args.principal < 0 or args.interest < 0:
                print("Incorrect parameters")
            else:
                n = math.ceil(math.log((args.payment / (args.payment - i * args.principal)), 1 + i))
                y = n // 12
                m = n % 12
                if m == 1:
                    output2 = "month"
                else:
                    output2 = "months"
                if y == 0:
                    print("It will take", m, output2, "to repay this loan!")
                elif y == 1:
                    print("It will take 1 year and", m, output2, "to repay this loan!")
                elif m == 0:
                    print("It will take", y, "years to repay this loan!")
                else:
                    print("It will take", y, "years and", m, output2, "to repay this loan!")
                print("Overpayment = " + str(args.payment * n - args.principal))







