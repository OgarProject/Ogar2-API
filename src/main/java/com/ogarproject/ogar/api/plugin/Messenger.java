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
/**
 * This file is part of Ogar.
 *
 * Ogar is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Ogar is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Ogar. If not, see <http://www.gnu.org/licenses/>.
 */
package com.ogarproject.ogar.api.plugin;

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.HashSet;
import java.util.Set;

/**
 * Messenger handles sending and receiving OMP messages to and from OMP-capable clients.
 */
public class Messenger {

    private final Multimap<Plugin, String> channelRegistrations = ArrayListMultimap.create();
    private final Set<String> allChannelRegistrations = new HashSet<>();

    public void registerChannel(Plugin plugin, String channelName) {
        Preconditions.checkNotNull(plugin, "plugin");
        Preconditions.checkNotNull(channelName, "channelName");
        Preconditions.checkArgument(plugin.isEnabled(), "Attempted to register an OMP channel for a disabled plugin");
        Preconditions.checkArgument(!channelName.toUpperCase().startsWith("OMP|") && !channelName.toUpperCase().startsWith("O2|"), "Attempted to register a reserved channel name");

        if (channelRegistrations.containsEntry(plugin, channelName)) {
            return;
        }

        channelRegistrations.put(plugin, channelName);
        allChannelRegistrations.add(channelName);
    }

    public void unregisterChannel(Plugin plugin, String channelName) {
        Preconditions.checkNotNull(plugin, "plugin");
        Preconditions.checkNotNull(channelName, "channelName");
        Preconditions.checkArgument(!channelName.toUpperCase().startsWith("OMP|") && !channelName.toUpperCase().startsWith("O2|"),
                "Attempted to unregister a reserved channel name");

        channelRegistrations.remove(plugin, channelName);
        if (!channelRegistrations.containsValue(channelName)) {
            allChannelRegistrations.remove(channelName);
        }
    }

    public void unregisterAll(Plugin plugin) {
        Preconditions.checkNotNull(plugin, "plugin");
        for (String channelName : channelRegistrations.get(plugin)) {
            unregisterChannel(plugin, channelName);
        }
    }

    public boolean isChannelRegistered(String channel) {
        return allChannelRegistrations.contains(channel);
    }

    public String[] getAllChannelRegistrations() {
        return allChannelRegistrations.toArray(new String[0]);
    }
}
