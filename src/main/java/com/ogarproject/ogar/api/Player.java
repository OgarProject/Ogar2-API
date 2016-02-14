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

import java.net.SocketAddress;

public interface Player extends CellOwner {

    public SocketAddress getAddress();

    /**
     * Checks if this client is compatible with the Ogar Mod Protocol (OMP).
     * OMP-capable clients must send an OMP message with channel name
     * "OMP|Capable" for this value to be properly set.
     *
     * @return true if the client is using the Ogar Mod Protocol
     */
    public boolean isPluginMessageCapable();

    /**
     * @see #sendPluginMessage(java.lang.String, byte[])
     */
    public default boolean sendPluginMessage(String channel) {
        return sendPluginMessage(channel, new byte[0]);
    }

    /**
     * Sends a plugin message to this client if the client is Ogar Mod Protocol
     * (OMP) capable. The channel must already be registered with
     * {@link com.ogarproject.ogar.api.plugin.Messenger}; if it is not, an
     * exception will be thrown.
     *
     * @param channel the channel name to use; must be registered with Messenger
     * @param data additional data, up to 32767 bytes
     * @return true if the message was sent, false if the client is not OMP
     * capable
     */
    public boolean sendPluginMessage(String channel, byte[] data);
}
