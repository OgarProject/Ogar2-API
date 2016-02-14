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
package com.ogarproject.ogar.api;

import com.ogarproject.ogar.api.entity.Cell;
import java.util.Collection;

/**
 * CellOwner is an interface implemented by all cell owners. In the default Ogar
 * implementation, this interface is only implemented by Player. However, it can
 * be extended by plugins to allow for bots, among other uses.
 */
public interface CellOwner {

    /**
     * Gets the name of this cell owner. This name is independent of the name of
     * the owner's cells; although all new cells formed by this owner will use
     * this name as a default, the name of each cell can be controlled
     * individually.
     *
     * @return the owner's name
     */
    public String getName();

    /**
     * Sets this owner's name. This name is independent of the name of the
     * owner's cells; as such, using this method will not rename current cells,
     * but only set the default name of future cells.
     *
     * @param name
     */
    public void setName(String name);

    /**
     * Gets all cells that belong to this owner. The collection returned may be
     * immutable.
     *
     * @return a collection of cells belonging to this owner
     */
    public Collection<Cell> getCells();

    /**
     * Adds a cell to this owner.
     *
     * @param cell the cell to add
     */
    public void addCell(Cell cell);

    /**
     * Removes a cell from this owner.
     *
     * @param cell the cell to remove
     */
    public void removeCell(Cell cell);

    /**
     * Removes a cell with the specified entity ID from this owner.
     *
     * @param id the entity ID of the cell to remove
     */
    public void removeCell(int id);
}
