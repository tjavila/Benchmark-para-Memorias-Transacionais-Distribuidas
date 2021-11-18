/*
 * Atomic RMI
 *
 * Copyright 2009-2010 Wojciech Mruczkiewicz <Wojciech.Mruczkiewicz@cs.put.poznan.pl>
 *                     Pawel T. Wojciechowski <Pawel.T.Wojciechowski@cs.put.poznan.pl>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 3, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details
 *
 * You should have received a copy of the GNU General Public
 * License along with this program; if not, write to the
 * Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package put.atomicrmi.optsva;

import java.rmi.RemoteException;

/**
 * This exception is thrown when rollback action was forced during method
 * invocation or commit when running a transaction.
 * 
 * @author Wojciech Mruczkiewicz
 */
public class RollbackForcedException extends RemoteException {

	/**
	 * Randomly generated serialization UID.
	 */
	private static final long serialVersionUID = -399169557402245639L;

	public RollbackForcedException() {
	}

	public RollbackForcedException(String message) {
		super(message);
	}

	public RollbackForcedException(String message, Throwable cause) {
		super(message, cause);
	}
}
