import pandas

dataframe= pandas.read_excel("Users.xlsx")
print("---------------------")
print("Excel data:")
print(dataframe)
print("---------------------")
print("Email column data:")
print(dataframe["Email"])
print("---------------------")
print("First Name column:")
print(dataframe.sort_values('FirstName'))
print("Number of rows and columns:", dataframe.shape)