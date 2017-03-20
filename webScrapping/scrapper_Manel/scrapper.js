// code author Manel Pavon and https://github.com/IonicaBizau/scrape-it

const scrapeIt = require("scrape-it");

const mineralsArray = ['aluminum', 'amphibole', 'andesite', 'antimony', 'aragonite', 'arsenic', 'asbestos', 'augite', 'aurichalcite', 'autunite', 'barium', 'basalt']
let DATABASE = [];

function minerals(mineral){
  scrapeIt(`https://mineralseducationcoalition.org/minerals-database/${mineral}/`, {
      TITLE: "h1.mec-db-entry__title",
      DESCRIPTION: {
        selector: ".entry-content p",
        eq: 0
      },
      IMG: {
        listItem: "li.acf-image-gallery__item",
        data: {
            url: {
              selector: "a",
              attr: "href"
            },
            img: {
              selector: "img",
              attr: "src"
            }
        }
      }
  }).then(page => {
      DATABASE.push(page);
  });
}

mineralsArray.forEach((el) => minerals(el));

setTimeout(function(){
  console.log("Our database length: ", DATABASE.length);
  console.log("Our database is: ", DATABASE);
  console.log("The first element is: ", DATABASE[0]);
}, 1500);
