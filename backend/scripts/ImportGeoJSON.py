# This file is meant to import the GeoJSON file into mysql
# so that it can then be parsed into specific columns by the
# SQL queries in the "queries" folder

import mysql.connector
import json

# Connect to MySQL
conn = mysql.connector.connect(
    host="your_host",
    user="your_user",
    password="your_password",
    database="your_database"
)
cursor = conn.cursor()

# Read the JSON file
with open('C:/path/to/your/document.json', 'r') as file:
    json_data = file.read()

# Insert JSON data into MySQL table
cursor.execute("CREATE TABLE IF NOT EXISTS json_store (id INT AUTO_INCREMENT PRIMARY KEY, data JSON)")
cursor.execute("INSERT INTO json_store (data) VALUES (%s)", (json_data,))
conn.commit()

cursor.close()
conn.close()
