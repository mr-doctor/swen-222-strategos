package strategos.units;


import strategos.*;
import strategos.behaviour.Behaviour;


public interface Unit {

    void setBehaviour(Behaviour behaviour);

    public Behaviour getBehaviour();

    MapLocation getPosition();

    void setPosition(MapLocation position);

    void turnTick();

    void wary();

    void entrench();

    void charge();

    boolean move(Direction direction);

    int attack(Unit enemy);

    int defend(Unit enemy);

    int getStrength();

    int getToughness();

    UnitOwner getOwner();

    boolean isAlive();

    int getSightRadius();

    int getActionPoints();

    public Unit copy();
}
