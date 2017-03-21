// code author https://github.com/IonicaBizau/scrape-it

const scrapeIt = require('scrape-it');
var fs = require('fs');

// Promise interface
scrapeIt("http://ionicabizau.net", {
    title: ".header h1"
  , desc: ".header h2"
  , avatar: {
        selector: ".header img"
      , attr: "src"
    }
}).then(page => {
    console.log(page);
});

// Callback interface
scrapeIt("http://ionicabizau.net", {
    // Fetch the articles
    articles: {
        listItem: ".article"
      , data: {
            // Get the article date and convert it into a Date object
            createdAt: {
                selector: ".date"
              , convert: x => new Date(x)
            }
            // Get the title
          , title: "a.article-title"
            // Nested list
          , tags: {
                listItem: ".tags > span"
            }
            // Get the content
          , content: {
                selector: ".article-content"
              , how: "html"
            }
        }
    }

    // Fetch the blog pages
  , pages: {
        listItem: "li.page"
      , name: "pages"
      , data: {
            title: "a"
          , url: {
                selector: "a"
              , attr: "href"
            }
        }
    }

    // Fetch some other data from the page
  , title: ".header h1"
  , desc: ".header h2"
  , avatar: {
        selector: ".header img"
      , attr: "src"
    }
}, (err, page) => {
    console.log(err || page);
});


/* export to file
function(index) {
    var title = $(this).find('p.title > a.title').text().trim();
    var score = $(this).find('div.score.unvoted').text().trim();
    var user = $(this).find('a.author').text().trim();
    console.log('Title: ' + title);
    console.log('Score: ' + score);
    console.log('User: ' + user);
    fs.appendFileSync('MEC.txt', title + '\n' + score + '\n' + user + '\n');
});
*/
