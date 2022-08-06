import pandas as pd

dataframe = pd.read_csv("creds.csv")

print(dataframe["Username"])

print(dataframe["Username"][1], dataframe["Passwords"][1])

print(dataframe.sort_values("Username"))

print(dataframe.sort_values("Passwords", ascending= False))