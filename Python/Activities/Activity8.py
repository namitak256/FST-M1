li=[]
count=int(input("Enter the desired size of the list: "))
for i in range(0,count):
    li.append(int(input("Enter an item for the list: ")))

if li[0]==li[-1]:
    print("True")
else:
    print("False")