package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainMenuScreen implements Screen {
	final Drop game;
	static private int WIDTH = 800;
	static private int HEIGHT = 480;
	Texture dropImagePlay, dropImageSair, dropEscudo;

	private SpriteBatch batch;


	
	OrthographicCamera camera;
	
	public MainMenuScreen(final Drop passed_game) {
		game = passed_game;

		batch = new SpriteBatch();
		
		dropImagePlay = new Texture(Gdx.files.internal("Play1.png"));
		dropImageSair = new Texture(Gdx.files.internal("sair1.png"));

		dropEscudo = new Texture(Gdx.files.internal("escudo.png"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
	}
	
	@Override
	public void render(float delta) {
		input();
		Gdx.gl.glClearColor(0, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		game.batch.draw(dropImagePlay, 150, 75);
		game.batch.draw(dropImageSair, 550, 75);
		game.batch.draw(dropEscudo, 200, 200);
		game.batch.end();
	}

	private void input(){
		if(Gdx.input.justTouched()){
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();
			verifica_click(x, y);
		}
	}

	private void verifica_click(int X, int Y){
		if(X > 141 && X < 204 && Y > 371 && Y < 404){ //play
			game.setScreen(new GameScreen(game));
		}else if(X > 466 && X < 523 && Y > 370 && Y < 403){ //sair
			//dispose();
		}
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void dispose() {
		dropImagePlay.dispose();
		dropImageSair.dispose();
		dropEscudo.dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
}
