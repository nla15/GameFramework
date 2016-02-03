package snake.entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.base.Drawable;
import gameframework.base.Overlappable;
import gameframework.game.GameEntity;
import gameframework.game.GameMovable;
import gameframework.game.SpriteManager;
import gameframework.game.SpriteManagerDefaultImpl;

public abstract class Snake extends GameMovable implements Drawable, GameEntity, Overlappable{
	
	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 16;
	protected boolean movable = true;
	protected boolean vulnerable = false;
	protected int vulnerableTimer = 0;
	protected String lastMove = "";
	protected String currentMove = "";
	protected Point lastPosition=new Point(14 * 16, 17 * 16);

	public Snake(Canvas defaultCanvas) {
		spriteManager = new SpriteManagerDefaultImpl("images/snake.gif",
				defaultCanvas, RENDERING_SIZE, 1);
		
		spriteManager.setTypes(
				//
				"head-right",
				"head-down", 
				"head-left", 
				"head-up", //
				"horizontal", 
				"vertical", 
				"turn-up-right", 
				"turn-up-left", 
				"turn-down-left", 
				"turn-down-right",// 
				"tail-down",
				"tail-left", 
				"tail-up", 
				"tail-right");
	}

	@Override
	public Rectangle getBoundingBox() {
		return (new Rectangle(0, 0, RENDERING_SIZE, RENDERING_SIZE));
	}
	/*
	@Override
	public void draw(Graphics g) {
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();
		movable = true;
		
		if (tmp.getX() == 1) {
			spriteType += "head-right";
		} else if (tmp.getX() == -1) {
			spriteType += "head-left";
		} else if (tmp.getY() == 1) {
			spriteType += "head-down";
		} else if (tmp.getY() == -1) {
			spriteType += "head-up";
		} else { spriteType += "head-right";
			spriteManager.reset();
			movable = false;
		}
		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());		
	}
	@Override
	public void oneStepMoveAddedBehavior() {
		if (movable) {
			spriteManager.increment();		
		}	
	}
	*/
	public String getLastMove() {
		return lastMove;
	}
	
	public void setLastMove(String lastMove) {
		this.lastMove = lastMove;
	}

	public String getCurrentMove() {
		return currentMove;
	}

	public void setCurrentMove(String currentMove) {
		this.currentMove = currentMove;
	}
}
