package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Cavaleiro{
    private Texture cavaleiro;
    private Rectangle retanguloCavaleiro;

    public Cavaleiro(){
        cavaleiro = new Texture(Gdx.files.internal("CavaleiroPequeno.png"));
        retanguloCavaleiro = new Rectangle();
		// Possiçao iniciais do cavaleiro 
		retanguloCavaleiro.x = 800 / 2 - retanguloCavaleiro.width / 2;  
		retanguloCavaleiro.y = 20;
		retanguloCavaleiro.width = 64;
		retanguloCavaleiro.height = 64;
    }

    public Rectangle getCavaleiro()
    {
        return this.retanguloCavaleiro;
    }

    public void desenha_cavaleiro(final Drop game){
        game.batch.draw(cavaleiro, retanguloCavaleiro.x, retanguloCavaleiro.y);
    }

    public void movimento(){
        if (Gdx.input.isKeyPressed(Keys.A)) 
			retanguloCavaleiro.x -= 250 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.D)) 
			retanguloCavaleiro.x += 250 * Gdx.graphics.getDeltaTime();
		if (retanguloCavaleiro.x < 0) 
			retanguloCavaleiro.x = 0;
		if (retanguloCavaleiro.x > 800 - retanguloCavaleiro.width) 
			retanguloCavaleiro.x = 800 - retanguloCavaleiro.width;

		if (Gdx.input.isKeyPressed(Keys.W)) 
			retanguloCavaleiro.y += 250 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.S)) 
			retanguloCavaleiro.y -= 250 * Gdx.graphics.getDeltaTime();
			if (retanguloCavaleiro.y < 0) 
			retanguloCavaleiro.y = 0;
		if (retanguloCavaleiro.y > 480 - retanguloCavaleiro.width) 
			retanguloCavaleiro.y = 480 - retanguloCavaleiro.width;
    }

    public void dispose(){
        cavaleiro.dispose();
    }

}    

