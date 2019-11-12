# FourSquareDemo

App demonstrates using the [Foursquare API](https://developer.foursquare.com/docs/api) to display a list of venues.
 
The app has the following features:
 - Using the location icon on the toolbar, the app attemps to obtain the device's location and displays nearby venues.
 - Using the search icon on the toolbarm, you can type in a location and displays venues in/near that location.
 - Clicking on a venue in the list will take you to a detail screen (using a nice fade in/out animation) that displays more information about the venue.

The app uses the following technologies:
- **Dagger 2** for dependency injection
- **Retrofit** to make HTTP requests from the Foursquare API
- **RxJava** to asynchronously make the api calls and to transform the venue data into POJO classes 
- **MVVM and LiveData** to seperate the app data from the UI code
- **Picasso** to load the venue images
