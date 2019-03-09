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

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Rochambo game;
    ImageView playerImage;
    ImageView computerImage;
    TextView resultText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerImage = (ImageView) findViewById(R.id.player);
        computerImage = (ImageView) findViewById(R.id.computer);
        resultText = (TextView) findViewById(R.id.result);


    }

    /**
     * Handles click on paper button
     * @param view
     */
    public void playPaper(View view) {

        game = new Rochambo();

        //makes player move
        game.playerMakesMove(1);
        //change image according to player move
        playerImage.setImageResource(R.drawable.paper);

        computerMove();

        getResult();

        animateImages();


    }

    /**
     * Handles click on rock button
     * @param view
     */
    public void playRock(View view) {

        game = new Rochambo();

        //makes player move
        game.playerMakesMove(0);
        //change image according to player move
        playerImage.setImageResource(R.drawable.rock);

        computerMove();

        getResult();

        animateImages();
    }

    /**
     * Handles click on scissor button
     * @param view
     */
    public void playScissor(View view) {

        game = new Rochambo();

        //makes player move
        game.playerMakesMove(2);
        //change image according to player move
        playerImage.setImageResource(R.drawable.scissors);

        computerMove();

        getResult();

        animateImages();
    }

    /**
     * Handles computer move
     */
    private void computerMove() {

        //get computer move
        int computerMove= game.getGameMove();

        //change image according to computer move
        computerImage.setImageResource( computerMove==1 ? R.drawable.paper :
                computerMove==0 ? R.drawable.rock : R.drawable.scissors);
    }


    /**
     * Print results
     */
    private void getResult() {

        //get result
        int result = game.winLoseOrDraw();

        //Print results
        resultText.setText(result == 1 ? "YOU WIN" :
                result == 2 ? "YOU LOSE" : "DRAW");

    }

    /**
     * Animate images
     */
    private void animateImages()
    {
        // you can animate any prop that there is a setter for
        playerImage.setRotationX(0f);

        ObjectAnimator animatorPlayer = ObjectAnimator.ofFloat(playerImage,
                "rotationX", 0f, 360f)
                .setDuration(500);

        ObjectAnimator animatorGame = ObjectAnimator.ofFloat(computerImage,
                "rotationY", 0f, 360f)
                .setDuration(500);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorGame, animatorPlayer);
        set.setInterpolator(new AnticipateOvershootInterpolator());
        set.start();



    }



}
