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
package com.ogarproject.ogar.api.event.player;

import com.ogarproject.ogar.api.event.Cancellable;
import com.ogarproject.ogar.api.event.Event;
import java.net.SocketAddress;

public class PlayerConnectingEvent extends Event implements Cancellable {

    private final SocketAddress address;
    private final int protocolVersion;
    private final String token;
    private boolean cancelled;

    public PlayerConnectingEvent(SocketAddress address, int protocolVersion, String token) {
        this.address = address;
        this.protocolVersion = protocolVersion;
        this.token = token;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public SocketAddress getAddress() {
        return address;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public String getToken() {
        return token;
    }

}
