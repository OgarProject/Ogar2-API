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
package com.ogarproject.ogar.api.entity;

import com.ogarproject.ogar.api.world.Position;
import com.ogarproject.ogar.api.world.World;
import java.awt.Color;

/**
 * An abstract class that describes an entity. An entity is any object in an
 * Agar.io world.
 */
public interface Entity {

    public World getWorld();

    public int getID();

    public EntityType getType();

    public Position getPosition();

    public void setPosition(Position position);

    public Color getColor();

    public void setColor(Color color);

    public int getPhysicalSize();

    public int getMass();

    public void setMass(int mass);

    public void addMass(int mass);

    public boolean isSpiked();

    public void setSpiked(boolean spiked);

}
