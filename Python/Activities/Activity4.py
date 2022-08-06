flag= True
while flag:
    p1=input("P1 player: ")
    p2=input("P2 player: ")

    if(p1=="rock"):
        if(p2=="scissors"):
            print("p1 wins")
        elif(p2=="paper"):
            print("p2 wins")
        else:
            print("Tie")
    elif(p1=="paper"):
        if(p2=="scissors"):
            print("p2 wins")
        elif(p2=="rock"):
            print("p1 wins")
        else:
            print("Tie")
    elif(p1=="scissors"):
        if(p2=="rock"):
            print("p2 wins")
        elif(p2=="paper"):
            print("p1 wins")
        else:
            print("Tie")
    else:
        print("Invalid input, Enter rock, paper or scissors")
    
    playagain= input("Do you want to play again: ")
    if playagain == "yes":
        flag=True
    elif playagain == "no":
        flag=False
    else:
        flag=False
        print("Invalid input, exiting")

