l1=[1,3,4,5,8,0]
l2=[22,44,13]
l3=[]

for i in l1:
    if (i%2!=0):
        l3.append(i)
for i in l2:
    if(i%2==0):
        l3.append(i)
print(l3)
