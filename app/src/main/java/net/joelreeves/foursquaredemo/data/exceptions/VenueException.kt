package net.joelreeves.foursquaredemo.data.exceptions

import java.lang.RuntimeException

open class VenueException(message: String) : RuntimeException(message)

class VenueParamException : VenueException("required parameter missing or malformed")

class VenueAuthException : VenueException("oauth token missing or invalid")

class VenueEndpointException : VenueException("requested endpoint does not exist")

class VenueUnauthorizedException : VenueException("user not authorized to see information")

class VenueServerException : VenueException("server is unavailable")
