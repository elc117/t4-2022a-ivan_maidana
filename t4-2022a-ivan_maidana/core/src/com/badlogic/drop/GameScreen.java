package com.badlogic.drop;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen {
	final Drop game;;
	private Anao anao;
	private Cavaleiro cavaleiro;
	private Music musicaFundo;
	private OrthographicCamera camera;
	private SpriteBatch batch;
     Vector3 touchPos;
	
	public GameScreen(final Drop passed_game) {
		game = passed_game;

		cavaleiro = new Cavaleiro();
		anao = new Anao();

		musicaFundo = Gdx.audio.newMusic(Gdx.files.internal("Musica batalha Medieval.mp3"));
		
		musicaFundo.setLooping(true);
		musicaFundo.play();
		
		// instancia a camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		touchPos = new Vector3();
		
		batch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		//limpar a tela com uma cor cinza
		Gdx.gl.glClearColor(0.25f, 0.25f,0.25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();

		cavaleiro.desenha_cavaleiro(game);
		anao.desenha_anao(game);

		game.font.draw(game.batch, "Pontos: " + anao.getinimigosAbatidos(), 5, 450);
		game.font.draw(game.batch, "Avançaram: " + anao.getinimigosAvancaram(), 5, 380);

		

		if(anao.getinimigosAvancaram() >= 10){
			game.setScreen(new FimJogoScreen(game));
		}

		game.batch.end();

		cavaleiro.movimento();
		anao.anaoMovimento(cavaleiro.getCavaleiro());
	}

	
	
	@Override
	public void dispose(){
		musicaFundo.dispose();
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		musicaFundo.play();
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
