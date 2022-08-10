package com.badlogic.drop;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class FimJogoScreen implements Screen {
	final Drop game;
	private Texture vocePerdeu;
	private Texture jogarNovamente;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Vector3 touchPos;
    private Anao anao;
	
	public FimJogoScreen(final Drop passed_game) {
		game = passed_game; 

		jogarNovamente = new Texture(Gdx.files.internal("jogarNovamente.png"));
		vocePerdeu = new Texture(Gdx.files.internal("VocePerdeu.png"));

		anao = new Anao();
		// instancia a camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		touchPos = new Vector3();
		
		batch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		jogarNovamente();
		Gdx.gl.glClearColor(0.25f, 0.25f,0.25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();

			game.batch.draw(vocePerdeu, 270, 300 );
			game.batch.draw(jogarNovamente, 220, 200);
			
		game.batch.end();
	}

	
	private void jogarNovamente(){
		if(Gdx.input.justTouched()){
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();
			if(x > 175 && x < 411 && y > 227 && y < 277){
				anao.setinimigosAvancaram(0);
                anao.setinimigosAbatidos(0);
               game.setScreen(new GameScreen(game));
			}
		}
	}

	
	
	@Override
	public void dispose(){
		batch.dispose();
        vocePerdeu.dispose();;
	    jogarNovamente.dispose();;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}
