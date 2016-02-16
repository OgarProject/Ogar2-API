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

import com.ogarproject.ogar.api.plugin.Messenger;
import com.ogarproject.ogar.api.plugin.PluginManager;
import com.ogarproject.ogar.api.plugin.Scheduler;
import com.ogarproject.ogar.api.world.World;
import java.util.logging.Logger;

/**
 * A Server is the main interface to the rest of the API.
 */
public interface Server {

    /**
     * Gets the global logger instance used by the server.
     *
     * @return a Logger instance
     */
    public Logger getLogger();

    /**
     * Gets the server's plugin manager.
     *
     * @return plugin manager associated with the server
     */
    public PluginManager getPluginManager();

    /**
     * Gets the server's messenger.
     *
     * @return messenger associated with the server
     */
    public Messenger getMessenger();

    /**
     * Gets the server's world.
     *
     * @return world associated with the server
     */
    public World getWorld();

    /**
     * Gets the server's scheduler.
     *
     * @return scheduler associated with the server
     */
    public Scheduler getScheduler();
}
