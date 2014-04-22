/*******************************************************************************
 * Copyright (c) 2014 Salesforce.com, inc..
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Salesforce.com, inc. - initial API and implementation
 ******************************************************************************/
package com.salesforce.ide.ui.editors.apex.outline.text;

import apex.jorje.data.ast.FormalParameter;
import apex.jorje.data.ast.TypeRef;
import apex.jorje.services.printers.Printer;
import apex.jorje.services.printers.ast.ASTPrinterFactory;

/**
 * Prints just the type of the formal argument.
 * 
 * @author nchen
 * 
 */
final class OutlineViewFormalParameterPrinter implements Printer<FormalParameter> {

    private Printer<TypeRef> typeRefPrinter;

    public OutlineViewFormalParameterPrinter(ASTPrinterFactory astPrinterFactory) {
        this.typeRefPrinter = astPrinterFactory.typeRefPrinter();
    }

    @Override
    public String print(FormalParameter x) {
        try {
            return typeRefPrinter.print(x.type);
        } catch (NullPointerException npe) {
            return "";
        }
    }

}