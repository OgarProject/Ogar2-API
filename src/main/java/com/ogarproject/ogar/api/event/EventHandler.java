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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Denotes a method that handles an event.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {

    /**
     * Specifies the priority of this event handler. For more information,
     * please see {@link com.ogarproject.ogar.api.event.EventPriority}.
     *
     * @return the event handler's priority
     */
    public EventPriority priority() default EventPriority.NORMAL;

    /**
     * If this value is set to true, this event handler will not be called if
     * the event has been previously cancelled by another event handler.
     *
     * @return boolean indicating whether or not cancelled events should be
     * ignored
     */
    public boolean ignoreCancelled() default false;
}
