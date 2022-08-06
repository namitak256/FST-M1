d= dict(apple=100,mango=70,orange=50)
fruit = input("Which fruit do you want to look for : apple/mango/orange : ")
flag=False
for i in d:
    if(i==fruit):
        flag=True
        break

if flag==True:
    print(fruit,"is available")
else:
    print(fruit,"isn't available")