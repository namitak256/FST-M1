from typing import List

li=[]
count=int(input("Enter the desired size of the list: "))
for i in range(0,count):
    li.append(int(input("Enter an item for the list: ")))
sum=0
for x in li:
    sum=sum+x
print(sum)