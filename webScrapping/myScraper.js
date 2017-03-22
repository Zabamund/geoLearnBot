// code modified from Manel Pavon and https://github.com/IonicaBizau/scrape-it

const scrapeIt = require("scrape-it");
let JsonDATABASE = [];

const mineralsArray = [ // N=29
    // 'amphibole',
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
    // 'galena',
    'garnet',
    'gold',
    'graphite',
    'gypsum',
    'kaolinite',
    // 'mica',
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
let titleArray = [];
let descriptionArray = [];
let typeArray = [];
let mineralClassificationArray = [];
let chemicalFormulaArray = [];
let streakArray = [];
let mohsHardnessArray = [];
let crystalSystemArray = [];
let colorArray = [];
let lusterArray = [];
let fractureArray = [];
let imageArray = [];

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
                // urlLarge: {
                //     selector: "a",
                //     attr: "href"
                // },
                urlSmall: {
                    selector: "img",
                    attr: "src"
                }
            }
        }
    }).then(page => {
        DATABASE.push(page);
        JsonDATABASE = JSON.stringify(DATABASE);
        titleArray.push(page.TITLE);
        descriptionArray.push(page.DESCRIPTION);
        typeArray.push(page.TYPE);
        mineralClassificationArray.push(page.MINERALCLASSIFICATION);
        chemicalFormulaArray.push(page.CHEMICALFORMULA);
        streakArray.push(page.STREAK);
        mohsHardnessArray.push(page.MOHSHARDNESS);
        crystalSystemArray.push(page.CRYSTALSYSTEM);
        colorArray.push(page.COLOR);
        lusterArray.push(page.LUSTER);
        fractureArray.push(page.FRACTURE);
        imageArray.push(page.IMAGE[0].urlSmall);
    });
}

mineralsArray.forEach((el) => minerals(el));

setTimeout(function(){
    // console.log(DATABASE);
    // console.log(JsonDATABASE);
    // for (var i = 0; i < DATABASE.length; i++) {
    //     console.log(DATABASE[i]);
    // }
    console.log("=================================================================");
    console.log("Our database length: ", DATABASE.length);
    console.log("=================================================================");
    console.log('titleArray ', titleArray);
    console.log('DESCRIPTIONARRAY', descriptionArray)
    console.log('TYPEARRAY', typeArray)
    console.log('MINERALCLASSIFICATIONARRAY', mineralClassificationArray)
    console.log('CHEMICALFORMULAARRAY', chemicalFormulaArray)
    console.log('STREAKARRAY', streakArray)
    console.log('MOHSHARDNESSARRAY', mohsHardnessArray)
    console.log('CRYSTALSYSTEMARRAY', crystalSystemArray)
    console.log('COLORARRAY', colorArray)
    console.log('LUSTERARRAY', lusterArray)
    console.log('FRACTUREARRAY', fractureArray)
    console.log('IMAGEARRAY', imageArray)
    // console.log("=================================================================");
    // console.log("image stuff");
    // console.log("=================================================================");
    // for (var i = 0; i < imageArray.length; i++) {
    //     console.log('imageArray[' + i + '][0]: ' + imageArray[i][0]);
    // }
    // for (var i = 0; i < DATABASE.length; i++) {
    //     console.log('DATABASE[i].IMAGE[0]: ', DATABASE[i].IMAGE[0]);
    // }
}, 5000);
