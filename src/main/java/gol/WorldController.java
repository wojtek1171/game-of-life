package gol;

import java.io.IOException;
import java.util.Random;

public class WorldController {

    private World world;

    public WorldController(World world) {
        this.world = world;
    }

    public void createWorld() {

        Random random = new Random(world.getSeed());

        for (int i = 0; i < world.getSize(); i++) {
            for (int j = 0; j < world.getSize(); j++) {
                if (random.nextBoolean() == true) {
                    world.getMatrix()[i][j] = "O";
                } else {
                    world.getMatrix()[i][j] = " ";
                }
            }
        }
    }

    public void displayWorld() {

        System.out.println("Name: " + world.getName());
        System.out.println("Generation #" + world.getGeneration());
        System.out.println("Alive: " + world.getAliveCellsNumber());
        System.out.println();

        for (int i = 0; i < world.getSize(); i++) {
            for (int j = 0; j < world.getSize(); j++) {
                System.out.print(world.getMatrix()[i][j]);
            }
            System.out.println();
        }


    }

    public void generate() {

        int[][] count = new int[world.getSize()][world.getSize()];

        for (int i = 0; i < world.getSize(); i++) {
            for (int j = 0; j < world.getSize(); j++) {
                //Checking neighbours of a cell including neighbours beside borders of an array
                //north-west
                if (isAlive(world.getMatrix()[(i - 1 + world.getSize()) % world.getSize()][(j - 1 + world.getSize()) % world.getSize()])) {
                    count[i][j]++;
                }
                //north
                if (isAlive(world.getMatrix()[(i - 1 + world.getSize()) % world.getSize()][j])) {
                    count[i][j]++;
                }
                //north-east
                if (isAlive(world.getMatrix()[(i - 1 + world.getSize()) % world.getSize()][(j + 1 + world.getSize()) % world.getSize()])) {
                    count[i][j]++;
                }
                //west
                if (isAlive(world.getMatrix()[i][(j - 1 + world.getSize()) % world.getSize()])) {
                    count[i][j]++;
                }
                //east
                if (isAlive(world.getMatrix()[i][(j + 1 + world.getSize()) % world.getSize()])) {
                    count[i][j]++;
                }
                //south-east
                if (isAlive(world.getMatrix()[(i + 1 + world.getSize()) % world.getSize()][(j - 1 + world.getSize()) % world.getSize()])) {
                    count[i][j]++;
                }
                //south
                if (isAlive(world.getMatrix()[(i + 1 + world.getSize()) % world.getSize()][j])) {
                    count[i][j]++;
                }
                //south-west
                if (isAlive(world.getMatrix()[(i + 1 + world.getSize()) % world.getSize()][(j + 1 + world.getSize()) % world.getSize()])) {
                    count[i][j]++;
                }

            }

        }

        for (int i = 0; i < world.getSize(); i++) {
            for (int j = 0; j < world.getSize(); j++) {

                if (world.getMatrix()[i][j].equals("O")) {

                    if (count[i][j] == 2 || count[i][j] == 3) {
                        world.setMatrixCell(i, j, "O");
                    } else {
                        world.setMatrixCell(i, j, " ");
                    }
                }

                if (world.getMatrix()[i][j].equals(" ") && count[i][j] == 3) {
                    world.setMatrixCell(i, j, "O");
                }

            }
        }

        world.setGeneration(world.getGeneration() + 1);
    }

    public World evolve(int generationNumber) {

        for (int i = 0; i < generationNumber; i++) {
            generate();
        }
        return world;
    }

    public void evolveWithDisplaying(int generationNumber) throws InterruptedException {


        for (int i = 0; i < generationNumber; i++) {
            generate();
            displayWorld();
            Thread.sleep(1000);
            clrscr();


        }

    }

    public boolean isAlive(String liveOrNot) {
        if (liveOrNot.equals("O")) {
            return true;
        } else {
            return false;
        }
    }

    public static void clrscr(){

        //Clears Screen in java

        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {}

    }

}
