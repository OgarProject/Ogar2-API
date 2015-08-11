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
package com.ogarproject.ogar.api.plugin;

import com.ogarproject.ogar.api.Server;
import java.util.logging.Logger;

public abstract class Plugin {

    private Server server;
    private PluginManager pluginManager;
    private boolean enabled = false;

    public void onEnable() {
        // To be overridden by implementations
    }

    public void onDisable() {
        // To be overridden by implementations
    }

    final void init(Server server, PluginManager pluginManager) {
        this.server = server;
        this.pluginManager = pluginManager;
    }

    final void setEnabled(boolean value) {
        if (enabled == value) {
            return;
        }

        boolean oldEnabled = enabled;
        enabled = value;
        if (oldEnabled && !value) {
            onDisable();
        } else if (!oldEnabled && value) {
            onEnable();
        }
    }

    public final Logger getLogger() {
        return server.getLogger();
    }

    public final PluginInfo getPluginInfo() {
        return getClass().getAnnotation(PluginInfo.class);
    }

    public final Server getServer() {
        return server;
    }

    public final PluginManager getPluginManager() {
        return pluginManager;
    }

    public final boolean isEnabled() {
        return enabled;
    }
}
