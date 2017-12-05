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
package org.fusesource.ide.camel.model.service.core.tests.integration.core.model;

import static org.fusesource.ide.preferences.PreferencesConstants.EDITOR_PREFERRED_LABEL;
import static org.junit.Assert.assertEquals;

import org.fusesource.ide.camel.model.service.core.catalog.eips.Eip;
import org.fusesource.ide.camel.model.service.core.model.AbstractCamelModelElement;
import org.fusesource.ide.camel.model.service.core.model.CamelBasicModelElement;
import org.fusesource.ide.preferences.PreferenceManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Andrej Podhradsky (apodhrad@redhat.com)
 *
 */
public class CamelBasicModelElementTestIT {

	private String originalPreference;

	@Before
	public void cleanUserLabelsPreference() {
		originalPreference = PreferenceManager.getInstance().loadPreferenceAsString(EDITOR_PREFERRED_LABEL);
		PreferenceManager.getInstance().savePreference(EDITOR_PREFERRED_LABEL, "");
	}

	@After
	public void setBackOriginalLabelsPreference() {
		PreferenceManager.getInstance().savePreference(EDITOR_PREFERRED_LABEL, originalPreference);
	}

	@Test
	public void testDisplayingDefaultText() {
		assertEquals("Log coolName", simpleLog().getDisplayText());
	}

	@Test
	public void testDisplayingUserText() {
		PreferenceManager.getInstance().savePreference(EDITOR_PREFERRED_LABEL, "log.message");
		assertEquals("Log ${body}", simpleLog().getDisplayText());
	}

	private AbstractCamelModelElement simpleLog() {
		Eip eip = new Eip();
		eip.setName("log");

		AbstractCamelModelElement element = new CamelBasicModelElement(null, null);
		element.setId("_log1");
		element.setParameter("logName", "coolName");
		element.setParameter("message", "${body}");
		element.setUnderlyingMetaModelObject(eip);

		return element;
	}

}
