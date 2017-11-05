package com.geek.rpg.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Monster extends AbstractUnit {
    private Hero target;
    private float sleepTimer;

    public Monster(RpgGame game, Vector2 position, Hero target) {
        super(game, position, new Texture("skeleton.png"));
        this.target = target;
        this.name = "Skelet";
        this.maxHp = 50;
        this.hp = this.maxHp;
        this.level = 1;
        this.strength = 12;
        this.dexterity = 5;
        this.endurance = 5;
        this.spellpower = 0;
        this.defence = 1;
        this.flip = true;
    }

    @Override
    public void getTurn() {
        super.getTurn();
        sleepTimer = 1.0f;
    }

    public boolean ai(float dt) {
        if (sleepTimer > 0.0f) {
            sleepTimer -= dt;
            return false;
        }

        //randomly decide what action to take
        int decision = (int) (Math.random() * 3);
        switch (decision) {
            case 0:
                meleeAttack(target);
                break;
            case 1:
                defend();
                break;
            case 2:
                heal();
                break;
        }
        return true;
    }
}
