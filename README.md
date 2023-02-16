# 16/02/23 Lab AirlineAPI

In this exercise I revisited the airline booking system. Last time I built a CLI and managed the details of passengers and flights from the terminal but in the real world an airline wouldn't manage things this way. Instead they would have an API with routes available to make bookings through.

A real airline would have **much** more security in place around its API but for now I have assumed that the user is logged in and has permission to be interacting with mine. I recreated all the functionality of the CLI project using Spring, with some extras which I couldn't previously include.

## MVP

Designed and built an API with the same CRUD functionality as the CLI project. There was a many-to-many relationship between a `passengers` table and a `flights` table. The `passengers` table has columns for:

- `id`
- `name`
- either `phoneNumber` or `emailAddress`

The `flights` table has columns for:

- `id`
- `destination`
- `capacity`
- `departureDate`
- `departureTime`

My API included routes enabling the user to:

- Add details of a new flight
- Display all available flights
- Display details of a specific flight
- Add a new passenger
- Display details of all passengers
- Display details of a specific passenger
- Book a passenger on to a flight
- Cancel a flight

A `DataLoader` class could have alternatively been helpful to seed the database with some flights and passengers.

## Extensions

- Add functionality to filter flights by destination
- Prevent a passenger being booked on a flight which is full
- If you aren't already doing so, refactor the `departureDate` and `departureTime` properties to use one of the available datatypes for handling dates and times.
- Return `ResponseEntity` objects with appropriate status codes if the user attempts an invalid action, eg. return a `400` error if filtering by a destination which doesn't exist
