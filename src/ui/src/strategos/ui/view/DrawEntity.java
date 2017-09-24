package strategos.ui.view;

import java.awt.*;

import strategos.MapLocation;
import strategos.UnitOwner;
import strategos.units.*;
import strategos.terrain.*;

import static strategos.ui.config.Config.HEX_SIZE;

/**
 * The type Entity image.
 */
class DrawEntity {

    Color npcColor = Color.YELLOW;
    Color otherPlayerColor = Color.RED;
    Color playerColor = Color.BLUE;

    /**
     * Draws Archers.
     *
     * @param archers to draw
     */
    public void draw(Archers archers, Graphics g) {
        MapLocation m = archers.getPosition();
        setUnitColor(archers, g);
        Point p = getUnitGridPos(m);
        g.fillOval(p.x, p.y , HEX_SIZE/2, HEX_SIZE/2);
        g.setColor(Color.BLACK);
        g.drawString("A", p.x, p.y);
    }

    /**
     * Draws A Cavalry.
     *
     * @param cavalry to draw
     */
    public void draw(Cavalry cavalry, Graphics g) {
        MapLocation m = cavalry.getPosition();
        setUnitColor(cavalry, g);
        Point p = getUnitGridPos(m);
        g.fillOval(p.x, p.y , HEX_SIZE/2, HEX_SIZE/2);
        g.setColor(Color.BLACK);
        g.drawString("C", p.x, p.y);
    }

    /**
     * Draws A Elite.
     *
     * @param elite to draw
     */
    public void draw(Elite elite, Graphics g) {
        MapLocation m = elite.getPosition();
        setUnitColor(elite, g);
        Point p = getUnitGridPos(m);
        g.fillOval(p.x, p.y , HEX_SIZE/2, HEX_SIZE/2);
        g.setColor(Color.BLACK);
        g.drawString("E", p.x, p.y);
    }

    /**
     * Draws A Spearmen.
     *
     * @param spearmen to draw
     */
    public void draw(Spearmen spearmen, Graphics g) {
        MapLocation m = spearmen.getPosition();
        setUnitColor(spearmen, g);
        Point p = getUnitGridPos(m);
        g.fillOval(p.x, p.y , HEX_SIZE/2, HEX_SIZE/2);
        g.setColor(Color.BLACK);
        g.drawString("Sp", p.x, p.y);
    }

    /**
     * Draws A Swordsmen.
     *
     * @param swordsmen to draw
     */
    public void draw(Swordsmen swordsmen, Graphics g) {
        MapLocation m = swordsmen.getPosition();
        setUnitColor(swordsmen, g);
        Point p = getUnitGridPos(m);
        g.fillOval(p.x, p.y , HEX_SIZE/2, HEX_SIZE/2);
        g.setColor(Color.BLACK);
        g.drawString("Sw", p.x, p.y);
    }

    /**
     * Draws A Forest.
     *
     * @param forest to draw
     */
    public void draw(Forest forest, Graphics g, int x, int y) {
        Point p = getTerrainGridPos(new Point(x,y));
        hexagon(g, p.x, p.y, new Color(0,150,0));
    }

    /**
     * Draws A Hill.
     *
     * @param hill to draw
     */
    public void draw(Hill hill, Graphics g, int x, int y) {
        Point p = getTerrainGridPos(new Point(x,y));
        hexagon(g, p.x, p.y, new Color(0,50,0));
    }

    /**
     * Draws Mountains.
     *
     * @param mountain to draw
     */
    public void draw(Mountain mountain, Graphics g, int x, int y) {
        Point p = getTerrainGridPos(new Point(x,y));
        hexagon(g, p.x, p.y, Color.LIGHT_GRAY);
    }

    /**
     * Draws a Plain.
     *
     * @param plains to draw
     */
    public void draw(Plains plains, Graphics g, int x, int y) {
        Point p = getTerrainGridPos(new Point(x,y));
        hexagon(g, p.x, p.y, new Color(0,255,0));
    }

    /**
     * Draws A River.
     *
     * @param river to draw
     */
    public void draw(River river, Graphics g, int x, int y) {
        Point p = getTerrainGridPos(new Point(x,y));
        hexagon(g, p.x, p.y, Color.CYAN);
    }


    private Point getTerrainGridPos (Point p) {
        int y = getGridY(p.y);
        int x = getGridX(p.x);
        if (p.getY() % 2 != 0) {
            x = getGridX(p.x)+HEX_SIZE/2;
        }
        return new Point(x,y);
    }

    private void setUnitColor(Unit unit, Graphics g) {
        UnitOwner owner = unit.getOwner();
        if (owner.isNPC()) {
            g.setColor(npcColor);
        } else if (owner.getUnits().contains(unit)) {
            g.setColor(playerColor);
        } else {
            g.setColor(otherPlayerColor);
        }
    }

    private Point getUnitGridPos (MapLocation m) {
        int y = getGridY(m.getY())+HEX_SIZE/4;
        int x = getGridX(m.getX())+HEX_SIZE/4;
        if (m.getY() % 2 != 0) {
            x = getGridX(m.getX())+HEX_SIZE/4*3;
        }
        return new Point(x,y);
    }

    //Credit: https://www.redblobgames.com/grids/hexagons/#hex-to-pixel for logic of hex to pixels
    protected int getGridY(int y) {
        return HEX_SIZE/2 * 3/2 * y;
    }

    protected int getGridX(int x) {
        return x * HEX_SIZE + HEX_SIZE;
    }

    protected void hexagon(Graphics g, int x, int y, Color c) {
        int nPoints = 6;
        int[] xPoints = {x, x+HEX_SIZE/2, x+HEX_SIZE, x+HEX_SIZE, x+HEX_SIZE/2, x, x};
        int[] yPoints = {y+HEX_SIZE/4, y, y+HEX_SIZE/4, y+HEX_SIZE/4*3, y+HEX_SIZE, y+HEX_SIZE/4*3, y+HEX_SIZE/4};
        g.setColor(c);
        g.fillPolygon(xPoints, yPoints, nPoints);
    }

}
