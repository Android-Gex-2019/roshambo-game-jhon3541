/**
 * @file
 * @author Jhon Romero
 * @version 1.0
 *
 *
 * @section DESCRIPTION
 * Roshambo Assignment
 *
 *
 * @section LICENSE
 *
 *
 * Copyright 2019
 * Permission to use, copy, modify, and/or distribute this software for
 * any purpose with or without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 * @section Academic Integrity
 * I certify that this work is solely my own and complies with
 * NBCC Academic Integrity Policy (policy 1111)
 */

package com.example.rockscissorspaper;

import android.os.Build;

import java.util.Random;

public class Rochambo {

    public static final int ROCK = 0;
    public static final int PAPER = 1;
    public static final int SCISSOR = 2;
    public static final int NONE = 3;

    public static final int WIN = 1;
    public static final int LOSE = 2;
    public static final int DRAW = 0;


    private int gameMove;
    private int playerMove;
    private Random rand;


    public Rochambo() {
        rand = new Random();
        gameMove = rand.nextInt(2);
        playerMove = NONE;
    }

    /**
     * Player chooses their next move, the game immediately follows and
     * makes it's next move. Use winLoseOrDraw() to see the outcome
     *
     * @param playerMove  ROCK, PAPER, or SCISSOR are valid arguments
     */
    public void playerMakesMove(int playerMove) {


        this.playerMove = playerMove;
        gameMakesMove();
    }

    /**
     * The game makes a random choice of ROCK, PAPER, or SCISSOR
     */
    private void gameMakesMove() {
        gameMove = rand.nextInt(3);
    }

    public int getGameMove() {
        return gameMove;
    }

    public int getPlayerMove() {
        return playerMove;
    }

    public int winLoseOrDraw() {

        if (playerMove == ROCK) {
            if (gameMove == ROCK) {
                return DRAW;
            } else if (gameMove == PAPER) {
                return LOSE;
            } else {
                return WIN;
            }
        } else if (playerMove == PAPER ) {
            if (gameMove == PAPER) {
                return DRAW;
            } else if (gameMove == SCISSOR) {
                return LOSE;
            } else {
                return WIN;
            }
        } else if (playerMove == SCISSOR ) {
            if (gameMove == SCISSOR) {
                return DRAW;
            } else if (gameMove == ROCK) {
                return LOSE;
            } else {
                return WIN;
            }
        }

        return DRAW; //shouldn't get here
    }
}
