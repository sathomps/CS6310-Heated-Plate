CS6310-Heated-Plate
===================

# [Instructions](https://s3.amazonaws.com/content.udacity-data.com/courses/gt-cs6310/projects/project1/project1.html)

# Programs
```
      // Create arrays oldPlate and newPlate with linear dimension d
      //   plus two extra rows and columns to hold edge temperatures
      oldPlate = new double[d + 2][d + 2];
      newPlate = new double[d + 2][d + 2];

      // Initialize the temperatures of the edge values and the plate itself
      initialize(oldPlate, top, bot, left, right);
      initialize(newPlate, top, bot, left, right);

      // Loop until exit criteria are met, updating each newPlate cell from the
      //   average temperatures of the corresponding neighbors in oldPlate
      while (! done()) {
        for (int i = 1; i <= d; i++) {
          for (int j = 1; j <= d; j++) {
            newPlate[i][j] = (oldPlate[i + 1][j] + oldPlate[i - 1][j] +
                              oldPlate[i][j + 1] + oldPlate[i][j - 1]) / 4.0;
          }
        }
        // Swap the plates and continue
        swap(oldPlate, newPlate);
      }

```
* The simple algorithm described above where all computations are performed in double precision using a two-dimensional array of doubles to represent the plate (Tpdahp)
* The same algorithm using floating point computations on an array of floats (Tpfahp)
* The same algorithm using floating point computations on an array of Floats (Twfahp)
* The algorithm without using arrays. Instead, each lattice point should be represented using an object that has attributes referring to each of its four neighboring lattice-point objects. Use doubles to hold temperature values (Tpdohp)
* A GUI version that enables the user to execute any of the four previous versions and to see a visualization of the results (Gallhp)

```
javac Gallhp/Demo.java
java <packageName>.Demo -d # -l # -r # -t # -b #
```

# [Design Study Report](https://github.com/sathomps/CS6310-Heated-Plate/wiki)


# Contributors

