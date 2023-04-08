# Triangulacion

Hello, this program locates the 2d coordinates of a ship in space according to its distance from 3 different satellites.

To achieve this, the position of the ship is triangulated using GPS, for this a mathematical method called trilateration is used.

The ship must send the correct distances that it has with respect to each satellite so that its coordinates are found, that is why the "Distance" function is used, which calculates the module of the vector that is formed between each satellite with the ship using the coordinates.

To solve this problem, analytical geometry is used to calculate the intersections between two circles, addition and subtraction of polynomials and the quadratic formula.

## Usage

To use this program you only need to modify the coordinates of the satellites or the ship.

Keep in mind that for the ship it does not send its location to the satellites, only the distance and for this it is necessary to send it correctly to find the ship.

You can also use the program by modifying the third parameter of the "GeneralEquation" objects of each satellite, which is the distance or radius, remember that if you modify the distance by one in which its intersection with the 3 satellites is mathematically impossible, the coordinates of the ship could not be found.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)