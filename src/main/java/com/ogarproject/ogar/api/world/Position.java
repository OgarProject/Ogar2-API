/**
 * This file is part of Ogar.
 *
 * Ogar is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Ogar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Ogar.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ogarproject.ogar.api.world;

public class Position {

    private double x;
    private double y;

    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Position multiply(double mx, double my) {
        return new Position(x * mx, y * my);
    }

    public Position divide(double dx, double dy) {
        return new Position(x / dx, y / dy);
    }

    public Position add(double ax, double ay) {
        return new Position(x + ax, y + ay);
    }

    public Position subtract(double sx, double sy) {
        return new Position(x - sx, y - sy);
    }

    public double distanceSquared(Position position) {
        return Math.pow(position.getX() - getX(), 2) + Math.pow(position.getY() - getY(), 2);
    }

    public double distance(Position position) {
        return Math.sqrt(distanceSquared(position));
    }

    public double distanceSquared(double ox, double oy) {
        return Math.pow(ox - getX(), 2) + Math.pow(oy - getY(), 2);
    }

    public double distance(double ox, double oy) {
        return Math.sqrt(distanceSquared(ox, oy));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Position{" + "x=" + x + ", y=" + y + '}';
    }
}
