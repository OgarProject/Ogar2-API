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
import java.util.logging.Logger;

/**
 * Singleton class for convenient access to the currently running Ogar server.
 */
public class Ogar {

    private static Server INSTANCE;

    /**
     * Static-use class.
     */
    private Ogar() {}

    public static void setServer(Server server) {
        if (INSTANCE != null) {
            throw new UnsupportedOperationException("Cannot redefine singleton server instance!");
        }

        INSTANCE = server;
    }

    public static Server getServer() {
        return INSTANCE;
    }

    public static Logger getLogger() {
        return INSTANCE.getLogger();
    }

    public static PluginManager getPluginManager() {
        return INSTANCE.getPluginManager();
    }

    public static Messenger getMessenger() {
        return INSTANCE.getMessenger();
    }
}
