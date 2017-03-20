// code author https://github.com/IonicaBizau/scrape-it

const scrapeIt = require('scrape-it');

// Promise interface
scrapeIt("https://mineralseducationcoalition.org/minerals-database/andesite/", {
    dataBaseEntry: ".mec-db-entry__title",
    // specimenInfo: ".mec-db-entry__details-grid-cell",
    listItem: ".acf-image-gallery__item",
    data: {
        href: ".acf-image-gallery__link wwm_socialshare_imagewrapper",
    }
}).then(page => {
    console.log(page);
});


<a href="https://mineralseducationcoalition.org/wp-content/uploads/andesite_366069737.jpg" class="acf-image-gallery__link wwm_socialshare_imagewrapper" data-featherlight="image" style="width: 101px;">
    <img src="https://mineralseducationcoalition.org/wp-content/uploads/andesite_366069737-150x150.jpg" alt="" class="acf-image-gallery__image mec-share-image"><ul class="wwm_social_share wwm_top_left" style="display: none;"><li class="wwm_facebook"></li><li class="wwm_twitter"></li><li class="wwm_pinit"></li></ul>
</a>
