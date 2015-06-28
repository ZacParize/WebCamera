/**
 * Copyright (c) 2011, The University of Southampton and the individual contributors.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *   * 	Redistributions of source code must retain the above copyright notice,
 * 	this list of conditions and the following disclaimer.
 *
 *   *	Redistributions in binary form must reproduce the above copyright notice,
 * 	this list of conditions and the following disclaimer in the documentation
 * 	and/or other materials provided with the distribution.
 *
 *   *	Neither the name of the University of Southampton nor the names of its
 * 	contributors may be used to endorse or promote products derived from this
 * 	software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.mycompany.natives;

import org.bridj.Pointer;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.cpp.CPPObject;

import java.util.ArrayList;
import java.util.List;

@Library("OpenIMAJGrabber")
@SuppressWarnings("all")
public class DeviceList extends CPPObject {

	public DeviceList() {
		super();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DeviceList(Pointer pointer) {
		super(pointer);
	}

	@Field(0)
	protected int nDevices() {
		return this.io.getIntField(this, 0);
	}

	@Field(0)
	protected DeviceList nDevices(int nDevices) {
		this.io.setIntField(this, 0, nDevices);
		return this;
	}

	// / C type : Device**
	@Field(1)
	protected Pointer<Pointer<Device>> devices() {
		return this.io.getPointerField(this, 1);
	}

	// / C type : Device**
	@Field(1)
	protected DeviceList devices(Pointer<Pointer<Device>> devices) {
		this.io.setPointerField(this, 1, devices);
		return this;
	}

	public native int getNumDevices();

	public native Pointer<Device> getDevice(int i);

	public List<Device> asArrayList() {
		List<Device> devices = new ArrayList<Device>();

		for (int i = 0; i < getNumDevices(); i++) {
			devices.add(getDevice(i).get());
		}

		return devices;
	}
}
