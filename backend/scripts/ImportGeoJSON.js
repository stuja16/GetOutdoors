/*
This file is meant to import the GeoJSON file into mysql
so that it can then be parsed into specific columns by the
SQL queries in the "queries" folder
*/

const mysql = require('mysql2');
const fs = require('fs');

// Create a connection to the database
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'student',
    password: 'Cmsc250!',
    database: 'getoutdoors',
    insecureAuth: true
});

// Connect to the database
connection.connect((err) => {
    if (err) throw err;
    console.log('Connected to MySQL database');
});

// Read the JSON file
fs.readFile('\Trans_TrailSegment.geojson', 'utf8', (err, data) => {
    if (err) throw err;

    // Insert JSON data into the database
    const query = 'INSERT INTO json_store (data) VALUES (?)';
    connection.query(query, [data], (err, results) => {
        if (err) throw err;
        console.log('JSON data inserted into database', results);
        
        // Close the connection
        connection.end();
    });
});