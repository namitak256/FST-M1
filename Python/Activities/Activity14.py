def fibo(n):
    a=0
    print(a)
    b=1
    print(b)
    for i in range(1,n-1):
      c=a+b
      a=b
      b=c
      print(c)

num = int(input("Enter the limit of fibonacci series:"))
if(num<2):
    print("Please enter a number more than 1")
else:
    fibo(num)