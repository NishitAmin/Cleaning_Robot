
import becker.robots.*;

/**
 * You must program mark to go inside the house and
 * pick up all the Things that are at Street 1, avenue 0. You do not know how
 * many Things are there. If there are an odd number of Things in the backpack
 * place the things along avenue 2 starting at street 2. If there are an even
 * number of Things in the backpack, place the things along street 2 starting at
 * avenue 2.
 */
public class GetAllThings {

    public static void main(String[] args) {

        // Create the city
        City ny = new City();

        createSetup(ny);

        // Create our robot, mark
        Robot mark = new Robot(ny, 0, 6, Direction.WEST);
        
        // Go to Street 1 Avenue 0
        mark.turnLeft();
        mark.move();
        mark.move();
        for (int i = 1; i <= 3; i++) {
            mark.turnLeft();
        }
        for (int i = 1; i <= 5; i++) {
            mark.move();
        }
        for (int i = 1; i <= 3; i++) {
            mark.turnLeft();
        }
        mark.move();
        mark.move();
        mark.turnLeft();
        mark.move();
        mark.turnLeft();
        mark.move();
        // Robot will check if it can pick thing up 
        if (mark.canPickThing()) {
            // Robot will pick thing up
            mark.pickThing();
        }
        if (mark.canPickThing()) {
            mark.pickThing();
        }
        if (mark.canPickThing()) {
            mark.pickThing();
        }
        if (mark.canPickThing()) {
            mark.pickThing();
        }
        // Go to Street 2 Avenue 2
        for (int i = 1; i <= 2; i++) {
            mark.turnLeft();
        }
        mark.move();
        for (int i = 1; i <= 3; i++) {
            mark.turnLeft();
        }
        mark.move();
        for (int i = 1; i <= 3; i++) {
            mark.turnLeft();
        }
        mark.move();
        mark.move();
        mark.turnLeft();
        mark.move();
        // Robot will count the things in backpack and if the number of things is even then the following loop will execute
        if (mark.countThingsInBackpack() % 2 == 0) {
            // Robot will put the thing
            mark.putThing();
            mark.move();
            if (mark.countThingsInBackpack() > 0) {
                mark.putThing();
                mark.move();
            }
            if (mark.countThingsInBackpack() > 0) {
                mark.putThing();
                mark.move();
            }
            if (mark.countThingsInBackpack() > 0) {
                mark.putThing();
                mark.move();
            }
            //  Robot will count the things in backpack and if the number of things is odd then the following loop will execute
        } else {
            for (int i = 1; i <= 3; i++) {
                mark.turnLeft();
            }
            mark.putThing();
            mark.move();
            if (mark.countThingsInBackpack() > 0) {
                mark.putThing();
                mark.move();
            }
            if (mark.countThingsInBackpack() > 0) {
                mark.putThing();
                mark.move();
            }
        }
    }

    /**
     * Create the setup. DO NOT MODIFY
     */
    private static void createSetup(City city) {

        // Create the house
        Wall blockStr0 = new Wall(city, 0, 0, Direction.WEST);
        Wall blockStr1 = new Wall(city, 1, 0, Direction.WEST);
        Wall blockAve1 = new Wall(city, 1, 0, Direction.SOUTH);
        Wall blockStr0E = new Wall(city, 0, 1, Direction.EAST);
        Wall blockStr1E = new Wall(city, 1, 1, Direction.EAST);
        Wall blockAve2N = new Wall(city, 0, 0, Direction.NORTH);
        Wall blockAve4N = new Wall(city, 0, 1, Direction.NORTH);
        Wall blockAve2E = new Wall(city, 1, 0, Direction.EAST);

        // create a random # between 1 and 4
        int number = (int) (Math.random() * 3) + 1;

        // print out to console to see how many things (for degugging)
        System.out.println(number);

        // create an array of 4 Things (some will be null if number < 4)
        Thing[] things = new Thing[4];

        // use variables for street and avenue 
        int street = 1;
        int avenue = 0;

        // create "number" many things at the intersection street, avenue
        for (int i = 0; i < number; i++) {
            things[i] = new Thing(city, street, avenue);

        }

    }
}
