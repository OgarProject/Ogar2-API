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
package com.ogarproject.ogar.api.event;

/**
 * Used to set the priority of an {@link EventHandler}. Events are executed in
 * the following order:
 * <ol>
 * <li>LOWEST</li>
 * <li>LOW</li>
 * <li>NORMAL</li>
 * <li>HIGH</li>
 * <li>HIGHEST</li>
 * <li>MONITOR</li>
 * </ol>
 *
 * By default, EventHandler priorities are set to {@code NORMAL}. Events that
 * are being handled on priority {@code MONITOR} should <b>not</b>, in any way,
 * modify the outcome of the event. This priority is used for handlers that wish
 * to listen for the final outcome of the event.
 */
public enum EventPriority {

    LOWEST, LOW, NORMAL, HIGH, HIGHEST, MONITOR;
}
