// code modified from Manel Pavon and https://github.com/IonicaBizau/scrape-it

const scrapeIt = require("scrape-it");
let JsonDATABASE = [];

const mineralsArray = [ // N=29
    'amphibole',
    'aragonite',
    'asbestos',
    'augite',
    'aurichalcite',
    'autunite',
    'barium',
    'beryllium',
    'biotite',
    'calcite',
    'chlorite',
    'colemanite',
    'corundum',
    'diamond',
    'feldspar',
    'fluorite',
    'galena',
    'garnet',
    'gold',
    'graphite',
    'gypsum',
    'kaolinite',
    'mica',
    'pyrite',
    'quartz',
    'salthalite',
    'silver',
    'talc',
    'zeolites'
]
// const mineralsArray = [
//     'zeolites'
// ]
let DATABASE = [];

function minerals(mineral) {
    scrapeIt(`https://mineralseducationcoalition.org/minerals-database/${mineral}`, {
        TITLE: "h1.mec-db-entry__title",
        DESCRIPTION: {
            selector: ".entry-content p",
            eq: 0
        },
        TYPE: {
            selector: ".mec-db-entry__details-grid-cell p",
            eq: 0
        },
        MINERALCLASSIFICATION: {
            selector: ".mec-db-entry__details-grid-cell p",
            eq: 1
        },
        CHEMICALFORMULA: {
            selector: ".mec-db-entry__details-grid-cell p",
            eq: 2
        },
        STREAK: {
            selector: ".mec-db-entry__details-grid-cell p",
            eq: 3
        },
        MOHSHARDNESS: {
            selector: ".mec-db-entry__details-grid-cell p",
            eq: 4
        },
        CRYSTALSYSTEM: {
            selector: ".mec-db-entry__details-grid-cell p",
            eq: 5
        },
        COLOR: {
            selector: ".mec-db-entry__details-grid-cell p",
            eq: 7
        },
        LUSTER: {
            selector: ".mec-db-entry__details-grid-cell p",
            eq: 9
        },
        FRACTURE: {
            selector: ".mec-db-entry__details-grid-cell p",
            eq: 10
        },
        IMAGE: {
            listItem: "li.acf-image-gallery__item",
            data: {
                urlLarge: {
                    selector: "a",
                    attr: "href"
                },
                // urlSmall: {
                //     selector: "img",
                //     attr: "src"
                // }
            }
        }
    }).then(page => {
        DATABASE.push(page);
        JsonDATABASE = JSON.stringify(DATABASE);
    });
}

mineralsArray.forEach((el) => minerals(el));

setTimeout(function(){
    console.log("Our database length: ", DATABASE.length);
    console.log(JsonDATABASE);
    // for (var i = 0; i < DATABASE.length; i++) {
    //     console.log(DATABASE[i]);
    // }
}, 5000);
