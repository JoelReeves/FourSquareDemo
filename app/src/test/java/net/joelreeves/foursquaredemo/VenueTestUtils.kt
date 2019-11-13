package net.joelreeves.foursquaredemo

import net.joelreeves.foursquaredemo.data.models.venuemodel.*

object VenueTestUtils {

    fun getVenue(): Venue {
        return Venue(
            id = "1",
            name = "Franklin Institute",
            contact = Contact("2154481200", "215-448-1200"),
            location = Location("222 North 20th Street", 39.9582f, 75.1731f, emptyList(),
                "19103", "", "Philadelphia", "PA", "United States", emptyList()),
            canonicalUrl = "",
            categories = emptyList(),
            verified = true,
            stats = Stats(10),
            url = "https://www.fi.edu/",
            price = Price(1, "test message", ""),
            likes = Likes(500, emptyList(), ""),
            dislike = false,
            ok = true,
            rating = 10.0f,
            ratingColor = "FFFFFF",
            ratingSignals = 5,
            allowMenuUrlEdit = false,
            beenHere = BeenHere(100, 0, true, 50),
            specials = Specials(3, emptyList()),
            photos = Photos(25, emptyList()),
            reasons = Reasons(2, emptyList()),
            description = "Founded in honor of America’s first scientist, Benjamin Franklin, " +
                    "The Franklin Institute is one of the oldest and premier centers of science " +
                    "education and development in the country",
            hereNow = HereNow(300, "", emptyList()),
            createdAt = 12345,
            tips = Tips(40, emptyList()),
            shortUrl = "",
            timeZone = "EST",
            listed = Listed(5, emptyList()),
            hours = Hours("", RichStatus(emptyList(), ""), true, false, emptyList(), emptyList()),
            pageUpdates = PageUpdates(5, emptyList()),
            inbox = Inbox(3, emptyList()),
            attributes = Attributes(emptyList()),
            bestPhoto = BestPhoto("", 0, Source("", ""), "https://www.fi.edu/ben/", ".png", 300, 300, ""),
            distance = 3456
        )
    }
}