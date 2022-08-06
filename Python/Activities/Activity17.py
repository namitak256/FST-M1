import pandas

data = {
    ""
    "Username": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

dataframe= pandas.DataFrame(data)
dataframe.to_csv("creds.csv", index=False)