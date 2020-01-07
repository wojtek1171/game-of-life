package gol;

import java.util.Arrays;

public class World {

    private int size;
    private int seed;
    private String name;
    private int generation = 1;
    private String[][] matrix;



    public World(String name, int size, int seed) {

        this.size = size;
        this.seed = seed;
        this.name = name;

        matrix = new String[size][size];

    }

    public int getAliveCellsNumber() {

        int counter = 0;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(matrix[i][j].equals("O")){
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return "World{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public int getSize() {
        return size;
    }

    public int getSeed() {
        return seed;
    }

    public String getName() {
        return name;
    }

    public int getGeneration() {
        return generation;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public void setMatrixCell (int i, int j, String value) {
        this.matrix[i][j] = value;
    }
}
