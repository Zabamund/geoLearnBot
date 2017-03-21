// code modified from https://www.codementor.io/johnnyb/how-to-write-a-web-scraper-in-nodejs-du108266t

"use strict"

// Import the dependencies
const cheerio = require("cheerio"), req = require("tinyreq");

const url = 'https://mineralseducationcoalition.org/minerals-database/diorite/';

// Define the scrape function
function scrape(url, data, callback) {
    // 1. Create the request
    req(url, (error, body) => {
        if (error) { return callback(error); }

        // 2. Parse the HTML
        let $ = cheerio.load(body), pageData = {};

        // 3. Extract the data
        Object.keys(data).forEach(key => {
            pageData[key] = $(data[key]).text();
        });

        // Send the data in the callback
        callback(null, pageData);
    });
}

// Extract some data from my website
// Get the website title (from the top header)
// ...and the description
scrape(url, {
    title: ".header h1",
    description: ".header h2"
}, (error, data) => {
    console.log(error || data);
});
