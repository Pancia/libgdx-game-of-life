package com.pancia.gameoflife;

import com.badlogic.gdx.math.Vector2;

public class World {

    private final int maxSize;
    private Cell[][] gameBoard;

    public World() {
        gameBoard = new Cell[10][10];
        createWorld(10);
        maxSize = 10;
    }

    private void createWorld(int maxSize) {
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                gameBoard[i][j] = new Cell(new Vector2(i, j));
            }
        }
        gameBoard[0][0].setAlive(true);
        gameBoard[1][1].setAlive(true);
        gameBoard[1][2].setAlive(true);
        gameBoard[2][1].setAlive(true);
        gameBoard[0][2].setAlive(true);
    }

    public Cell[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Cell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void update() {
        Cell[][] newGameBoard = new Cell[this.maxSize][this.maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                newGameBoard[i][j] = new Cell(new Vector2(i, j))
                        .setAlive(this.gameBoard[i][j].isAlive());
            }
        }
        for (int i = 0; i < this.maxSize; i++) {
            for (int j = 0; j < this.maxSize; j++) {
                int numOfNeighbors = getNumOfNeighbors(i, j);
                if (this.gameBoard[i][j].isAlive()) {
                    if (numOfNeighbors < 2 || numOfNeighbors > 3)
                        newGameBoard[i][j] = new Cell(new Vector2(i, j))
                                .setAlive(false);
                } else {
                    if (numOfNeighbors == 3)
                        newGameBoard[i][j] = new Cell(new Vector2(i, j))
                                .setAlive(true);
                }
            }
        }
        this.gameBoard = newGameBoard;
    }

    private int getNumOfNeighbors(int x, int y) {
        int neighborCount = 0;
        int maxPosition = this.maxSize-1;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                int x_i = x+i; int y_j = y+j;
                if (x_i < 0)
                    x_i = maxPosition;
                else if (x_i > maxPosition)
                    x_i = 0;
                if (y_j < 0)
                    y_j = maxPosition;
                else if (y_j > maxPosition)
                    y_j = 0;
                if (this.gameBoard[x_i][y_j].isAlive()) neighborCount++;
            }
        }
        return neighborCount;
    }
}
