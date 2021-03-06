package com.base.game;

import com.base.engine.GameContainer;
import com.base.engine.Image;
import com.base.engine.Renderer;
import com.base.engine.Vector2f;

import javax.swing.*;

public class SubtitleTrigger extends GameObject
{
	private float dX, dY;

	transient Game game;
	static String subtitleList[];
	static int counter = 0;

	public SubtitleTrigger(int x, int y)
	{
		super.tilePos = new Vector2f(x,y);
		tag = "subtitle_trigger";
	}

	public static void setSubtitleList(String[] subtitleList) {
		SubtitleTrigger.subtitleList = subtitleList;
		counter = 0;
	}

	@Override
	public void update(GameContainer gc, float delta, Level level)
	{
		game = Game.getInstance();
		Physics.addObject(this);
	}

	@Override
	public void render(GameContainer gc, Renderer r, Level level)
	{
	}

	@Override
	public void collide(GameObject go)
	{
		if(go.getTag().equals("player"))
		{
			game.showSubtitle(subtitleList[counter++]);
			setDead(true);
		}
	}

	public static void reset() {
		counter = 0;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		SubtitleTrigger.counter = counter;
	}

	@Override
	public Vector2f getUpperLeft() {
		return new Vector2f(tilePos.getX(), 0);
	}

	@Override
	public Vector2f getLowerRight() {
		return new Vector2f(tilePos.getX(), 24);
	}
}
