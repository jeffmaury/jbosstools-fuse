/*******************************************************************************
 * Copyright (c) 2017 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.fuse.reddeer.component;

public class InOut implements CamelComponent {

	@Override
	public String getPaletteEntry() {
		return "In Out";
	}

	@Override
	public String getLabel() {
		return "inOut";
	}

	@Override
	public String getTooltip() {
		return null;
	}

}
