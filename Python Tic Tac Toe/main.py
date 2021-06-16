def print_board(bo):
    print('---------')
    print('|', bo[0][0], bo[0][1], bo[0][2], '|')
    print('|', bo[1][0], bo[1][1], bo[1][2], '|')
    print('|', bo[2][0], bo[2][1], bo[2][2], '|')
    print('---------')


def create_board():
    board = " " * 9
    new_board = [[icon for icon in board[i:i + 3]] for i in range(0, len(board), 3)]
    return new_board


def winner(bo, letter):
    if bo[0] == letter and bo[1] == letter and bo[2] == letter:
        return True
    elif bo[2] == letter and bo[4] == letter and bo[5] == letter:
        return True
    elif bo[6] == letter and bo[7] == letter and bo[8] == letter:
        return True
    elif bo[0] == letter and bo[3] == letter and bo[6] == letter:
        return True
    elif bo[1] == letter and bo[4] == letter and bo[7] == letter:
        return True
    elif bo[2] == letter and bo[5] == letter and bo[8] == letter:
        return True
    elif bo[0] == letter and bo[4] == letter and bo[8] == letter:
        return True
    elif bo[2] == letter and bo[4] == letter and bo[6] == letter:
        return True
    return False


player_board = create_board()
print_board(player_board)

while True:
    turn = 0
    x, y = input('Enter the coordinates: ').split()
    if winner(sum(player_board, []), 'X'):
        print('X wins')
        break

    elif winner(sum(player_board, []), 'O'):
        print('O wins')
        break

    elif winner(sum(player_board, []), 'X') and not winner(sum(player_board, []), 'O') and turn == 9:
        print('Draw')
        break

    if not x.isdigit() or not y.isdigit():
        print('You should enter numbers!')

    elif not (1 <= int(x) <= 3) or not (1 <= int(y) <= 3):
        print('Coordinates should be from 1 to 3!')

    elif player_board[int(x) - 1][int(y) - 1] == 'X' or player_board[int(x) - 1][int(y) - 1] == 'O':
        print('This cell is occupied! Choose another one!')

    else:
        if turn % 2 == 0:
            player_board[int(x) - 1][int(y) - 1] = 'X'
            print_board(player_board)
        else:
            player_board[int(x) - 1][int(y) - 1] = 'O'
            print_board(player_board)
