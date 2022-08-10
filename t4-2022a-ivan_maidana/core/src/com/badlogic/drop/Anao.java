package com.badlogic.drop;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;


public class Anao {
    private Texture anao;
    private Array<Rectangle> listaDeAnoes;
    private long ultimoAnaoAtacar;
    private int inimigosAbatidos;
	private int inimigosAvancaram;
    private Sound somEspada;

    public Anao(){
        somEspada = Gdx.audio.newSound(Gdx.files.internal("Som de espada.mp3"));
        anao = new Texture(Gdx.files.internal("AnaoPequeno.png"));
        listaDeAnoes = new Array<Rectangle>();
		CriaAnoes();
    }
    public int getinimigosAvancaram()
    {
        return this.inimigosAvancaram;
    }
    public void setinimigosAvancaram(int reseta)
    {
         this.inimigosAvancaram = reseta;
    }
    public int getinimigosAbatidos()
    {
        return this.inimigosAbatidos;
    }
    public void setinimigosAbatidos(int reseta)
    {
         this.inimigosAbatidos = reseta;
    }

    public void desenha_anao(final Drop game){
        for (Rectangle raindrop: listaDeAnoes) {
			game.batch.draw(anao, raindrop.x, raindrop.y);
		}
    }

    public void anaoMovimento(Rectangle retanguloCavaleiro){
        if (TimeUtils.nanoTime() - ultimoAnaoAtacar > 1000000000) 
			CriaAnoes();
        Iterator<Rectangle> iter = listaDeAnoes.iterator();
		while (iter.hasNext()) {
			Rectangle raindrop = iter.next();
			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
			if (raindrop.y + raindrop.height < 0){
				iter.remove();
				inimigosAvancaram++;
			}
			if (raindrop.overlaps(retanguloCavaleiro)) {
				inimigosAbatidos++;
				somEspada.play();
				iter.remove();
			}
		}
    }

    private void CriaAnoes() {
		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, 800-64);
		raindrop.y = 480;
		raindrop.width = 64;
		raindrop.height = 64;
		listaDeAnoes.add(raindrop);
		ultimoAnaoAtacar = TimeUtils.nanoTime();
	}



    public void dispose(){
       anao.dispose();
       somEspada.dispose();
    }
    
}
